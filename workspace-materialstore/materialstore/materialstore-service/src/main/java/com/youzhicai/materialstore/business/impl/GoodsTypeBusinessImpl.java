/**  
 * @Title: GoodsTypeBusinessImpl.java
 * @Package com.youzhicai.materialstore.business.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月18日 上午9:33:27
 * @version V1.0  
 */
package com.youzhicai.materialstore.business.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youzhicai.materialstore.api.GoodsTypeAPI;
import com.youzhicai.materialstore.common.constant.Params;
import com.youzhicai.materialstore.dto.GoodsTypeDTO;
import com.youzhicai.materialstore.dto.GoodsTypePageDTO;
import com.youzhicai.materialstore.handler.BusinessAPI;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.service.GoodsTypeService;
import com.youzhicai.materialstore.vo.GoodsTypeThirdRankMixVO;
import com.youzhicai.materialstore.vo.GoodsTypeVO;

/**
 * @ClassName: GoodsTypeBusinessImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月18日 上午9:33:27
 */
@RestController
@RequestMapping(value = "goodstype", method = { RequestMethod.GET, RequestMethod.POST })
@BusinessAPI
public class GoodsTypeBusinessImpl implements GoodsTypeAPI {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping(value = "subtypeList", method = { RequestMethod.POST })
    @Override
    public List<GoodsTypeVO> subtypeList(GoodsTypeDTO goodsTypeDTO) {
        goodsTypeDTO = Params.toObj(request, goodsTypeDTO);
        return goodsTypeService.subtypeList(goodsTypeDTO);
    }

    /*
     * @Title: findGoodsTypeByPage
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypePageDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsTypeAPI#findGoodsTypeListForSearch(com.youzhicai.materialstore.dto.
     * GoodsTypePageDTO)
     */
    @RequestMapping(value = "findThirdRankMixByPage", method = { RequestMethod.POST })
    @Override
    public Page<GoodsTypeThirdRankMixVO> findGoodsTypeListForSearch(GoodsTypePageDTO goodsTypePageDTO) {
        goodsTypePageDTO = Params.toObj(request, goodsTypePageDTO);
        return goodsTypeService.findGoodsTypeListForSearch(goodsTypePageDTO);
    }

    /**
     * @Title: addThirdRank
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return boolean
     */
    @RequestMapping(value = "addThirdRank", method = { RequestMethod.POST })
    @Override
    public boolean addThirdRank(GoodsTypeDTO goodsTypeDTO) {
        goodsTypeDTO = Params.toObj(request, goodsTypeDTO);
        return goodsTypeService.addThirdRank(goodsTypeDTO);
    }

    /**
     * @Title: addSecondRank
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return boolean
     */
    @RequestMapping(value = "addSecondRank", method = { RequestMethod.POST })
    @Override
    public boolean addSecondRank(GoodsTypeDTO goodsTypeDTO) {
        goodsTypeDTO = Params.toObj(request, goodsTypeDTO);
        return goodsTypeService.addSecondRank(goodsTypeDTO);
    }

    /**
     * @Title: addFirstRank
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return boolean
     */
    @RequestMapping(value = "addFirstRank", method = { RequestMethod.POST })
    @Override
    public boolean addFirstRank(GoodsTypeDTO goodsTypeDTO) {
        goodsTypeDTO = Params.toObj(request, goodsTypeDTO);
        return goodsTypeService.addFirstRank(goodsTypeDTO);
    }

    /*
     * @Title: subTypesByFirstId
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsTypeAPI#subTypesByFirstId(com.youzhicai.materialstore.dto.GoodsTypeDTO)
     */
    @RequestMapping(value = "subTypesByFirstId", method = { RequestMethod.POST })
    @Override
    public List<GoodsTypeVO> subTypesByFirstId(GoodsTypeDTO goodsTypeDTO) {
        goodsTypeDTO = Params.toObj(request, goodsTypeDTO);
        return goodsTypeService.subTypesByFirstId(goodsTypeDTO);
    }

    /*
     * @Title: subTypesForShop
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsTypeAPI#subTypesForShop(com.youzhicai.materialstore.dto.GoodsTypeDTO)
     */
    @RequestMapping(value = "subTypesForShop", method = { RequestMethod.POST })
    @Override
    public List<GoodsTypeVO> subTypesForShop(GoodsTypeDTO goodsTypeDTO) {
        goodsTypeDTO = Params.toObj(request, goodsTypeDTO);
        return goodsTypeService.subTypesForShop(goodsTypeDTO);
    }

    /*
     * @Title: deleteType
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsTypeAPI#deleteType(com.youzhicai.materialstore.dto.GoodsTypeDTO)
     */
    @RequestMapping(value = "deleteType", method = { RequestMethod.POST })
    @Override
    public boolean deleteType(GoodsTypeDTO goodsTypeDTO) {
        goodsTypeDTO = Params.toObj(request, goodsTypeDTO);
        return goodsTypeService.deleteType(goodsTypeDTO);
    }

}
