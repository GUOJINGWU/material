/**  
 * @Title: ParamLength.java
 * @Package com.youzhicai.materialstore.common.constant
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月10日 下午8:18:14
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.constant;

/**
 * @ClassName: ParamLength
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月10日 下午8:18:14
 */
public enum ParamLength {

    /** 物资名称 */
    GOODS_NAME(50),

    /** 计量单位 */
    GOODS_UNIT(5),

    /** 材质/品牌 */
    GOODS_BRAND(100),

    /** 规格型号 */
    GOODS_SPECIFICATIONS(100),

    /** 补充说明 */
    GOODS_REMARKS(250),

    ;

    private ParamLength(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
