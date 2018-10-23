/**  
 * @Title: TypeUserService.java
 * @Package com.youzhicai.materialstore.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月10日 下午7:05:31
 * @version V1.0  
 */
package com.youzhicai.materialstore.service;

import java.util.List;

import com.youzhicai.materialstore.dto.TypeUserDTO;
import com.youzhicai.materialstore.vo.TypeUserVO;

/**
 * @ClassName: TypeUserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月10日 下午7:05:31
 */
public interface TypeUserService {

    public Object findListByTidAndUid(TypeUserDTO typeUserDTO);
    
}
