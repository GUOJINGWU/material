package com.youzhicai.materialstore.web.controller;


import java.io.File;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youzhicai.materialstore.web.util.ConfigUtil;


@Controller
@RequestMapping("download")
public class DownloadController {

    /**
     * 通用文件下载
     * @param fileName
     * @return
     * @throws IOException
     */
    @RequestMapping("/getfile")
    public ResponseEntity<InputStreamResource> getFile(String fileName) throws IOException {
        File files = ResourceUtils
                .getFile(ResourceUtils.CLASSPATH_URL_PREFIX + ConfigUtil.getValue("downloeadPath") + fileName);
        FileSystemResource file = new FileSystemResource(files);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok().headers(headers).contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
