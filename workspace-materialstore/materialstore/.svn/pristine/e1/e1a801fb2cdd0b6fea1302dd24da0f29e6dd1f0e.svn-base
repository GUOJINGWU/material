/**  
 * @Title: GoodsApproveController.java
 * @Package com.youzhicai.materialstore.web.controller
 * @Description: 物资审核
 * @author XieXianpeng
 * @date 2018年10月17日 上午10:30:39
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youzhicai.materialstore.api.GoodsAPI;
import com.youzhicai.materialstore.api.GoodsApproveAPI;
import com.youzhicai.materialstore.api.GoodsTypeAPI;
import com.youzhicai.materialstore.dto.GoodsApproveDTO;
import com.youzhicai.materialstore.dto.GoodsDTO;
import com.youzhicai.materialstore.dto.GoodsTypeDTO;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.vo.GoodsApproveVO;
import com.youzhicai.materialstore.vo.GoodsSearchVO;
import com.youzhicai.materialstore.vo.GoodsTypeVO;
import com.youzhicai.materialstore.vo.GoodsVO;
import com.youzhicai.materialstore.web.api.transfer.DataTransfer;
import com.youzhicai.materialstore.web.api.transfer.TransferType;
import com.youzhicai.materialstore.web.domain.AuthInfo;
import com.youzhicai.materialstore.web.model.GoodsApproveModel;
import com.youzhicai.materialstore.web.model.GoodsSearchModel;
import com.youzhicai.materialstore.web.util.ConfigUtil;
import com.youzhicai.materialstore.web.util.DESUtil;
import com.youzhicai.materialstore.web.util.Strings;

/**
 * @ClassName: GoodsApproveController
 * @Description: 物资审核
 * @author XieXianpeng
 * @date 2018年10月17日 上午10:30:39
 */
