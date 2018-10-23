/**  
 * @Title: TypeUserBusinessImpl.java
 * @Package com.youzhicai.materialstore.business.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月10日 下午7:22:24
 * @version V1.0  
 */
package com.youzhicai.materialstore.business.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youzhicai.materialstore.api.TypeUserAPI;
import com.youzhicai.materialstore.common.constant.Params;
import com.youzhicai.materialstore.dto.TypeUserDTO;
import com.youzhicai.materialstore.handler.BusinessAPI;
import com.youzhicai.materialstore.service.TypeUserService;

/**
 * @ClassName: TypeUserBusinessImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月10日 下午7:22:24
 */
@RestController
@RequestMapping(value = "typeuser", method = { RequestMethod.GET, RequestMethod.POST })
@BusinessAPI
public class TypeUserBusinessImpl implements TypeUserAPI {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TypeUserService typeUserService;

    @RequestMapping(value = "list", method = { RequestMethod.POST })
    @Override
    public Object findList(TypeUserDTO typeUserDTO) {
        typeUserDTO = Params.toObj(request, typeUserDTO);
        return typeUserService.findListByTidAndUid(typeUserDTO);
    }

}
