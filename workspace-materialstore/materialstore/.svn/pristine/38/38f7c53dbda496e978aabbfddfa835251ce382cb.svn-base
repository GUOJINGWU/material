/**  
 * @Title: GoodsTypeVO.java
 * @Package com.youzhicai.materialstore.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月18日 上午10:31:52
 * @version V1.0  
 */
package com.youzhicai.materialstore.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.youzhicai.materialstore.entity.GoodsType;

/**
 * @ClassName: GoodsTypeVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月18日 上午10:31:52
 */
public class GoodsTypeVO extends GoodsType {

    @JsonIgnore
    private String companyId;

    @JsonIgnore
    private String companyName;

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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GoodsTypeVO> subGoodsTypes;

    public List<GoodsTypeVO> getSubGoodsTypes() {
        return subGoodsTypes;
    }

    public void setSubGoodsTypes(List<GoodsTypeVO> subGoodsTypes) {
        this.subGoodsTypes = subGoodsTypes;
    }

}
