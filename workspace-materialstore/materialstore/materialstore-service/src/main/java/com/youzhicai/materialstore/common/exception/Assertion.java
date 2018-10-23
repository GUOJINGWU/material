/**  
 * @Title: Assertion.java
 * @Package com.youzhicai.materialstore.common.exception
 * @Description: 业务异常断言
 * @author XieXianpeng
 * @date 2018年10月9日 下午7:55:28
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youzhicai.materialstore.common.constant.ParamLength;

/**
 * @ClassName: Assertion
 * @Description: 业务异常断言
 * @author XieXianpeng
 * @date 2018年10月9日 下午7:55:28
 */
public class Assertion {

    private static Logger logger = LoggerFactory.getLogger(Assertion.class);

    /*
     * 空字符串判断
     */
    protected static boolean empty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /*
     * 空白字符判断
     */
    protected static boolean blank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /*
     * 业务异常
     */
    protected static void throwBusinessException(Integer code, String msg, String cause) {
        if (empty(cause)) {
            logger.error("[code]:{} [msg]:{} [position]:{}", code, msg, Thread.currentThread().getStackTrace()[3]);
        } else {
            logger.error("[code]:{} [msg]:{} [position]:{} [cause]:{}", code, msg, Thread.currentThread().getStackTrace()[3], cause);
        }
        throw new BusinessException(code, msg);
    }

    /**
     * @Title: ERROR
     * @Description: 业务异常
     * @param error
     * @return void
     */
    public static void ERROR(Error error) {
        throwBusinessException(error.getCode(), error.getMsg(), null);
    }

    /**
     * @Title: ERROR
     * @Description: 业务异常
     * @param error
     * @return void
     */
    public static void ERROR(Error error, String cause) {
        throwBusinessException(error.getCode(), error.getMsg(), cause);
    }

    /**
     * @Title: NULL
     * @Description: 空值验证
     * @param objs
     * @return void
     */
    public static void NULL(Object... objs) {
        for (Object obj : objs) {
            if (obj == null || (obj instanceof String && empty((String) obj))) {
                throwBusinessException(Error.NULL.getCode(), Error.NULL.getMsg(), null);
            }
        }
    }

    /**
     * @Title: NULL
     * @Description: 空值验证
     * @param obj
     * @param error
     * @return void
     */
    public static void NULL(Object obj, Error error) {
        if (obj == null || (obj instanceof String && empty((String) obj))) {
            throwBusinessException(error.getCode(), error.getMsg(), null);
        }
    }

    /**
     * @Title: LIMIT
     * @Description: 字符串长度限制
     * @param str
     * @param paramLength
     * @param error
     * @return void
     */
    public static void LIMIT(String str, ParamLength paramLength, Error error) {
        if (str != null && str.length() > paramLength.getValue()) {
            String errorCause = new StringBuffer().append("String too long. ").append("String<=is=>").append(str).append(", ").append("Limit<=is=>")
                    .append(paramLength).toString();
            throwBusinessException(error.getCode(), error.getMsg(), errorCause);
        }
    }

}
