/**  
 * @Title: DataConfig.java
 * @Package com.youzhicai.materialstore.common.config
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月18日 上午10:01:51
 * @version V1.0  
 */
package com.youzhicai.materialstore.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DataConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月18日 上午10:01:51
 */
@Component
@MapperScan("com.youzhicai.materialstore.dao")
public class DataConfig {

}
