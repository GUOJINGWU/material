/**  
 * @Title: TypeUserWebAPI.java
 * @Package com.youzhicai.materialstore.web.api
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月10日 下午7:27:05
 * @version V1.0  
 */
package com.youzhicai.materialstore.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youzhicai.materialstore.api.TypeUserAPI;
import com.youzhicai.materialstore.dto.TypeUserDTO;
import com.youzhicai.materialstore.handler.UnLogin;
import com.youzhicai.materialstore.web.api.model.TypeUserModel;
import com.youzhicai.materialstore.web.api.transfer.DataTransfer;
import com.youzhicai.materialstore.web.api.transfer.TransferType;

/**
 * @ClassName: TypeUserWebAPI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月10日 下午7:27:05
 */
@RestController
@RequestMapping("webapi/typeuser")
public class TypeUserWebAPI {

    @Autowired
    private TypeUserAPI typeUserAPI;

    /**
     * @Title: findList
     * @Description: 一级物资分类与用户关联查询
     * @param tid
     * @param uid
     * @return DataTransfer<List<TypeUserVO>>
     */
    @UnLogin
    @RequestMapping("list")
    public DataTransfer<Object> findList(@RequestBody TypeUserModel typeUserModel) {
        TypeUserDTO typeUserDTO = new TypeUserDTO();
        typeUserDTO.setTids(typeUserModel.getTids());
        typeUserDTO.setCompanyId(typeUserModel.getCompanyId());

        Object obj = typeUserAPI.findList(typeUserDTO);

        if (obj != null) {
            return new DataTransfer<Object>(TransferType.SUCCESS.getCode(), TransferType.SUCCESS.getMsg(), obj);
        } else {
            return new DataTransfer<Object>(TransferType.DATANULL.getCode(), TransferType.DATANULL.getMsg());
        }
    }

}
