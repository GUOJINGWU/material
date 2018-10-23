/**  
 * @Title: GoodsVO.java
 * @Package com.youzhicai.materialstore.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月11日 下午2:26:30
 * @version V1.0  
 */
package com.youzhicai.materialstore.vo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.youzhicai.materialstore.entity.Goods;

/**
 * @ClassName: GoodsVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月11日 下午2:26:30
 */
public class GoodsVO extends Goods {

    /* 扩展属性 */
    private List<GoodsSupplyVO> goodsSupplys;

    /* 审核信息 */
    private GoodsApproveVO goodsApprove;

    /* 分类信息 */
    private Map<String, Object> allRank;

    /* 加密物资ID */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String gidDES;

    /* 物资属性集 */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GoodsSupplyVO> attrSupplys;

    /* 物资图片集 */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GoodsSupplyVO> imgSupplys;

    public List<GoodsSupplyVO> getGoodsSupplys() {
        return goodsSupplys;
    }

    public void setGoodsSupplys(List<GoodsSupplyVO> goodsSupplys) {
        this.goodsSupplys = goodsSupplys;
    }

    public GoodsApproveVO getGoodsApprove() {
        return goodsApprove;
    }

    public void setGoodsApprove(GoodsApproveVO goodsApprove) {
        this.goodsApprove = goodsApprove;
    }

    public Map<String, Object> getAllRank() {
        return allRank;
    }

    public void setAllRank(Map<String, Object> allRank) {
        this.allRank = allRank;
    }

    public String getGidDES() {
        return gidDES;
    }

    public void setGidDES(String gidDES) {
        this.gidDES = gidDES;
    }

    public List<GoodsSupplyVO> getAttrSupplys() {
        return attrSupplys;
    }

    public void setAttrSupplys(List<GoodsSupplyVO> attrSupplys) {
        this.attrSupplys = attrSupplys;
    }

    public List<GoodsSupplyVO> getImgSupplys() {
        return imgSupplys;
    }

    public void setImgSupplys(List<GoodsSupplyVO> imgSupplys) {
        this.imgSupplys = imgSupplys;
    }

}
