/**  
 * @Title: TypeTokens.java
 * @Package com.youzhicai.materialstore.common.constant
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月19日 下午1:54:42
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.constant;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.TypeToken;

import com.youzhicai.materialstore.vo.GoodsTypeVO;

/**
 * @ClassName: TypeTokens
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月19日 下午1:54:42
 */
public class TypeTokens {

    public static final Type GoodsTypeVO = new TypeToken<List<GoodsTypeVO>>() {
    }.getType();

}
