/**  
 * @Title: GoodsApproveBusinessImpl.java
 * @Package com.youzhicai.materialstore.business.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月20日 上午9:44:57
 * @version V1.0  
 */
package com.youzhicai.materialstore.business.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.youzhicai.materialstore.api.GoodsApproveAPI;
import com.youzhicai.materialstore.common.constant.Params;
import com.youzhicai.materialstore.dto.GoodsApproveDTO;
import com.youzhicai.materialstore.service.GoodsApproveService;

/**
 * @ClassName: GoodsApproveBusinessImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月20日 上午9:44:57
 */
@RestController
public class GoodsApproveBusinessImpl implements GoodsApproveAPI {

    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private GoodsApproveService goodsApproveService;
    
    /*
     * @Title: approveHandle
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsApproveDTO
     * @return
     * @see com.youzhicai.materialstore.api.GoodsApproveAPI#approveHandle(com.youzhicai.materialstore.dto.GoodsApproveDTO)
     */
    @Override
    public boolean approveHandle(GoodsApproveDTO goodsApproveDTO) {
        goodsApproveDTO = Params.toObj(request, goodsApproveDTO);
        return goodsApproveService.approveHandle(goodsApproveDTO);
    }

}
