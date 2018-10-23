/**  
 * @Title: TypeUserModel.java
 * @Package com.youzhicai.materialstore.web.api.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月19日 上午10:39:24
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.api.model;

/**
 * @ClassName: TypeUserModel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月19日 上午10:39:24
 */
public class TypeUserModel {

    /* 一级分类集合 */
    private Long[] tids;

    /* 企业ID */
    private String companyId;

    public Long[] getTids() {
        return tids;
    }

    public void setTids(Long[] tids) {
        this.tids = tids;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

}
