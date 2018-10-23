/**  
 * @Title: GoodsAddModel.java
 * @Package com.youzhicai.materialstore.web.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月13日 上午9:03:25
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.model;

import java.util.List;

/**
 * @ClassName: GoodsAddModel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月13日 上午9:03:25
 */
public class GoodsAddModel {

    private String brand;

    private String code;

    private String link;

    private String name;

    private String remarks;

    private String specifications;

    private List<String> supplyNames;

    private List<String> supplyValues;

    private Long tid;

    private String unit;

    private Integer used;

    private Integer approveStatus;

    private Long newGoodsId;

    private List<String> imgNames;

    private List<String> imgValues;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Long getTid() {
        return tid;
    }

    public List<String> getSupplyNames() {
        return supplyNames;
    }

    public void setSupplyNames(List<String> supplyNames) {
        this.supplyNames = supplyNames;
    }

    public List<String> getSupplyValues() {
        return supplyValues;
    }

    public void setSupplyValues(List<String> supplyValues) {
        this.supplyValues = supplyValues;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Long getNewGoodsId() {
        return newGoodsId;
    }

    public void setNewGoodsId(Long newGoodsId) {
        this.newGoodsId = newGoodsId;
    }

    public List<String> getImgNames() {
        return imgNames;
    }

    public void setImgNames(List<String> imgNames) {
        this.imgNames = imgNames;
    }

    public List<String> getImgValues() {
        return imgValues;
    }

    public void setImgValues(List<String> imgValues) {
        this.imgValues = imgValues;
    }

}
