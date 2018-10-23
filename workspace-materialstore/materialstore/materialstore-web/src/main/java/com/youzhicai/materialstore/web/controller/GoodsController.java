/**  
 * @Title: GoodsController.java
 * @Package com.youzhicai.materialstore.web.controller
 * @Description: 物资
 * @author XieXianpeng
 * @date 2018年10月9日 下午4:40:44
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.youzhicai.materialstore.api.GoodsAPI;
import com.youzhicai.materialstore.api.GoodsTypeAPI;
import com.youzhicai.materialstore.common.constant.ParamLength;
import com.youzhicai.materialstore.common.exception.BusinessException;
import com.youzhicai.materialstore.common.util.POUtil;
import com.youzhicai.materialstore.common.util.Strings;
import com.youzhicai.materialstore.dto.GoodsApproveDTO;
import com.youzhicai.materialstore.dto.GoodsDTO;
import com.youzhicai.materialstore.dto.GoodsExcelDTO;
import com.youzhicai.materialstore.dto.GoodsSupplyDTO;
import com.youzhicai.materialstore.dto.GoodsTypeDTO;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.vo.GoodsApproveVO;
import com.youzhicai.materialstore.vo.GoodsSearchVO;
import com.youzhicai.materialstore.vo.GoodsTypeVO;
import com.youzhicai.materialstore.vo.GoodsVO;
import com.youzhicai.materialstore.web.api.transfer.DataTransfer;
import com.youzhicai.materialstore.web.api.transfer.TransferType;
import com.youzhicai.materialstore.web.domain.AuthInfo;
import com.youzhicai.materialstore.web.model.GoodsAddModel;
import com.youzhicai.materialstore.web.model.GoodsDeleteModel;
import com.youzhicai.materialstore.web.model.GoodsExcelLineModel;
import com.youzhicai.materialstore.web.model.GoodsSearchModel;
import com.youzhicai.materialstore.web.model.GoodsTypeSubTypeModel;
import com.youzhicai.materialstore.web.util.ConfigUtil;
import com.youzhicai.materialstore.web.util.DESUtil;
import com.youzhicai.materialstore.web.util.ExcelUtil;

/**
 * @ClassName: GoodsController
 * @Description: 物资
 * @author XieXianpeng
 * @date 2018年10月9日 下午4:40:44
 */
