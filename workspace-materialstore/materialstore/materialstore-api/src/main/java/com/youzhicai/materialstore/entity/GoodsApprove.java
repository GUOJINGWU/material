/**  
 * @Title: GoodsApprove.java
 * @Package com.youzhicai.materialstore.entity
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月11日 上午11:10:26
 * @version V1.0  
 */
package com.youzhicai.materialstore.entity;

import java.util.Date;

/**
 * @ClassName: GoodsApprove
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月11日 上午11:10:26
 */
public class GoodsApprove {

    /* 主键ID */
    protected Long id;

    /* 物资ID */
    protected Long gid;

    /* 审批状态:1 正常(审核通过), 10 未提交, 11 审核中, 13 不通过 */
    protected Integer approveStatus;

    /* 审批意见 */
    protected String remarks;

    /* 状态值: 1 正常,0 不可用 */
    protected Integer status;

    /* 添加人ID */
    protected String createId;

    /* 添加人名称 */
    protected String creator;

    /* 添加时间 */
    protected Date createTime;

    /* 修改人ID */
    protected String updateId;

    /* 修改人名称 */
    protected String updator;

    /* 修改时间 */
    protected Date updateTime;

    public GoodsApprove() {
        super();
    }

    public GoodsApprove(Integer approveStatus) {
        super();
        this.approveStatus = approveStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
