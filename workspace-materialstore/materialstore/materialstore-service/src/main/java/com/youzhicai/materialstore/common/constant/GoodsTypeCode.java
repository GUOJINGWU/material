/**  
 * @Title: GoodsTypeCode.java
 * @Package com.youzhicai.materialstore.common.constant
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月30日 下午12:02:13
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.constant;

/**
 * @ClassName: GoodsTypeCode
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月30日 下午12:02:13
 */
public enum GoodsTypeCode {

    FIRST(999), SECOND(99), THIRD(999);

    private GoodsTypeCode(int limit) {
        this.limit = limit;
    }

    private int limit;

    public int getLimit() {
        return limit;
    }

}
