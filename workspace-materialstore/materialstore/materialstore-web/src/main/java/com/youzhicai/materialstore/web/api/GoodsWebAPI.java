/**  
 * @Title: GoodsTypeWebAPI.java
 * @Package com.youzhicai.materialstore.web.api
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月29日 下午7:41:28
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youzhicai.materialstore.api.GoodsAPI;
import com.youzhicai.materialstore.dto.GoodsDTO;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.handler.UnLogin;
import com.youzhicai.materialstore.vo.GoodsAPIVO;
import com.youzhicai.materialstore.web.api.model.GoodsCheckCodeModel;
import com.youzhicai.materialstore.web.api.model.GoodsSearchModel;
import com.youzhicai.materialstore.web.api.transfer.DataTransfer;
import com.youzhicai.materialstore.web.api.transfer.TransferType;

/**
 * @ClassName: GoodsTypeWebAPI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月29日 下午7:41:28
 */
@RestController
@RequestMapping("webapi/goods")
public class GoodsWebAPI {

    @Autowired
    private GoodsAPI goodsAPI;

    /**
     * @Title: checkCodes
     * @Description: 校验物资编码是否存在
     * @param codes
     * @param companyId
     * @return DataTransfer<List<GoodsVO>>
     */
    @UnLogin
    @RequestMapping(value = "checkcodes", method = RequestMethod.POST)
    public DataTransfer<List<GoodsAPIVO>> checkCodes(@RequestBody GoodsCheckCodeModel goodsCheckCodeModel) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setCodes(goodsCheckCodeModel.getCodes());
        goodsDTO.setCompanyId(goodsCheckCodeModel.getCompanyId());

        List<GoodsAPIVO> ableList = goodsAPI.checkCodes(goodsDTO);

        if (ableList != null) {
            return new DataTransfer<List<GoodsAPIVO>>(TransferType.SUCCESS.getCode(), TransferType.SUCCESS.getMsg(), ableList);
        } else {
            return new DataTransfer<List<GoodsAPIVO>>(TransferType.DATANULL.getCode(), TransferType.DATANULL.getMsg());
        }
    }

    @UnLogin
    @RequestMapping(value = "goodsListForSearch", method = RequestMethod.POST)
    public DataTransfer<Page<GoodsAPIVO>> findGoodsListForSearchAPI(@RequestBody GoodsSearchModel goodsSearchModel) {
        GoodsDTO goodsDTO = new GoodsDTO();
        if(goodsSearchModel != null){            
            goodsDTO.setPageNum(goodsSearchModel.getPageNum());
            goodsDTO.setPageSize(goodsSearchModel.getPageSize());
            goodsDTO.setCompanyId(goodsSearchModel.getCompanyId());
            goodsDTO.setNameOrCode(goodsSearchModel.getNameOrCode());
            goodsDTO.setFirstRankId(goodsSearchModel.getFirstRankId());
            goodsDTO.setSecondRankId(goodsSearchModel.getSecondRankId());
            goodsDTO.setThirdRankId(goodsSearchModel.getThirdRankId());
        }

        Page<GoodsAPIVO> goodsAPIVOsByPage = goodsAPI.findGoodsListForSearchAPI(goodsDTO);

        if (goodsAPIVOsByPage != null) {
            return new DataTransfer<Page<GoodsAPIVO>>(TransferType.SUCCESS.getCode(), TransferType.SUCCESS.getMsg(), goodsAPIVOsByPage);
        } else {
            return new DataTransfer<Page<GoodsAPIVO>>(TransferType.DATANULL.getCode(), TransferType.DATANULL.getMsg());
        }
    }

}
