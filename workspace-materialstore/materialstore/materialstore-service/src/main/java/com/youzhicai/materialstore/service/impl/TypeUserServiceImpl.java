/**  
 * @Title: TypeUserServiceImpl.java
 * @Package com.youzhicai.materialstore.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月10日 下午7:05:57
 * @version V1.0  
 */
package com.youzhicai.materialstore.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youzhicai.materialstore.common.util.POUtil;
import com.youzhicai.materialstore.dao.TypeUserDAO;
import com.youzhicai.materialstore.dto.TypeUserDTO;
import com.youzhicai.materialstore.po.TypeUserPO;
import com.youzhicai.materialstore.service.TypeUserService;
import com.youzhicai.materialstore.vo.TypeUserVO;

/**
 * @ClassName: TypeUserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月10日 下午7:05:57
 */
@Service
public class TypeUserServiceImpl implements TypeUserService {

    @Autowired
    private TypeUserDAO typeUserDAO;

    /*
     * @Title: findListByTidAndUid
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param typeUserDTO
     * @return
     * @see com.youzhicai.materialstore.service.TypeUserService#findListByTidAndUid(com.youzhicai.materialstore.dto.
     * TypeUserDTO)
     */
    @Override
    public Object findListByTidAndUid(TypeUserDTO typeUserDTO) {
        String companyId;
        Long[] tids;
        if (StringUtils.isEmpty(companyId = typeUserDTO.getCompanyId()) || (tids = typeUserDTO.getTids()) == null || tids.length < 1) {
            return new ArrayList<>();
        }

        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("tids", tids);
        queryMap.put("companyId", companyId);
        List<TypeUserPO> typeUserPOs = typeUserDAO.findListByTids(queryMap);

        List<TypeUserVO> convert = POUtil.convert(typeUserPOs, TypeUserVO.class, new TypeToken<List<TypeUserVO>>() {
        }.getType());

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> tidMap;
        List<Object> userList;
        for (Long tid : tids) {
            tidMap = new HashMap<String, Object>();
            tidMap.put("tid", tid);
            userList = new ArrayList<Object>();
            for (TypeUserVO typeUserVO : convert) {
                if (typeUserVO == null) {
                    continue;
                }
                if (tid == typeUserVO.getTid()) {
                    userList.add(typeUserVO.getUid());// 用户ID
                }
            }
            tidMap.put("uids", userList);
            result.add(tidMap);
        }

        return result;
    }

}
