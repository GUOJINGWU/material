/**  
 * @Title: MaterialStatus.java
 * @Package com.youzhicai.materialstore.common.constant
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月30日 上午9:45:34
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.constant;

/**
 * @ClassName: MaterialStatus
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月30日 上午9:45:34
 */
public enum MaterialStatus {

    /** 正常 */
    NORMAL(1),

    /** 删除 */
    DELETE(0),

    ;

    private MaterialStatus(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

}
