/**  
 * @Title: GoodsDTO.java
 * @Package com.youzhicai.materialstore.dto
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:44:49
 * @version V1.0  
 */
package com.youzhicai.materialstore.dto;

import java.util.List;

import com.youzhicai.materialstore.entity.Goods;

/**
 * @ClassName: GoodsDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月20日 下午4:44:49
 */
public class GoodsDTO extends Goods {

    private Integer pageNum;

    private Integer pageSize;

    private List<GoodsSupplyDTO> goodsSupplys;

    private String[] codes;

    private GoodsApproveDTO goodsApprove;

    private String nameOrCode;

    private Integer approved;

    private Integer firstRankId;

    private Integer secondRankId;

    private Integer thirdRankId;

    private Long newGoodsId;

    private Boolean isGidDes;

    private Boolean isDiffSupplys;

    private List<GoodsExcelDTO> excelGoodsList;

    public GoodsDTO() {
        super();
    }

    public GoodsDTO(String companyId, Long tid) {
        super(companyId, tid);
    }

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

    public List<GoodsSupplyDTO> getGoodsSupplys() {
        return goodsSupplys;
    }

    public void setGoodsSupplys(List<GoodsSupplyDTO> goodsSupplys) {
        this.goodsSupplys = goodsSupplys;
    }

    public String[] getCodes() {
        return codes;
    }

    public void setCodes(String[] codes) {
        this.codes = codes;
    }

    public GoodsApproveDTO getGoodsApprove() {
        return goodsApprove;
    }

    public void setGoodsApprove(GoodsApproveDTO goodsApprove) {
        this.goodsApprove = goodsApprove;
    }

    public String getNameOrCode() {
        return nameOrCode;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
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

    public Long getNewGoodsId() {
        return newGoodsId;
    }

    public void setNewGoodsId(Long newGoodsId) {
        this.newGoodsId = newGoodsId;
    }

    public Boolean getIsGidDes() {
        return isGidDes;
    }

    public void setIsGidDes(Boolean isGidDes) {
        this.isGidDes = isGidDes;
    }

    public Boolean getIsDiffSupplys() {
        return isDiffSupplys;
    }

    public void setIsDiffSupplys(Boolean isDiffSupplys) {
        this.isDiffSupplys = isDiffSupplys;
    }

    public List<GoodsExcelDTO> getExcelGoodsList() {
        return excelGoodsList;
    }

    public void setExcelGoodsList(List<GoodsExcelDTO> excelGoodsList) {
        this.excelGoodsList = excelGoodsList;
    }

}
