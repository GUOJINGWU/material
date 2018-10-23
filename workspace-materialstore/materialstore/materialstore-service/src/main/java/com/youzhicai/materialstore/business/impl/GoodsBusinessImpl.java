/**  
 * @Title: GoodsBusinessImpl.java
 * @Package com.youzhicai.materialstore.business.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月20日 下午5:00:50
 * @version V1.0  
 */
package com.youzhicai.materialstore.business.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youzhicai.materialstore.api.GoodsAPI;
import com.youzhicai.materialstore.common.constant.Params;
import com.youzhicai.materialstore.dto.GoodsDTO;
import com.youzhicai.materialstore.handler.BusinessAPI;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.service.GoodsService;
import com.youzhicai.materialstore.service.GoodsTypeService;
import com.youzhicai.materialstore.vo.GoodsAPIVO;
import com.youzhicai.materialstore.vo.GoodsSearchVO;
import com.youzhicai.materialstore.vo.GoodsVO;

/**
 * @ClassName: GoodsBusinessImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月20日 下午5:00:50
 */
@RestController
@RequestMapping(value = "goods", method = { RequestMethod.GET, RequestMethod.POST })
@BusinessAPI
public class GoodsBusinessImpl implements GoodsAPI {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * @Title: nextGoodsCode
     * @Description: 获取下一个生成的物资编码
     * @param goodsDTO
     * @return String
     */
    @RequestMapping(value = "nextGoodsCode", method = { RequestMethod.POST })
    @Override
    public Map<String, Object> nextGoodsCode(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.nextGoodsCode(goodsDTO);
    }

    /**
     * @Title: addGoods
     * @Description: 添加物资
     * @param goodsDTO
     * @return long
     */
    @RequestMapping(value = "addGoods", method = { RequestMethod.POST })
    @Override
    public long addGoods(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.addGoods(goodsDTO);
    }

    /**
     * @Title: checkCodes
     * @Description: 校验物资编码
     * @param goodsDTO
     * @return List<GoodsAPIVO>
     */
    @RequestMapping(value = "checkCodes", method = { RequestMethod.POST })
    @Override
    public List<GoodsAPIVO> checkCodes(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.checkCodes(goodsDTO);
    }

    /**
     * @Title: findGoodsDetail
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return GoodsVO
     */
    @RequestMapping(value = "goodsDetail", method = { RequestMethod.POST })
    @Override
    public GoodsVO findGoodsDetail(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.findGoodsDetail(goodsDTO);
    }

    /**
     * @Title: findGoodsListForSearch
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return Page<GoodsSearchVO>
     * @throws Exception
     */
    @RequestMapping(value = "goodsListForSearch", method = { RequestMethod.POST })
    @Override
    public Page<GoodsSearchVO> findGoodsListForSearch(GoodsDTO goodsDTO) throws Exception {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.findGoodsListForSearch(goodsDTO);
    }

    /*
     * @Title: countForUsedOrNot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsAPI#countForUsedOrNot(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public Map<String, Object> countForUsedOrNot(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.countForUsedOrNot(goodsDTO);
    }

    /*
     * @Title: countForApprovedOrNot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsAPI#countForApprovedOrNot(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public Map<String, Object> countForApprovedOrNot(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.countForApprovedOrNot(goodsDTO);
    }

    @Override
    public Page<GoodsAPIVO> findGoodsListForSearchAPI(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.findGoodsListForSearchAPI(goodsDTO);
    }

    /*
     * @Title: modifyGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsAPI#modifyGoods(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public boolean modifyGoods(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.modifyGoods(goodsDTO);
    }

    /*
     * @Title: GoodsApproveStatusList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @see com.youzhicai.materialstore.api.GoodsAPI#goodsApproveStatusList()
     */
    @Override
    public Object goodsApproveStatusList() {
        return goodsService.goodsApproveStatusList();
    }

    /*
     * @Title: deleteGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsAPI#deleteGoods(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public boolean deleteGoods(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.deleteGoods(goodsDTO);
    }

    /*
     * @Title: findAlikeGoodsList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsAPI#findAlikeGoodsList(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public List<GoodsVO> findAlikeGoodsList(GoodsDTO goodsDTO) throws Exception {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.findAlikeGoodsList(goodsDTO);
    }

    /*
     * @Title: saveExcelGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsAPI#saveExcelGoods(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public Map<String, Object> saveExcelGoods(GoodsDTO goodsDTO) {
        goodsDTO = Params.toObj(request, goodsDTO);
        return goodsService.saveExcelGoods(goodsDTO);
    }

}
