/**  
 * @Title: GoodsSupply.java
 * @Package com.youzhicai.materialstore.entity
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:36:14
 * @version V1.0  
 */
package com.youzhicai.materialstore.entity;

import java.util.Date;

/**
 * @ClassName: GoodsSupply
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:36:14
 */
public class GoodsSupply {

    /* 主键ID */
    protected Long id;

    /* 物资ID */
    protected Long gid;

    /* 类型:1 属性,2 图片 */
    protected Integer style;

    /* 属性名 */
    protected String name;

    /* 属性值 */
    protected String value;

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

    public GoodsSupply() {
        super();
    }

    public GoodsSupply(Integer style, String name, String value) {
        super();
        this.style = style;
        this.name = name;
        this.value = value;
    }

    public GoodsSupply(Long gid, Integer style, String name, String value) {
        super();
        this.gid = gid;
        this.style = style;
        this.name = name;
        this.value = value;
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

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
