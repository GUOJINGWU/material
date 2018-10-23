/**  
 * @Title: GoodsApproveModel.java
 * @Package com.youzhicai.materialstore.web.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月20日 上午9:26:23
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.model;

/**
 * @ClassName: GoodsApproveModel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月20日 上午9:26:23
 */
public class GoodsApproveModel {

    private String remarks;

    private Integer approveStatus;

    private Long gid;

    public GoodsApproveModel() {
        super();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

}
