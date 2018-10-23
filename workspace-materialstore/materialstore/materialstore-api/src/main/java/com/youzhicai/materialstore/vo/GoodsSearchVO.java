/**  
 * @Title: GoodsSearchVO.java
 * @Package com.youzhicai.materialstore.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月11日 下午4:45:41
 * @version V1.0  
 */
package com.youzhicai.materialstore.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.youzhicai.materialstore.entity.Goods;

/**
 * @ClassName: GoodsSearchVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月11日 下午4:45:41
 */
public class GoodsSearchVO extends Goods {

    /* 企业ID */
    @JsonIgnore
    protected String companyId;

    /* 企业名称 */
    @JsonIgnore
    protected String companyName;

    /* 物资名称 */
    protected String name;

    /* 物资编码 */
    protected String code;

    /* 物资分类ID */
    protected Long tid;

    /* 计量单位 */
    protected String unit;

    /* 材质/品牌 */
    protected String brand;

    /* 规格型号 */
    protected String specifications;

    /* 补充说明 */
    @JsonIgnore
    protected String remarks;

    /* 相关链接 */
    @JsonIgnore
    protected String link;

    /* 启用值: 1 启用, 0 停用 */
    protected Integer used;

    /* 状态值: 1 正常, 0 删除 */
    @JsonIgnore
    protected Integer status;

    /* 添加人ID */
    @JsonIgnore
    protected String createId;

    /* 添加人名称 */
    protected String creator;

    /* 添加时间 */
    protected Date createTime;

    /* 修改人ID */
    @JsonIgnore
    protected String updateId;

    /* 修改人名称 */
    @JsonIgnore
    protected String updator;

    /* 修改时间 */
    @JsonIgnore
    protected Date updateTime;

    private Integer approveStatus;

    private String firstRankCode;

    private String secondRankCode;

    private String thirdRankCode;

    private String firstRankName;

    private String secondRankName;

    private String thirdRankName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String gidDES;

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
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

    public String getGidDES() {
        return gidDES;
    }

    public void setGidDES(String gidDES) {
        this.gidDES = gidDES;
    }

}
