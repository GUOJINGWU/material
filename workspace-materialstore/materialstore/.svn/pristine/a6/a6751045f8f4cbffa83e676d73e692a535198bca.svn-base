/**  
 * @Title: GoodsAPIVO.java
 * @Package com.youzhicai.materialstore.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:44:49
 * @version V1.0  
 */
package com.youzhicai.materialstore.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.youzhicai.materialstore.entity.Goods;

/**
 * @ClassName: GoodsAPIVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:44:49
 */
public class GoodsAPIVO extends Goods {

    @JsonIgnore
    protected String companyId;

    @JsonIgnore
    protected String companyName;

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
    protected String typeCodes;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Map<String, String> types;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String firstRankName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String secondRankName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String thirdRankName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String firstRankCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String secondRankCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String thirdRankCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Long firstRankId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected List<GoodsSupplyVO> goodsSupplys;

    public String getTypeCodes() {
        return typeCodes;
    }

    public void setTypeCodes(String typeCodes) {
        this.typeCodes = typeCodes;
    }

    public Map<String, String> getTypes() {
        return types;
    }

    public void setTypes(Map<String, String> types) {
        this.types = types;
    }

    public String getFirstRankName() {
        return firstRankName;
    }

    public void setFirstRankName(String firstRankName) {
        this.firstRankName = firstRankName;
    }

    public String getSecondRankName() {
        return secondRankName;
    }

    public void setSecondRankName(String secondRankName) {
        this.secondRankName = secondRankName;
    }

    public String getThirdRankName() {
        return thirdRankName;
    }

    public void setThirdRankName(String thirdRankName) {
        this.thirdRankName = thirdRankName;
    }

    public String getFirstRankCode() {
        return firstRankCode;
    }

    public void setFirstRankCode(String firstRankCode) {
        this.firstRankCode = firstRankCode;
    }

    public String getSecondRankCode() {
        return secondRankCode;
    }

    public void setSecondRankCode(String secondRankCode) {
        this.secondRankCode = secondRankCode;
    }

    public String getThirdRankCode() {
        return thirdRankCode;
    }

    public void setThirdRankCode(String thirdRankCode) {
        this.thirdRankCode = thirdRankCode;
    }

    public Long getFirstRankId() {
        return firstRankId;
    }

    public void setFirstRankId(Long firstRankId) {
        this.firstRankId = firstRankId;
    }

    public List<GoodsSupplyVO> getGoodsSupplys() {
        return goodsSupplys;
    }

    public void setGoodsSupplys(List<GoodsSupplyVO> goodsSupplys) {
        this.goodsSupplys = goodsSupplys;
    }

}
