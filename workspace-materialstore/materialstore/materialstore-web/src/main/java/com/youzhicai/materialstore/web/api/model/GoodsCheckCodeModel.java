/**  
 * @Title: GoodsCheckCodeModel.java
 * @Package com.youzhicai.materialstore.web.api.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月12日 下午8:16:02
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.api.model;

/**
 * @ClassName: GoodsCheckCodeModel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月12日 下午8:16:02
 */
public class GoodsCheckCodeModel {

    private String[] codes;

    private String companyId;

    public String[] getCodes() {
        return codes;
    }

    public void setCodes(String[] codes) {
        this.codes = codes;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

}
