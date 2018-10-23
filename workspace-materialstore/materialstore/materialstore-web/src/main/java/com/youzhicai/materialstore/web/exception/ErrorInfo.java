/**  
 * @Title: ErrorInfo.java
 * @Package com.youzhicai.materialstore.web.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月9日 下午7:26:59
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.exception;

import com.youzhicai.materialstore.common.exception.BusinessException;

/**
 * @ClassName: ErrorInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月9日 下午7:26:59
 */
public class ErrorInfo {

    public static String getExpMsg(Exception e) {
        String msg = null;
        if (e instanceof BusinessException) {
            msg = ((BusinessException) e).getMsg();
        }
        return msg;
    }

}
