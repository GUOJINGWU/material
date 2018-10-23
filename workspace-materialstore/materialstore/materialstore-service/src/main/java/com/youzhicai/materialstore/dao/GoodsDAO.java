/**  
 * @Title: GoodsDAO.java
 * @Package com.youzhicai.materialstore.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:48:06
 * @version V1.0  
 */
package com.youzhicai.materialstore.dao;

import java.util.List;
import java.util.Map;

import com.youzhicai.materialstore.po.GoodsPO;

/**
 * @ClassName: GoodsDAO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:48:06
 */
public interface GoodsDAO {

    /**
     * @Title: save
     * @Description: 保存物资信息
     * @param goodsPO
     * @return int
     */
    public int save(GoodsPO goodsPO);

    /**
     * @Title: modify
     * @Description: 修改物资信息
     * @param goodsPO
     * @return int
     */
    public int modify(GoodsPO goodsPO);

    /**
     * @Title: findOneById
     * @Description: 查询单条物资信息
     * @param id
     * @return GoodsPO
     */
    public GoodsPO findOneById(Map<String, Object> queryMap);

    /**
     * @Title: findSubCodeList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param queryMap
     * @return List<Integer>
     */
    public List<Integer> findSubCodeList(Map<String, Object> queryMap);

    public GoodsPO findOneByTidAndCode(Map<String, Object> queryMap);

    /**
     * @Title: findOneByTidAndName
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param queryGoodsMap
     * @return void
     */
    public GoodsPO findOneByTidAndName(Map<String, Object> queryMap);

    public List<Map<String, Object>> findListForSearch(Map<String, Object> queryMap);

    public Integer findListForSearchCount(Map<String, Object> queryMap);

    /**
     * @Title: findGoodsListForSearchAPI
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param queryMap
     * @return List<Map<String,Object>>
     */
    public List<Map<String, Object>> findGoodsListForSearchAPI(Map<String, Object> queryMap);

    /**
     * @Title: findGoodsListForSearchAPICount
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param queryMap
     * @return Integer
     */
    public Integer findGoodsListForSearchAPICount(Map<String, Object> queryMap);

    public List<GoodsPO> findListAlikeGoods(Map<String, Object> queryMap);

}