@Controller
@RequestMapping("web/goods")
public class GoodsController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodsAPI goodsAPI;

    @Autowired
    private GoodsTypeAPI goodsTypeAPI;

    /**
     * @Title: nextGoodsCode
     * @Description: 获取最新物资编码
     * @param goodsTypeSubTypeModel
     * @return Object
     */
    @RequestMapping(value = "nextGoodsCode")
    @ResponseBody
    public Object nextGoodsCode(@RequestBody GoodsTypeSubTypeModel goodsTypeSubTypeModel) {
        GoodsDTO goodsDTO = goodsWithUser(false, false);

        goodsDTO.setTid(goodsTypeSubTypeModel.getPid());
        Map<String, Object> nextGoodsCode = goodsAPI.nextGoodsCode(goodsDTO);
        return nextGoodsCode;
    }

    /**
     * @Title: searchMaterialTable
     * @Description: 列表搜索栏
     * @param goodsSearchModel
     * @throws Exception
     * @return Object
     */
    @RequestMapping(value = "searchtable", method = RequestMethod.POST)
    @ResponseBody
    public Object searchMaterialTable(@RequestBody GoodsSearchModel goodsSearchModel) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        Integer used = goodsSearchModel.getUsed();
        Integer pageNum = goodsSearchModel.getPageNum();
        Integer pageSize = goodsSearchModel.getPageSize();
        String nameOrCode = goodsSearchModel.getNameOrCode();
        Long tid = goodsSearchModel.getTid();
        Integer approveStatus = goodsSearchModel.getApproveStatus();

        // 查询物资分页列表
        GoodsDTO goodsDTO = goodsWithUser(false, false);
        goodsDTO.setUsed(used);
        goodsDTO.setPageNum(pageNum == null ? 1 : pageNum);
        goodsDTO.setPageSize(pageSize == null ? 10 : pageSize);
        goodsDTO.setNameOrCode(StringUtils.isEmpty(nameOrCode) ? null : nameOrCode);
        goodsDTO.setTid(tid);
        goodsDTO.setGoodsApprove(approveStatus == null ? null : new GoodsApproveDTO(approveStatus));
        goodsDTO.setIsGidDes(true);
        Page<GoodsSearchVO> searchList = goodsAPI.findGoodsListForSearch(goodsDTO);

        if (searchList == null || searchList.getList() == null || searchList.getList().isEmpty()) {
            Integer pNum = goodsDTO.getPageNum();
            if (pNum > 1) {
                goodsDTO.setPageNum(pNum - 1);
                searchList = goodsAPI.findGoodsListForSearch(goodsDTO);
            }
        }

        result.put("searchList", searchList);

        // 查询启用物资及停用物资数量
        Map<String, Object> usedOrNotCount = goodsAPI.countForUsedOrNot(goodsDTO);
        result.put("usedOrNotCount", usedOrNotCount);

        return result;
    }

    /**
     * @Title: addMaterial
     * @Description: 新增物资
     * @param goodsAddModel
     * @return Object
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object addMaterial(@RequestBody GoodsAddModel goodsAddModel) {
        // 物资信息
        GoodsDTO goodsDTO = goodsWithUser(true, false);
        goodsDTO.setBrand(goodsAddModel.getBrand());
        goodsDTO.setCode(goodsAddModel.getCode());
        goodsDTO.setLink(goodsAddModel.getLink());
        goodsDTO.setName(goodsAddModel.getName());
        goodsDTO.setRemarks(goodsAddModel.getRemarks());
        goodsDTO.setSpecifications(goodsAddModel.getSpecifications());
        goodsDTO.setTid(goodsAddModel.getTid());
        goodsDTO.setUnit(goodsAddModel.getUnit());
        goodsDTO.setUsed(goodsAddModel.getUsed());

        // 扩展属性
        List<GoodsSupplyDTO> goodsSupplys = new ArrayList<GoodsSupplyDTO>();
        List<String> supplyNames;
        List<String> supplyValues;
        if ((supplyNames = goodsAddModel.getSupplyNames()) != null && !supplyNames.isEmpty()
                && (supplyValues = goodsAddModel.getSupplyValues()) != null && !supplyValues.isEmpty()) {
            if (supplyNames.size() == supplyValues.size()) {
                for (int i = 0; i < supplyNames.size(); i++) {
                    goodsSupplys.add(new GoodsSupplyDTO(1, supplyNames.get(i), supplyValues.get(i)));
                }
                goodsDTO.setGoodsSupplys(goodsSupplys);
            } else {
                // 异常
            }
        }

        // 图片
        List<String> imgNames;
        List<String> imgValues;
        if ((imgNames = goodsAddModel.getImgNames()) != null && !imgNames.isEmpty() && (imgValues = goodsAddModel.getImgValues()) != null
                && !imgValues.isEmpty()) {
            for (int i = 0; i < imgNames.size(); i++) {
                goodsSupplys.add(new GoodsSupplyDTO(2, imgNames.get(i), imgValues.get(i)));
            }
        }

        // 审核信息
        GoodsApproveDTO goodsApproveDTO = new GoodsApproveDTO();
        goodsApproveDTO.setApproveStatus(goodsAddModel.getApproveStatus());
        goodsDTO.setGoodsApprove(goodsApproveDTO);

        Map<String, Object> result = new HashMap<String, Object>();
        boolean addGoods = false;
        Integer errCode = 1000;
        String errMsg = "";

        Long newGoodsIdParam;
        if ((newGoodsIdParam = goodsAddModel.getNewGoodsId()) != null && newGoodsIdParam > 0) {
            // 修改操作
            goodsDTO.setNewGoodsId(newGoodsIdParam);
            try {
                addGoods = goodsAPI.modifyGoods(goodsDTO);
                if (addGoods) {
                    result.put("newGid", DESUtil.encryptStr(String.valueOf(newGoodsIdParam)));
                }
            } catch (Exception e) {
                if (e instanceof BusinessException) {
                    errCode = ((BusinessException) e).getCode();
                    errMsg = ((BusinessException) e).getMsg();
                    System.out.println("code:" + errCode + "  " + "msg:" + ((BusinessException) e).getMsg());
                } else {
                    errCode = TransferType.ERROR.getCode();
                    errMsg = TransferType.ERROR.getMsg();
                }
                e.printStackTrace();
            }
        } else {
            // 新增
            long newGoodsId = 0L;
            try {
                newGoodsId = goodsAPI.addGoods(goodsDTO);
            } catch (Exception e) {
                if (e instanceof BusinessException) {
                    errCode = ((BusinessException) e).getCode();
                    errMsg = ((BusinessException) e).getMsg();
                    System.out.println("code:" + errCode + "  " + "msg:" + ((BusinessException) e).getMsg());
                } else {
                    errCode = TransferType.ERROR.getCode();
                    errMsg = TransferType.ERROR.getMsg();
                }
                e.printStackTrace();
            }
            if (newGoodsId > 0L) {
                addGoods = true;
                result.put("newGoodsId", newGoodsId);
            }
        }

        System.out.println(JSON.toJSON(goodsAddModel));

        result.put("addStatus", addGoods);
        result.put("errCode", errCode);
        result.put("errMsg", errMsg);

        return result;
    }

    /**
     * @Title: deleteMaterial
     * @Description: 删除物资
     * @param goodsDeleteModel
     * @return Object
     */
    @RequestMapping("delete")
    @ResponseBody
    public Object deleteMaterial(@RequestBody GoodsDeleteModel goodsDeleteModel) {
        Long id = null;
        try {
            id = Strings.str2Long(DESUtil.decryptStr(goodsDeleteModel.getGid()));
        } catch (Exception e) {
        }
        if (id == null) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
        }

        // 查询详情
        GoodsDTO queryGoodsDTO = goodsWithUser(false, false);
        queryGoodsDTO.setId(id);
        GoodsVO goodsVO = goodsAPI.findGoodsDetail(queryGoodsDTO);
        // 审核状态物资跳转至查看页
        GoodsApproveVO goodsApprove;
        Integer approveStatus;
        if (goodsVO == null || (goodsApprove = goodsVO.getGoodsApprove()) == null || (approveStatus = goodsApprove.getApproveStatus()) == null
                || approveStatus == 21) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
        }

        GoodsDTO goodsDTO = goodsWithUser(false, true);
        goodsDTO.setId(id);
        if (goodsAPI.deleteGoods(goodsDTO)) {
            return new DataTransfer<>(TransferType.SUCCESS.getCode(), TransferType.SUCCESS.getMsg());
        }

        return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
    }

    /**
     * @Title: materialTable
     * @Description: 物资列表页
     * @param model
     * @throws Exception
     * @return String
     */
    @RequestMapping("table")
    public String materialTable(Model model) throws Exception {
        // 查询物资分页列表
        GoodsDTO goodsDTO = goodsWithUser(false, false);
        goodsDTO.setPageNum(1);
        goodsDTO.setPageSize(10);
        goodsDTO.setIsGidDes(true);
        goodsDTO.setUsed(1);
        Page<GoodsSearchVO> searchList = goodsAPI.findGoodsListForSearch(goodsDTO);
        model.addAttribute("searchList", searchList);

        // 查询启用物资及停用物资数量
        Map<String, Object> usedOrNotCount = goodsAPI.countForUsedOrNot(goodsDTO);
        model.addAttribute("usedOrNotCount", usedOrNotCount);

        // 物资状态列表
        model.addAttribute("approveStatusList", goodsAPI.goodsApproveStatusList());

        // 一级分类
        GoodsTypeDTO firstGoodsTypeDTO = goodsTypeWithUser(false, false);
        firstGoodsTypeDTO.setPid(0L);
        List<GoodsTypeVO> firstRankTypes = goodsTypeAPI.subtypeList(firstGoodsTypeDTO);
        model.addAttribute("firstRankTypes", firstRankTypes);

        // 是否展示新增物资入口
        boolean showAddGoods = false;
        try {
            AuthInfo auth = (AuthInfo) request.getSession().getAttribute(ConfigUtil.getValue("AuthInfo"));
            HashMap<Integer, HashMap<Integer, ArrayList<String>>> permissions = auth.getPermissions();
            showAddGoods = permissions.get(624).get(1) != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("showAddGoods", showAddGoods);

        return "materialGoods/materialTable";
    }

    /**
     * @Title: toAddMaterial
     * @Description: 新增物资页
     * @param model
     * @return String
     */
    @RequestMapping("toadd")
    public String toAddMaterial(Model model) {
        // 一级菜单
        GoodsTypeDTO firstGoodsTypeDTO = goodsTypeWithUser(false, false);
        firstGoodsTypeDTO.setPid(0L);
        List<GoodsTypeVO> firstRankTypes = goodsTypeAPI.subtypeList(firstGoodsTypeDTO);
        model.addAttribute("firstRankTypes", firstRankTypes);

        return "materialGoods/materialAdd";
    }

    /**
     * @Title: view
     * @Description: 查看物资页
     * @param model
     * @param gid
     * @return String
     */
    @RequestMapping("view")
    public String view(Model model, String gid) {
        Long id = null;
        try {
            id = Strings.str2Long(DESUtil.decryptStr(gid));
        } catch (Exception e) {
        }

        // 查询详情
        GoodsDTO goodsDTO = goodsWithUser(false, false);
        goodsDTO.setId(id);
        goodsDTO.setIsDiffSupplys(true);
        GoodsVO goodsVO = goodsAPI.findGoodsDetail(goodsDTO);

        System.out.println(JSON.toJSON(goodsVO));
        if (goodsVO == null) {
            goodsVO = new GoodsVO();
            goodsVO.setGoodsSupplys(new ArrayList<>());
            goodsVO.setGoodsApprove(new GoodsApproveVO());
        }

        model.addAttribute("goodsVO", goodsVO);
        model.addAttribute("showImageUrl", ConfigUtil.getValue("fileServiceURL") + "/image/showImage.yzc?attId=");

        return "materialGoods/materialView";
    }

    /**
     * @Title: toModify
     * @Description: 修改物资页
     * @param model
     * @param gid
     * @return String
     */
    @RequestMapping("tomodify")
    public String toModify(Model model, String gid) {
        Long id = null;
        try {
            id = Strings.str2Long(DESUtil.decryptStr(gid));
        } catch (Exception e) {
        }

        // 查询详情
        GoodsDTO goodsDTO = goodsWithUser(false, false);
        goodsDTO.setId(id);
        goodsDTO.setIsDiffSupplys(true);
        GoodsVO goodsVO = goodsAPI.findGoodsDetail(goodsDTO);
        // 审核状态物资跳转至查看页
        GoodsApproveVO goodsApprove;
        Integer approveStatus;
        if (goodsVO == null || (goodsApprove = goodsVO.getGoodsApprove()) == null || (approveStatus = goodsApprove.getApproveStatus()) == null
                || approveStatus == 21) {
            return "redirect:/web/goods/view?gid=" + gid;
        }

        model.addAttribute("goodsVO", goodsVO);
        model.addAttribute("showImageUrl", ConfigUtil.getValue("fileServiceURL") + "/image/showImage.yzc?attId=");

        // 一级分类
        GoodsTypeDTO firstGoodsTypeDTO = goodsTypeWithUser(false, false);
        firstGoodsTypeDTO.setPid(0L);
        List<GoodsTypeVO> firstRankTypes = goodsTypeAPI.subtypeList(firstGoodsTypeDTO);
        model.addAttribute("firstRankTypes", firstRankTypes);

        return "materialGoods/materialModify";
    }

    /**
     * @Title: importGoods
     * @Description: 导入物资页
     * @param model
     * @param gid
     * @return String
     */
    @RequestMapping("import")
    public String importGoods(Model model, String gid) {
        return "materialGoods/materialImport";
    }

    /**
     * @Title: BatchImportExcel
     * @Description: 导入物资
     * @param file
     * @return Object
     */
    @RequestMapping(value = "importexcel")
    @ResponseBody
    public Object BatchImportExcel(@RequestParam(value = "fileExcel", required = true) MultipartFile file) {
        List<List<Object>> listob = null;
        try {
            // 转换excel
            if (file != null && !file.isEmpty()) {
                InputStream in = file.getInputStream();
                String fileName = file.getOriginalFilename();
                if (StringUtils.isEmpty(fileName)) {
                    return new DataTransfer<>(TransferType.ERROR.getCode(), "文件名无效");
                }
                String suffix = fileName.substring(fileName.indexOf("."), fileName.length());
                if (!".xls".equals(suffix.toLowerCase()) && !".xlsx".equals(suffix.toLowerCase())) {
                    return new DataTransfer<>(TransferType.ERROR.getCode(), "文件格式不正确，请下载系统模板重新导入");
                }
                listob = new ExcelUtil().ReadExcel(in, fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<GoodsExcelDTO> excelGoodsList = null;
        try {
            // 收集excel
            if (listob == null) {
                return new DataTransfer<>(TransferType.ERROR.getCode(), "信息读取错误，请稍后再试！");
            }
            Object excelToObjs = excelToObjs(listob);
            if (excelToObjs instanceof DataTransfer) {
                return excelToObjs;
            }
            excelGoodsList = POUtil.convert((List<GoodsExcelLineModel>) excelToObjs, GoodsExcelDTO.class, new TypeToken<List<GoodsExcelDTO>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 保存excel数据
            if (excelGoodsList == null || excelGoodsList.isEmpty()) {
                return new DataTransfer<>(TransferType.ERROR.getCode(), "信息读取错误，请稍后再试！");
            }
            GoodsDTO goodsDTO = goodsWithUser(true, false);
            goodsDTO.setExcelGoodsList(excelGoodsList);
            Map<String, Object> map = goodsAPI.saveExcelGoods(goodsDTO);
            if (map != null) {
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
    }

    /*
     * 收集excel数据
     */
    private Object excelToObjs(List<List<Object>> listob) {
        if (!"物资列表".equals(listob.get(0).get(0))) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), "导入文件不符合要求，请重新下载模板填写！");
        }
        if (listob.size() <= 3) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), "不可导入空文件，请填写后再上传！");
        }

        List<GoodsExcelLineModel> result = new ArrayList<GoodsExcelLineModel>();
        GoodsExcelLineModel goodsExcelLine;
        DataTransfer<?> paramsNull;
        DataTransfer<?> paramsLimit;
        List<List<Object>> subList = new ArrayList<List<Object>>();
        for (List<Object> list : listob.subList(3, listob.size())) {
            subList.add(list);
        }
        for (int j = 0; j < subList.size(); j++) {
            List<Object> line = subList.get(j);

            if (line == null || line.isEmpty()) {
                continue;
            }
            goodsExcelLine = new GoodsExcelLineModel();
            for (int i = 0; i < line.size(); i++) {
                Object obj = line.get(i);
                String cell;
                switch (i) {
                case 0:// *物资名称
                    if ((paramsNull = excelParamsNull(obj, j, "物资名称")).getCode() == TransferType.ERROR.getCode()) {
                        return paramsNull;
                    }
                    cell = Strings.trim((String) obj);
                    if ((paramsLimit = excelParamsLimit(cell, ParamLength.GOODS_NAME, j, "物资名称")).getCode() == TransferType.ERROR.getCode()) {
                        return paramsLimit;
                    }
                    goodsExcelLine.setName(cell);
                    break;
                case 1:// *一级分类
                    if ((paramsNull = excelParamsNull(obj, j, "一级分类")).getCode() == TransferType.ERROR.getCode()) {
                        return paramsNull;
                    }
                    cell = Strings.trim((String) obj);
                    goodsExcelLine.setFirstRankName(cell);
                    break;
                case 2:// *二级分类
                    if ((paramsNull = excelParamsNull(obj, j, "二级分类")).getCode() == TransferType.ERROR.getCode()) {
                        return paramsNull;
                    }
                    cell = Strings.trim((String) obj);
                    goodsExcelLine.setSecondRankName(cell);
                    break;
                case 3:// *三级分类
                    if ((paramsNull = excelParamsNull(obj, j, "三级分类")).getCode() == TransferType.ERROR.getCode()) {
                        return paramsNull;
                    }
                    cell = Strings.trim((String) obj);
                    goodsExcelLine.setThirdRankName(cell);
                    break;
                case 4:// *计量单位
                    if ((paramsNull = excelParamsNull(obj, j, "计量单位")).getCode() == TransferType.ERROR.getCode()) {
                        return paramsNull;
                    }
                    cell = Strings.trim((String) obj);
                    if ((paramsLimit = excelParamsLimit(cell, ParamLength.GOODS_UNIT, j, "计量单位")).getCode() == TransferType.ERROR.getCode()) {
                        return paramsLimit;
                    }
                    goodsExcelLine.setUnit(cell);
                    break;
                case 5:// *使用状态
                    if ((paramsNull = excelParamsNull(obj, j, "使用状态")).getCode() == TransferType.ERROR.getCode()) {
                        return paramsNull;
                    }
                    cell = Strings.trim((String) obj);
                    if ("启用".equals(cell)) {
                        goodsExcelLine.setUsed(1);
                    } else if ("停用".equals(cell)) {
                        goodsExcelLine.setUsed(0);
                    } else {
                        return new DataTransfer<>(TransferType.ERROR.getCode(), "第" + (i + 4) + "行，物资启用状态填写异常，请重新确认后提交！");
                    }
                    break;
                case 6:// 材质/品牌
                    if (obj != null) {
                        cell = Strings.trim((String) obj);
                        if ((paramsLimit = excelParamsLimit(cell, ParamLength.GOODS_BRAND, j, "材质/品牌")).getCode() == TransferType.ERROR.getCode()) {
                            return paramsLimit;
                        }
                        goodsExcelLine.setBrand(cell);
                    }
                    break;
                case 7:// 规格/型号
                    if (obj != null) {
                        cell = Strings.trim((String) obj);
                        if ((paramsLimit = excelParamsLimit(cell, ParamLength.GOODS_SPECIFICATIONS, j, "规格/型号")).getCode() == TransferType.ERROR
                                .getCode()) {
                            return paramsLimit;
                        }
                        goodsExcelLine.setSpecifications(cell);
                    }
                    break;
                case 8:// 属性
                    if (obj != null) {
                        cell = Strings.trim((String) obj);
                        String[] attrs = cell.split("&");
                        if (attrs != null && attrs.length > 0) {
                            List<GoodsSupplyDTO> goodsSupplys = new ArrayList<GoodsSupplyDTO>();
                            for (String attr : attrs) {
                                if (StringUtils.isEmpty(attr)) {
                                    continue;
                                }
                                String[] kvs = attr.split("=");
                                if (kvs != null && kvs.length == 2) {
                                    goodsSupplys.add(new GoodsSupplyDTO(1, kvs[0], kvs[1]));
                                }
                            }
                            goodsExcelLine.setGoodsSupplys(goodsSupplys);
                        }
                    }
                    break;
                case 9:// 补充说明
                    if (obj != null) {
                        cell = Strings.trim((String) obj);
                        if ((paramsLimit = excelParamsLimit(cell, ParamLength.GOODS_REMARKS, j, "补充说明")).getCode() == TransferType.ERROR.getCode()) {
                            return paramsLimit;
                        }
                        goodsExcelLine.setRemarks(cell);
                    }
                    break;
                case 10:// 相关链接
                    if (obj != null) {
                        cell = Strings.trim((String) obj);
                        goodsExcelLine.setLink(cell);
                    }
                    break;
                default:
                    break;
                }
            }
            result.add(goodsExcelLine);
        }
        return result;
    }

    /*
     * 判断excel参数是否空值
     */
    private DataTransfer<?> excelParamsNull(Object obj, int lineNum, String msg) {
        if ((obj == null || StringUtils.isEmpty(Strings.trim((String) obj)))) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), "第" + (lineNum + 4) + "行，未填写" + msg + "，请重新填写!");
        }
        return new DataTransfer<>(TransferType.SUCCESS.getCode(), TransferType.SUCCESS.getMsg());
    }

    /*
     * 判断excel参数长度
     */
    private DataTransfer<?> excelParamsLimit(String cell, ParamLength paramLength, int lineNum, String msg) {
        if (cell.length() > paramLength.getValue()) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), "第" + (lineNum + 4) + "行，" + msg + "长度过长，请重新填写后提交！");
        }
        return new DataTransfer<>(TransferType.SUCCESS.getCode(), TransferType.SUCCESS.getMsg());
    }

    /*
     * 封装物资传输用户信息
     */
    private GoodsDTO goodsWithUser(boolean create, boolean update) {
        AuthInfo auth = (AuthInfo) request.getSession().getAttribute(ConfigUtil.getValue("AuthInfo"));
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setCompanyId(auth.getUser_ID());
        goodsDTO.setCompanyName(auth.getSubName());
        if (create) {
            goodsDTO.setCreateId(auth.getId());
            goodsDTO.setCreator(auth.getUserName());
        }
        if (update) {
            goodsDTO.setUpdateId(auth.getId());
            goodsDTO.setUpdator(auth.getUserName());
        }
        return goodsDTO;
    }

    /*
     * 封装物资类型传输用户信息
     */
    private GoodsTypeDTO goodsTypeWithUser(boolean create, boolean update) {
        AuthInfo auth = (AuthInfo) request.getSession().getAttribute(ConfigUtil.getValue("AuthInfo"));
        GoodsTypeDTO goodsTypeDTO = new GoodsTypeDTO();
        goodsTypeDTO.setCompanyId(auth.getUser_ID());
        goodsTypeDTO.setCompanyName(auth.getSubName());
        if (create) {
            goodsTypeDTO.setCreateId(auth.getId());
            goodsTypeDTO.setCreator(auth.getUserName());
        }
        if (update) {
            goodsTypeDTO.setUpdateId(auth.getId());
            goodsTypeDTO.setUpdator(auth.getUserName());
        }
        return goodsTypeDTO;
    }

}
