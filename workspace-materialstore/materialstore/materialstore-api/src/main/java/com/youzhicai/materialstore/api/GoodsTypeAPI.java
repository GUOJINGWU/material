/**  
 * @Title: GoodsTypeAPI.java
 * @Package com.youzhicai.materialstore.api
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月18日 下午4:55:43
 * @version V1.0  
 */
package com.youzhicai.materialstore.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youzhicai.materialstore.dto.GoodsTypeDTO;
import com.youzhicai.materialstore.dto.GoodsTypePageDTO;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.vo.GoodsTypeThirdRankMixVO;
import com.youzhicai.materialstore.vo.GoodsTypeVO;

/**
 * @ClassName: GoodsTypeAPI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月18日 下午4:55:44
 */
@FeignClient("MATERIAL-SERVICE")
public interface GoodsTypeAPI {

    @RequestMapping(value = "/api/goodstype/subtypeList")
    public List<GoodsTypeVO> subtypeList(GoodsTypeDTO goodsTypeDTO);

    @RequestMapping(value = "/api/goodstype/findThirdRankMixByPage")
    public Page<GoodsTypeThirdRankMixVO> findGoodsTypeListForSearch(GoodsTypePageDTO goodsTypePageDTO);

    @RequestMapping(value = "/api/goodstype/addThirdRank")
    public boolean addThirdRank(GoodsTypeDTO goodsTypeDTO);

    @RequestMapping(value = "/api/goodstype/addSecondRank")
    public boolean addSecondRank(GoodsTypeDTO goodsTypeDTO);

    @RequestMapping(value = "/api/goodstype/addFirstRank")
    public boolean addFirstRank(GoodsTypeDTO goodsTypeDTO);

    /**
     * @Title: subTypesByFirstId
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return
     * @return List<GoodsTypeVO>
     */
    public List<GoodsTypeVO> subTypesByFirstId(GoodsTypeDTO goodsTypeDTO);

    /**
     * @Title: subTypesForShop
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return
     * @return List<GoodsTypeVO>
     */
    public List<GoodsTypeVO> subTypesForShop(GoodsTypeDTO goodsTypeDTO);

    /**
     * @Title: deleteType
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return
     * @return boolean
     */
    public boolean deleteType(GoodsTypeDTO goodsTypeDTO);
}
