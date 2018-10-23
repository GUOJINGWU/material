/**  
 * @Title: GoodsApproveServiceImpl.java
 * @Package com.youzhicai.materialstore.service.impl
 * @Description: 物资审核
 * @author XieXianpeng
 * @date 2018年10月20日 上午9:48:37
 * @version V1.0  
 */
package com.youzhicai.materialstore.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzhicai.materialstore.common.exception.Assertion;
import com.youzhicai.materialstore.common.exception.Error;
import com.youzhicai.materialstore.dao.GoodsApproveDAO;
import com.youzhicai.materialstore.dao.GoodsDAO;
import com.youzhicai.materialstore.dto.GoodsApproveDTO;
import com.youzhicai.materialstore.po.GoodsApprovePO;
import com.youzhicai.materialstore.service.GoodsApproveService;

/**
 * @ClassName: GoodsApproveServiceImpl
 * @Description: 物资审核
 * @author XieXianpeng
 * @date 2018年10月20日 上午9:48:37
 */
@Service
public class GoodsApproveServiceImpl implements GoodsApproveService {

    @Autowired
    private GoodsDAO goodsDAO;

    @Autowired
    private GoodsApproveDAO goodsApproveDAO;

    /*
     * @Title: approveHandle
     * @Description: 审核物资，更新审核状态
     * @param goodsApproveDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsApproveService#approveHandle(com.youzhicai.materialstore.dto.
     * GoodsApproveDTO)
     */
    @Transactional
    @Override
    public boolean approveHandle(GoodsApproveDTO goodsApproveDTO) {
        Long gid = goodsApproveDTO.getGid();
        String companyId = goodsApproveDTO.getCompanyId();
        Integer approveStatus = goodsApproveDTO.getApproveStatus();

        Assertion.NULL(gid, companyId, approveStatus);

        String remarks = goodsApproveDTO.getRemarks();

        // 物资是否存在
        Map<String, Object> queryGoodsMap = new HashMap<String, Object>();
        queryGoodsMap.put("id", gid);
        queryGoodsMap.put("companyId", companyId);
        if (goodsDAO.findOneById(queryGoodsMap) == null) {
            Assertion.ERROR(Error.GOODS_NOT_EXIST);
        }

        // 物资是否处于待审核状态
        GoodsApprovePO dbGoodsApprovePO = goodsApproveDAO.findByGid(gid);
        Integer dbApproveStatus;
        if (dbGoodsApprovePO == null || (dbApproveStatus = dbGoodsApprovePO.getApproveStatus()) == null || dbApproveStatus != 21) {
            Assertion.ERROR(Error.GOODSAPPROVE_NOT_EXIST);
        }

        // 更改审核状态
        GoodsApprovePO goodsApprovePO = new GoodsApprovePO();
        goodsApprovePO.setGid(gid);
        goodsApprovePO.setApproveStatus(approveStatus);
        goodsApprovePO.setRemarks(remarks);
        goodsApprovePO.setUpdateId(goodsApproveDTO.getUpdateId());
        goodsApprovePO.setUpdator(goodsApproveDTO.getUpdator());
        if (goodsApproveDAO.modify(goodsApprovePO) > 0) {
            return true;
        }

        return false;
    }

}
