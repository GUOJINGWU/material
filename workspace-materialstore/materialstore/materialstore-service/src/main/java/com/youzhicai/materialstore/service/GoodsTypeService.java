/**  
 * @Title: GoodsTypeService.java
 * @Package com.youzhicai.materialstore.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月18日 下午5:15:07
 * @version V1.0  
 */
package com.youzhicai.materialstore.service;

import java.util.List;

import com.youzhicai.materialstore.dto.GoodsTypeDTO;
import com.youzhicai.materialstore.dto.GoodsTypePageDTO;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.vo.GoodsTypeThirdRankMixVO;
import com.youzhicai.materialstore.vo.GoodsTypeVO;

/**
 * @ClassName: GoodsTypeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月18日 下午5:15:07
 */
public interface GoodsTypeService {

    /**
     * @Title: subtypeList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return
     * @return List<GoodsTypeVO>
     */
    public List<GoodsTypeVO> subtypeList(GoodsTypeDTO goodsTypeDTO);

    /**
     * @Title: findGoodsTypeListForSearch
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypePageDTO
     * @return Page<GoodsTypeThirdRankMixVO>
     */
    public Page<GoodsTypeThirdRankMixVO> findGoodsTypeListForSearch(GoodsTypePageDTO goodsTypePageDTO);

    /**
     * @Title: addThirdRank
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param GoodsTypeDTO
     * @return boolean
     */
    public boolean addThirdRank(GoodsTypeDTO goodsTypeDTO);

    /**
     * @Title: addSecondRank
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return boolean
     */
    public boolean addSecondRank(GoodsTypeDTO goodsTypeDTO);

    /**
     * @Title: addFirstRank
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsTypeDTO
     * @return boolean
     */
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
