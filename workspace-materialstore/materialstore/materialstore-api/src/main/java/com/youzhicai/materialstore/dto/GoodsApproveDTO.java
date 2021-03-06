/**  
 * @Title: GoodsApproveDTO.java
 * @Package com.youzhicai.materialstore.dto
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月11日 上午11:19:33
 * @version V1.0  
 */
package com.youzhicai.materialstore.dto;

import com.youzhicai.materialstore.entity.GoodsApprove;

/**
 * @ClassName: GoodsApproveDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月11日 上午11:19:33
 */
public class GoodsApproveDTO extends GoodsApprove {

    private String companyId;

    private String companyName;

    /**
     * 创建一个新的实例 GoodsApproveDTO.
     */
    public GoodsApproveDTO() {
        super();
    }

    /**
     * 创建一个新的实例 GoodsApproveDTO.
     * 
     * @param approveStatus
     */
    public GoodsApproveDTO(Integer approveStatus) {
        super(approveStatus);
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
