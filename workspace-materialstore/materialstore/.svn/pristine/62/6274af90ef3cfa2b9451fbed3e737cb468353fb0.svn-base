/**  
 * @Title: Error.java
 * @Package com.youzhicai.materialstore.common.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月9日 下午8:00:46
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.exception;

/**
 * @ClassName: Error
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月9日 下午8:00:46
 */
public enum Error {

    /** 数据为空 */
    NULL(30001, "数据为空"),

    /* ********************START**********--物资--********START************************* */
    /** 非法的物资分类ID */
    GOODS_UNABLE_TID(30101, "非法的物资分类ID"),

    /** 保存物资失败 */
    GOODS_FAIL_ADD(30102, "保存物资失败"),

    /** 物资编码重复 */
    GOODS_REPEAT_CODE(30103, "物资编码重复"),

    /** 物资名称长度过长 */
    GOODS_NAME_LIMIT(30104, "物资名称长度过长"),

    /** 计量单位长度过长 */
    GOODS_UNIT_LIMIT(30105, "计量单位长度过长"),

    /** 材质/品牌长度过长 */
    GOODS_BRAND_LIMIT(30106, "材质/品牌长度过长"),

    /** 规格型号长度过长 */
    GOODS_SPECIFICATIONS_LIMIT(30107, "规格型号长度过长"),

    /** 补充说明长度过长 */
    GOODS_REMARKS_LIMIT(30108, "补充说明长度过长"),
    
    /** 物资不存在 */
    GOODS_NOT_EXIST(30109, "物资不存在"),
    /* *********************END***********--物资--*********END************************** */

    /* ********************START*********--物资类型--*******START************************* */

    /* *********************END**********--物资类型--********END************************** */
    
    /* ********************START*********--物资审核--*******START************************* */
    /** 物资审核状态异常 */
    GOODSAPPROVE_NOT_EXIST(30501, "物资审核状态异常"),
    
    /* *********************END**********--物资审核--********END************************** */

    ;

    private Error(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
