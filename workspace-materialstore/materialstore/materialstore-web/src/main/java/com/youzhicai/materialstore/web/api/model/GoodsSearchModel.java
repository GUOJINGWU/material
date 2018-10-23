/**  
 * @Title: GoodsSearchModel.java
 * @Package com.youzhicai.materialstore.web.api.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月12日 下午7:25:51
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.api.model;

/**
 * @ClassName: GoodsSearchModel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月12日 下午7:25:51
 */
public class GoodsSearchModel {

    private Integer pageNum;
    private Integer pageSize;
    private String companyId;
    private String nameOrCode;

    private Integer firstRankId;
    private Integer secondRankId;
    private Integer thirdRankId;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getNameOrCode() {
        return nameOrCode;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }

    public Integer getFirstRankId() {
        return firstRankId;
    }

    public void setFirstRankId(Integer firstRankId) {
        this.firstRankId = firstRankId;
    }

    public Integer getSecondRankId() {
        return secondRankId;
    }

    public void setSecondRankId(Integer secondRankId) {
        this.secondRankId = secondRankId;
    }

    public Integer getThirdRankId() {
        return thirdRankId;
    }

    public void setThirdRankId(Integer thirdRankId) {
        this.thirdRankId = thirdRankId;
    }

}
