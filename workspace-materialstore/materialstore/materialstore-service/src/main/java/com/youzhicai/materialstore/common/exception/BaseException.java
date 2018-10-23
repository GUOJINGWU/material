/**  
 * @Title: BaseException.java
 * @Package com.youzhicai.materialstore.common.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月9日 下午4:02:19
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.exception;

/**
 * @ClassName: BaseException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月9日 下午4:02:19
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -6867043009075385754L;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

}
