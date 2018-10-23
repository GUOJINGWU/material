/**  
 * @Title: GoodsAPI.java
 * @Package com.youzhicai.materialstore.api
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:54:06
 * @version V1.0  
 */
package com.youzhicai.materialstore.api;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.youzhicai.materialstore.dto.GoodsDTO;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.vo.GoodsAPIVO;
import com.youzhicai.materialstore.vo.GoodsSearchVO;
import com.youzhicai.materialstore.vo.GoodsVO;

/**
 * @ClassName: GoodsAPI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:54:06
 */
@FeignClient("MATERIAL-SERVICE")
public interface GoodsAPI {

    /**
     * @Title: nextGoodsCode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return Map<String,Object>
     */
    public Map<String, Object> nextGoodsCode(GoodsDTO goodsDTO);

    public long addGoods(GoodsDTO goodsDTO);

    /**
     * @Title: checkCodes
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @return List<GoodsVO>
     */
    public List<GoodsAPIVO> checkCodes(GoodsDTO goodsDTO);

    public GoodsVO findGoodsDetail(GoodsDTO goodsDTO);

    public Page<GoodsSearchVO> findGoodsListForSearch(GoodsDTO goodsDTO) throws Exception;

    /**
     * @Title: countForUsedOrNot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @return Map<String,Object>
     */
    public Map<String, Object> countForUsedOrNot(GoodsDTO goodsDTO);

    /**
     * @Title: countForApprovedOrNot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @return Map<String,Object>
     */
    public Map<String, Object> countForApprovedOrNot(GoodsDTO goodsDTO);

    public Page<GoodsAPIVO> findGoodsListForSearchAPI(GoodsDTO goodsDTO);

    /**
     * @Title: modifyGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return boolean
     */
    public boolean modifyGoods(GoodsDTO goodsDTO);

    /**
     * @Title: goodsApproveStatusList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return Object
     */
    public Object goodsApproveStatusList();

    /**
     * @Title: deleteGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return boolean
     */
    public boolean deleteGoods(GoodsDTO goodsDTO);

    /**
     * @Title: findAlikeGoodsList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @return List<GoodsVO>
     */
    public List<GoodsVO> findAlikeGoodsList(GoodsDTO goodsDTO) throws Exception;

    /**
     * @Title: saveExcelGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @return Map<String,Object>
     */
    public Map<String, Object> saveExcelGoods(GoodsDTO goodsDTO);

}
