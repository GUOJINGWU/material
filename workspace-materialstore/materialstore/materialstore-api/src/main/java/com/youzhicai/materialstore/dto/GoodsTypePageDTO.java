/**  
 * @Title: GoodsTypePageDTO.java
 * @Package com.youzhicai.materialstore.dto
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月29日 上午11:58:58
 * @version V1.0  
 */
package com.youzhicai.materialstore.dto;

/**
 * @ClassName: GoodsTypePageDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月29日 上午11:58:58
 */
public class GoodsTypePageDTO {

    private int pageNum;

    private int pageSize;

    private Long firstId;

    private Long secondId;

    private Long thirdId;

    private String companyId;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }

    public Long getSecondId() {
        return secondId;
    }

    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }

    public Long getThirdId() {
        return thirdId;
    }

    public void setThirdId(Long thirdId) {
        this.thirdId = thirdId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

}