@Controller
@RequestMapping("web/goodsapprove")
public class GoodsApproveController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodsAPI goodsAPI;

    @Autowired
    private GoodsTypeAPI goodsTypeAPI;

    @Autowired
    private GoodsApproveAPI goodsApproveAPI;

    /**
     * @Title: table
     * @Description: 物资审核列表
     * @param model
     * @throws Exception
     * @return String
     */
    @RequestMapping("table")
    public String table(Model model) throws Exception {
        // 查询物资分页列表
        GoodsDTO goodsDTO = goodsWithUser(false, false);
        goodsDTO.setPageNum(1);
        goodsDTO.setPageSize(10);
        goodsDTO.setIsGidDes(true);
        goodsDTO.setApproved(0);
        Page<GoodsSearchVO> searchList = goodsAPI.findGoodsListForSearch(goodsDTO);
        model.addAttribute("searchList", searchList);

        // 未审核及已审核物资数量
        Map<String, Object> approvedOrNotCount = goodsAPI.countForApprovedOrNot(goodsDTO);
        model.addAttribute("approvedOrNotCount", approvedOrNotCount);

        // 物资状态列表
        model.addAttribute("approveStatusList", goodsAPI.goodsApproveStatusList());

        // 一级分类
        GoodsTypeDTO firstGoodsTypeDTO = goodsTypeWithUser(false, false);
        firstGoodsTypeDTO.setPid(0L);
        List<GoodsTypeVO> firstRankTypes = goodsTypeAPI.subtypeList(firstGoodsTypeDTO);
        model.addAttribute("firstRankTypes", firstRankTypes);
        return "materialGoodsApprove/approveTable";
    }

    /**
     * @Title: searchTable
     * @Description: 搜索物资审核列表
     * @param goodsSearchModel
     * @throws Exception
     * @return Object
     */
    @RequestMapping(value = "searchtable", method = RequestMethod.POST)
    @ResponseBody
    public Object searchTable(@RequestBody GoodsSearchModel goodsSearchModel) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        Integer pageNum = goodsSearchModel.getPageNum();
        Integer pageSize = goodsSearchModel.getPageSize();
        String nameOrCode = goodsSearchModel.getNameOrCode();
        Long tid = goodsSearchModel.getTid();
        Integer approveStatus = goodsSearchModel.getApproveStatus();
        Integer approved = goodsSearchModel.getApproved();

        // 查询物资分页列表
        GoodsDTO goodsDTO = goodsWithUser(false, false);
        goodsDTO.setPageNum(pageNum == null ? 1 : pageNum);
        goodsDTO.setPageSize(pageSize == null ? 10 : pageSize);
        goodsDTO.setNameOrCode(StringUtils.isEmpty(nameOrCode) ? null : nameOrCode);
        goodsDTO.setTid(tid);
        goodsDTO.setGoodsApprove(approveStatus == null ? null : new GoodsApproveDTO(approveStatus));
        goodsDTO.setApproved(approved);
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

        // 未审核及已审核物资数量
        Map<String, Object> approvedOrNotCount = goodsAPI.countForApprovedOrNot(goodsDTO);
        result.put("approvedOrNotCount", approvedOrNotCount);

        return result;
    }

    /**
     * @Title: approveHandle
     * @Description: 审核物资操作
     * @param goodsApproveModel
     * @return Object
     */
    @RequestMapping(value = "handle", method = RequestMethod.POST)
    @ResponseBody
    public Object approveHandle(@RequestBody GoodsApproveModel goodsApproveModel) {
        Long gid = goodsApproveModel.getGid();
        String remarks = goodsApproveModel.getRemarks();
        Integer approveStatus = goodsApproveModel.getApproveStatus();
        if (gid == null || approveStatus == null || (approveStatus != 1 && approveStatus != 31)
                || (approveStatus == 31 && StringUtils.isEmpty(remarks))) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
        }

        GoodsApproveDTO goodsApproveDTO = goodsApproveWithUser(false, true);
        goodsApproveDTO.setRemarks(remarks);
        goodsApproveDTO.setApproveStatus(approveStatus);
        goodsApproveDTO.setGid(gid);

        boolean flag = false;
        try {
            flag = goodsApproveAPI.approveHandle(goodsApproveDTO);
        } catch (Exception e) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
        }
        if (flag) {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("code", TransferType.SUCCESS.getCode());
            resultMap.put("msg", TransferType.SUCCESS.getMsg());
            try {
                resultMap.put("gidDES", DESUtil.encryptStr(String.valueOf(gid)));
            } catch (Exception e) {
            }
            return resultMap;
        }

        return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
    }

    /**
     * @Title: view
     * @Description: 查看物资审核信息
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

        if (goodsVO == null) {
            goodsVO = new GoodsVO();
            goodsVO.setGoodsSupplys(new ArrayList<>());
            goodsVO.setGoodsApprove(new GoodsApproveVO());
        }

        model.addAttribute("goodsVO", goodsVO);
        model.addAttribute("showImageUrl", ConfigUtil.getValue("fileServiceURL") + "/image/showImage.yzc?attId=");
        return "materialGoodsApprove/approveView";
    }

    /**
     * @Title: toApprove
     * @Description: 物资审核页
     * @param model
     * @param gid
     * @return String
     */
    @RequestMapping("toapprove")
    public String toApprove(Model model, String gid) {
        Long id = null;
        try {
            id = Strings.str2Long(DESUtil.decryptStr(gid));
        } catch (Exception e) {
        }

        // 查询详情
        GoodsDTO goodsDetailDTO = goodsWithUser(false, false);
        goodsDetailDTO.setId(id);
        goodsDetailDTO.setIsDiffSupplys(true);
        GoodsVO goodsVO = goodsAPI.findGoodsDetail(goodsDetailDTO);

        if (goodsVO == null) {
            goodsVO = new GoodsVO();
            goodsVO.setGoodsSupplys(new ArrayList<>());
            goodsVO.setGoodsApprove(new GoodsApproveVO());
        }

        GoodsApproveVO goodsApprove;
        Integer approveStatus;
        if ((goodsApprove = goodsVO.getGoodsApprove()) == null || (approveStatus = goodsApprove.getApproveStatus()) == null || approveStatus != 21) {
            return "redirect:/web/goodsapprove/view?gid=" + gid;
        }

        model.addAttribute("goodsVO", goodsVO);
        model.addAttribute("showImageUrl", ConfigUtil.getValue("fileServiceURL") + "/image/showImage.yzc?attId=");

        // 相似物资
        GoodsDTO alikeGoodsDTO = goodsWithUser(false, false);
        alikeGoodsDTO.setBrand(goodsVO.getBrand());
        alikeGoodsDTO.setSpecifications(goodsVO.getSpecifications());
        alikeGoodsDTO.setIsGidDes(true);
        List<GoodsVO> alikeGoodsList;
        try {
            alikeGoodsList = goodsAPI.findAlikeGoodsList(alikeGoodsDTO);
            model.addAttribute("alikeGoodsList", alikeGoodsList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "materialGoodsApprove/approveHandle";
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

    /*
     * 封装物资类型传输用户信息
     */
    private GoodsApproveDTO goodsApproveWithUser(boolean create, boolean update) {
        AuthInfo auth = (AuthInfo) request.getSession().getAttribute(ConfigUtil.getValue("AuthInfo"));
        GoodsApproveDTO goodsApproveDTO = new GoodsApproveDTO();
        goodsApproveDTO.setCompanyId(auth.getUser_ID());
        goodsApproveDTO.setCompanyName(auth.getSubName());
        if (create) {
            goodsApproveDTO.setCreateId(auth.getId());
            goodsApproveDTO.setCreator(auth.getUserName());
        }
        if (update) {
            goodsApproveDTO.setUpdateId(auth.getId());
            goodsApproveDTO.setUpdator(auth.getUserName());
        }
        return goodsApproveDTO;
    }

}
