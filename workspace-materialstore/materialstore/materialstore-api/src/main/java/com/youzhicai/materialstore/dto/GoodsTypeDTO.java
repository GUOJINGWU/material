/**  
 * @Title: GoodsTypeDTO.java
 * @Package com.youzhicai.materialstore.dto
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月18日 上午10:31:52
 * @version V1.0  
 */
package com.youzhicai.materialstore.dto;

import com.youzhicai.materialstore.entity.GoodsType;

/**
 * @ClassName: GoodsTypeDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月18日 上午10:31:52
 */
public class GoodsTypeDTO extends GoodsType {

    private Long firstId;

    private String firstName;

    private Long secondId;

    private String secondName;

    private Long thirdId;

    private String thirdName;

    private Long[] firstIds;

    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getSecondId() {
        return secondId;
    }

    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getThirdId() {
        return thirdId;
    }

    public void setThirdId(Long thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public Long[] getFirstIds() {
        return firstIds;
    }

    public void setFirstIds(Long[] firstIds) {
        this.firstIds = firstIds;
    }

}
