/**  
 * @Title: GoodsSupplyVO.java
 * @Package com.youzhicai.materialstore.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:45:12
 * @version V1.0  
 */
package com.youzhicai.materialstore.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youzhicai.materialstore.entity.GoodsSupply;

/**
 * @ClassName: GoodsSupplyVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:45:12
 */
public class GoodsSupplyVO extends GoodsSupply {

    @JsonIgnore
    protected String createId;

    @JsonIgnore
    protected String creator;

    @JsonIgnore
    protected Date createTime;

    @JsonIgnore
    protected String updateId;

    @JsonIgnore
    protected String updator;

    @JsonIgnore
    protected Date updateTime;

}
