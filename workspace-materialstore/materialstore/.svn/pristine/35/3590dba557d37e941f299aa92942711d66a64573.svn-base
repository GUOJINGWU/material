/**  
 * @Title: BusinessException.java
 * @Package com.youzhicai.materialstore.common.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月9日 下午4:05:40
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.exception;

/**
 * @ClassName: BusinessException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月9日 下午4:05:40
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = -7369043257170184269L;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 信息
     */
    private Throwable data;

    public BusinessException() {
        super();
    }

    public BusinessException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(Integer code, String msg, Throwable data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 重写fillInStackTrace,异常打印不输出栈信息
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Throwable getData() {
        return data;
    }

    public void setData(Throwable data) {
        this.data = data;
    }

}
