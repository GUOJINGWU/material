/**  
 * @Title: FileController.java
 * @Package com.youzhicai.materialstore.web.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月13日 下午6:18:19
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youzhicai.materialstore.web.domain.AuthInfo;
import com.youzhicai.materialstore.web.domain.BaseAttachModel;
import com.youzhicai.materialstore.web.util.ConfigUtil;
import com.youzhicai.materialstore.web.util.Dirs;
import com.youzhicai.materialstore.web.util.FileUtil;
import com.youzhicai.materialstore.web.util.HttpPostUploadUtil;
import com.youzhicai.materialstore.web.util.HttpUtils;

/**
 * @ClassName: FileController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月13日 下午6:18:19
 */
@Controller
@RequestMapping("web/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

//    @RequestMapping("download")
//    public ResponseEntity<InputStreamResource> getFile(String fileName) throws IOException {
//        File files = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + ConfigUtil.getValue("downloeadPath") + fileName);
//        FileSystemResource file = new FileSystemResource(files);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
//        headers.add("Pragma", "no-cache");
//        headers.add("Expires", "0");
//        return ResponseEntity.ok().headers(headers).contentLength(file.contentLength())
//                .contentType(MediaType.parseMediaType("application/octet-stream")).body(new InputStreamResource(file.getInputStream()));
//    }

    @RequestMapping("download")
    public ResponseEntity<InputStreamResource> getFile(String fileName) throws Exception {
        // 获取容器资源解析器
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 获取所有匹配的文件
        Resource[] resources = resolver.getResources(ConfigUtil.getValue("downloeadPath") + fileName);
        if (resources == null || resources.length < 1) {
            return null;
        }
        Resource resource = resources[0];

        // 获得文件流，因为在jar文件中，不能直接通过文件资源路径拿到文件，但是可以在jar包中拿到文件流
        InputStream stream = resource.getInputStream();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", fileName));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(stream));
    }

    @RequestMapping("upload")
    @ResponseBody
    public Object upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();

        if (file != null && !file.isEmpty()) {
            // 保存文件至本地
            String path = ConfigUtil.getValue("localFilePath");
            Dirs.mkdirs(path);
            String fileName = new StringBuffer().append(System.currentTimeMillis()).append("_").append(file.getOriginalFilename()).toString();
            File tarFile = new File(path, fileName);
            file.transferTo(tarFile);

            // 上传至文件服务器
            String attRelaId = uploadFile(request, tarFile);

            // 查询文件ID
            if (StringUtils.isNotBlank(attRelaId)) {
                String postUrl = ConfigUtil.getValue("fileUploadApiURL") + "/fileService/getFileListByRelaId.yzc?attRelaId=" + attRelaId;
                List<BaseAttachModel> dataList = HttpUtils.postUrlListByModel(postUrl, attRelaId, BaseAttachModel.class);
                if (logger.isInfoEnabled()) {
                    logger.info(postUrl);
                }
                if (null != dataList && (!dataList.isEmpty())) {
                    String fileId;
                    result.put("attRelaId", attRelaId);
                    result.put("fileId", fileId = dataList.get(0).getId());
                    result.put("fileUpdateUrl", ConfigUtil.getValue("fileServiceURL") + "/fileUpload/download.do?id=" + fileId);
                    result.put("filePreviewUrl", ConfigUtil.getValue("fileServiceURL") + "/fileService/preview.yzc?id=" + fileId);
                    result.put("fileShowUrl", ConfigUtil.getValue("fileServiceURL") + "/image/showImage.yzc?attId=" + fileId);
                }
                if (tarFile.exists()) {
                    tarFile.delete();// 删除临时文件
                }
            }
        }

        return result;
    }

    /*
     * 上传附件
     */
    private String uploadFile(HttpServletRequest request, File file) throws Exception {
        AuthInfo auth = (AuthInfo) request.getSession().getAttribute(ConfigUtil.getValue("AuthInfo")); // 当前用户信息

        String attRelaId = UUID.randomUUID().toString();

        StringBuffer url = new StringBuffer(ConfigUtil.getValue("fileUploadApiURL") + "/fileUpload/ajaxUpload.do");
        url.append("?savePath=").append("materialstore-web/").append("&attRelaId=").append(attRelaId).append("&isSingle=").append(1)
                .append("&suffix=").append(FileUtil.getFileNameSuffix(file.getName())).append("&createUserId=").append(auth.getUser_ID())
                .append("&createUserName=").append(auth.getUser_ID());

        String sendUrl;
        HttpPostUploadUtil post = new HttpPostUploadUtil((sendUrl = url.toString()));
        post.addParameter("file", file);
        String cookies;
        String send = post.send((cookies = loginUserCookies(request)));
        if (logger.isInfoEnabled()) {
            logger.info(sendUrl);
        }
        JSONObject parseObject = JSON.parseObject(send);
        if (null != parseObject && "success".equals(parseObject.get("status"))) {
            return attRelaId;
        }
        return null;
    }

    /*
     * 封装登录用户相关Cookie
     */
    private String loginUserCookies(HttpServletRequest request) {
        StringBuffer cookieBuffer = new StringBuffer();
        List<String> cookieNames = Arrays.asList(
                new String[] { "CompanyID", "IsShowMsg", "Name", "RandomNum", "SessionId", "SessionKey", "SessionUserName", "Site", "SSOInfo" });
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookieNames.contains(cookie.getName())) {
                    cookieBuffer.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
                }
            }
        }
        return cookieBuffer.toString();
    }

}
