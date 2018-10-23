/**  
 * @Title: GoodsTypeController.java
 * @Package com.youzhicai.materialstore.web.controller
 * @Description: 物资分类
 * @author XieXianpeng
 * @date 2018年9月19日 下午3:24:40
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.youzhicai.materialstore.api.GoodsTypeAPI;
import com.youzhicai.materialstore.dto.GoodsDTO;
import com.youzhicai.materialstore.dto.GoodsTypeDTO;
import com.youzhicai.materialstore.dto.GoodsTypePageDTO;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.vo.GoodsTypeThirdRankMixVO;
import com.youzhicai.materialstore.vo.GoodsTypeVO;
import com.youzhicai.materialstore.web.api.transfer.DataTransfer;
import com.youzhicai.materialstore.web.api.transfer.TransferType;
import com.youzhicai.materialstore.web.domain.AuthInfo;
import com.youzhicai.materialstore.web.model.GoodsTypeDeleteModel;
import com.youzhicai.materialstore.web.model.GoodsTypeSearchModel;
import com.youzhicai.materialstore.web.model.GoodsTypeSubTypeModel;
import com.youzhicai.materialstore.web.util.ConfigUtil;

/**
 * @ClassName: GoodsTypeController
 * @Description: 物资分类
 * @author XieXianpeng
 * @date 2018年9月19日 下午3:24:40
 */
@Controller
@RequestMapping("web/goodstype")
public class GoodsTypeController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodsTypeAPI goodsTypeAPI;

    /**
     * @Title: subtypeList
     * @Description: 子分类查询
     * @param goodsTypeSubTypeModel
     * @return Object
     */
    @RequestMapping(value = "subtypeList", method = RequestMethod.POST)
    @ResponseBody
    public Object subtypeList(@RequestBody GoodsTypeSubTypeModel goodsTypeSubTypeModel) {
        GoodsTypeDTO goodsTypeDTO = goodsTypeWithUser(false, false);
        goodsTypeDTO.setPid(goodsTypeSubTypeModel.getPid());
        List<GoodsTypeVO> subtypeList = goodsTypeAPI.subtypeList(goodsTypeDTO);
        return subtypeList;
    }

    /**
     * @Title: table
     * @Description: 物资分类列表页
     * @param model
     * @throws Exception
     * @return String
     */
    @RequestMapping("table")
    public String table(Model model) throws Exception {
        GoodsTypeDTO goodsTypeWithUser = goodsTypeWithUser(false, false);
        // 查询物资分类分页列表
        GoodsTypePageDTO goodsTypePageDTO = new GoodsTypePageDTO();
        goodsTypePageDTO.setPageNum(1);
        goodsTypePageDTO.setPageSize(10);
        goodsTypePageDTO.setCompanyId(goodsTypeWithUser.getCompanyId());
        Page<GoodsTypeThirdRankMixVO> searchList = goodsTypeAPI.findGoodsTypeListForSearch(goodsTypePageDTO);
        System.out.println(JSON.toJSON(searchList));
        model.addAttribute("searchList", searchList);

        // 一级分类
        GoodsTypeDTO firstGoodsTypeDTO = goodsTypeWithUser;
        firstGoodsTypeDTO.setPid(0L);
        List<GoodsTypeVO> firstRankTypes = goodsTypeAPI.subtypeList(firstGoodsTypeDTO);
        model.addAttribute("firstRankTypes", firstRankTypes);

        return "materialGoodsType/typeTable";
    }

    /**
     * @Title: searchTable
     * @Description: 搜索物资分类
     * @param goodsTypeSearchModel
     * @throws Exception
     * @return Object
     */
    @RequestMapping(value = "searchtable", method = RequestMethod.POST)
    @ResponseBody
    public Object searchTable(@RequestBody GoodsTypeSearchModel goodsTypeSearchModel) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        Integer pageNum = goodsTypeSearchModel.getPageNum();
        Integer pageSize = goodsTypeSearchModel.getPageSize();
        Long firstId = goodsTypeSearchModel.getFirstId();
        Long secondId = goodsTypeSearchModel.getSecondId();
        Long thirdId = goodsTypeSearchModel.getThirdId();

        // 查询物资分类分页列表
        GoodsTypePageDTO goodsTypePageDTO = new GoodsTypePageDTO();
        goodsTypePageDTO.setPageNum(pageNum == null || pageNum == 0 ? 1 : pageNum);
        goodsTypePageDTO.setPageSize(pageSize == null || pageSize == 0 ? 10 : pageSize);
        if (firstId != null && firstId != 0) {
            goodsTypePageDTO.setFirstId(firstId);
            if (secondId != null && secondId != 0) {
                goodsTypePageDTO.setSecondId(secondId);
                if (thirdId != null && thirdId != 0) {
                    goodsTypePageDTO.setThirdId(thirdId);
                }
            }
        }
        goodsTypePageDTO.setCompanyId(goodsTypeWithUser(false, false).getCompanyId());
        Page<GoodsTypeThirdRankMixVO> searchList = goodsTypeAPI.findGoodsTypeListForSearch(goodsTypePageDTO);

        if (searchList == null || searchList.getList() == null || searchList.getList().isEmpty()) {
            Integer pNum = goodsTypePageDTO.getPageNum();
            if (pNum > 1) {
                goodsTypePageDTO.setPageNum(pNum - 1);
                searchList = goodsTypeAPI.findGoodsTypeListForSearch(goodsTypePageDTO);
            }
        }
        result.put("searchList", searchList);

        return result;
    }

    /**
     * @Title: deleteType
     * @Description: 删除分类
     * @param goodsTypeDeleteModel
     * @return Object
     */
    @RequestMapping("delete")
    @ResponseBody
    public Object deleteType(@RequestBody GoodsTypeDeleteModel goodsTypeDeleteModel) {
        Long tid = goodsTypeDeleteModel.getTid();
        if (tid == null) {
            return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
        }

        GoodsTypeDTO goodsTypeDTO = goodsTypeWithUser(false, true);
        goodsTypeDTO.setThirdId(tid);

        boolean result = false;
        try {
            result = goodsTypeAPI.deleteType(goodsTypeDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result) {
            return new DataTransfer<>(TransferType.SUCCESS.getCode(), TransferType.SUCCESS.getMsg());
        }
        return new DataTransfer<>(TransferType.ERROR.getCode(), TransferType.ERROR.getMsg());
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
