/**  
 * @Title: GoodsServiceImpl.java
 * @Package com.youzhicai.materialstore.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月20日 下午5:08:33
 * @version V1.0  
 */
package com.youzhicai.materialstore.service.impl;

import static com.youzhicai.materialstore.common.constant.MaterialStatus.NORMAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youzhicai.materialstore.common.constant.GoodsApproveStatus;
import com.youzhicai.materialstore.common.constant.GoodsConstant;
import com.youzhicai.materialstore.common.constant.MaterialStatus;
import com.youzhicai.materialstore.common.constant.ParamLength;
import com.youzhicai.materialstore.common.exception.Assertion;
import com.youzhicai.materialstore.common.exception.Error;
import com.youzhicai.materialstore.common.util.CodeUtil;
import com.youzhicai.materialstore.common.util.DESUtil;
import com.youzhicai.materialstore.common.util.POUtil;
import com.youzhicai.materialstore.dao.GoodsApproveDAO;
import com.youzhicai.materialstore.dao.GoodsDAO;
import com.youzhicai.materialstore.dao.GoodsSupplyDAO;
import com.youzhicai.materialstore.dao.GoodsTypeDAO;
import com.youzhicai.materialstore.dto.GoodsApproveDTO;
import com.youzhicai.materialstore.dto.GoodsDTO;
import com.youzhicai.materialstore.dto.GoodsExcelDTO;
import com.youzhicai.materialstore.dto.GoodsSupplyDTO;
import com.youzhicai.materialstore.handler.Page;
import com.youzhicai.materialstore.po.GoodsApprovePO;
import com.youzhicai.materialstore.po.GoodsPO;
import com.youzhicai.materialstore.po.GoodsSupplyPO;
import com.youzhicai.materialstore.po.GoodsTypePO;
import com.youzhicai.materialstore.service.GoodsService;
import com.youzhicai.materialstore.vo.GoodsAPIVO;
import com.youzhicai.materialstore.vo.GoodsApproveVO;
import com.youzhicai.materialstore.vo.GoodsSearchVO;
import com.youzhicai.materialstore.vo.GoodsSupplyVO;
import com.youzhicai.materialstore.vo.GoodsVO;

/**
 * @ClassName: GoodsServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月20日 下午5:08:33
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsTypeDAO goodsTypeDAO;

    @Autowired
    private GoodsDAO goodsDAO;

    @Autowired
    private GoodsSupplyDAO goodsSupplyDAO;

    @Autowired
    private GoodsApproveDAO goodsApproveDAO;

    private Map<String, Object> queryGoodsTypeMap(Map<String, Object> queryMap, MaterialStatus goodsTypeStatus, String companyId) {
        queryMap.put("status", goodsTypeStatus.getValue());
        queryMap.put("companyId", companyId);
        return queryMap;
    }

    /*
     * 物资查询参数
     */
    private Map<String, Object> queryGoodsTypeByIdMap(Long id, MaterialStatus goodsTypeStatus, String companyId) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("id", id);
        return queryGoodsTypeMap(queryMap, goodsTypeStatus, companyId);
    }

    /*
     * 物资查询参数
     */
    private Map<String, Object> queryGoodsTypeByTidMap(Long tid, MaterialStatus goodsTypeStatus, String companyId) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("tid", tid);
        return queryGoodsTypeMap(queryMap, goodsTypeStatus, companyId);
    }

    /*
     * @Title: nextGoodsCode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#nextGoodsCode(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public Map<String, Object> nextGoodsCode(GoodsDTO goodsDTO) {
        Long tid;
        String companyId;
        if ((tid = goodsDTO.getTid()) == null || StringUtils.isEmpty(companyId = goodsDTO.getCompanyId())
                || goodsTypeDAO.findGoodsTypeById(queryGoodsTypeByIdMap(tid, NORMAL, companyId)) == null) {
            // 参数异常
            throw new RuntimeException("参数异常");
        }

        // 当前分类下所有商品
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("tid", tid);
        queryMap.put("companyId", companyId);
        List<Integer> codes = goodsDAO.findSubCodeList(queryMap);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", CodeUtil.newCode(codes, GoodsConstant.CODE_LIMIT));

        return resultMap;
    }

    /*
     * @Title: addGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#addGoods(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Transactional
    @Override
    public long addGoods(GoodsDTO goodsDTO) {
        GoodsPO goodsPO = initGoodsPO(goodsDTO);

        if (goodsDAO.save(goodsPO) < 1) {
            Assertion.ERROR(Error.GOODS_FAIL_ADD);
        }

        // 审核意见
        GoodsApproveDTO goodsApproveDTO = goodsDTO.getGoodsApprove();
        Integer approveStatus;
        Assertion.NULL(goodsApproveDTO, (approveStatus = goodsApproveDTO.getApproveStatus()));
        GoodsApprovePO goodsApprovePO = new GoodsApprovePO();
        goodsApprovePO.setGid(goodsPO.getId());
        goodsApprovePO.setApproveStatus(approveStatus);
        goodsApprovePO.setCreateId(goodsDTO.getCreateId());
        goodsApprovePO.setCreator(goodsDTO.getCreator());
        if (goodsApproveDAO.save(goodsApprovePO) < 1) {
            Assertion.ERROR(Error.GOODS_FAIL_ADD);
        }

        // 可扩展属性
        List<GoodsSupplyDTO> goodsSupplys = goodsDTO.getGoodsSupplys();
        if (goodsSupplys != null && !goodsSupplys.isEmpty()) {
            addGoodsSupply(goodsSupplys, goodsPO.getId());
        }

        return goodsPO.getId();
    }

    /*
     * 保存物资扩展属性
     */
    @Transactional
    private void addGoodsSupply(List<GoodsSupplyDTO> goodsSupplys, long newGoodsId) {
        for (GoodsSupplyDTO goodsSupplyDTO : goodsSupplys) {
            // 添加物资扩展属性
            Integer style;
            String name;
            String value;
            Assertion.NULL(style = goodsSupplyDTO.getStyle(), name = goodsSupplyDTO.getName(), value = goodsSupplyDTO.getValue());
            goodsSupplyDAO.save(new GoodsSupplyPO(newGoodsId, style, name, value));
        }
    }

    /*
     * 完善物资信息
     */
    private GoodsPO initGoodsPO(GoodsDTO goodsDTO) {
        GoodsApproveDTO goodsApprove = goodsDTO.getGoodsApprove();
        if (goodsApprove == null || goodsApprove.getApproveStatus() == null) {
            Assertion.ERROR(Error.GOODS_FAIL_ADD);
        }

        Integer used = goodsDTO.getUsed();// 使用状态(必填项)
        String name = goodsDTO.getName();// 物资名称(必填项)
        String code = goodsDTO.getCode();// 物资编码(必填项)
        Long tid = goodsDTO.getTid();// 物资分类(必填项)
        String unit = goodsDTO.getUnit();// 计量单位(必填项)
        String companyId = goodsDTO.getCompanyId();
        String companyName = goodsDTO.getCompanyName();

        if (goodsApprove.getApproveStatus() != 11) {
            Assertion.NULL(used, name, code, tid, unit, companyId, companyName);
            // 验证分类ID
            if (goodsTypeDAO.findGoodsTypeById(queryGoodsTypeByIdMap(tid, NORMAL, companyId)) == null) {
                Assertion.ERROR(Error.GOODS_UNABLE_TID);
            }
        }

        String fullCode = null;
        if (tid != null && StringUtils.isNotEmpty(code)) {
            Long newGoodsId;
            // code是否已被占用
            Map<String, Object> queryGoodsMap = new HashMap<String, Object>();
            queryGoodsMap.put("tid", tid);
            queryGoodsMap.put("code", code);
            queryGoodsMap.put("companyId", companyId);
            queryGoodsMap.put("approveStatusList", new Long[] { 1L, 21L });
            queryGoodsMap.put("newGoodsId", (newGoodsId = goodsDTO.getNewGoodsId()) == null ? null : newGoodsId);
            if (goodsDAO.findOneByTidAndCode(queryGoodsMap) != null) {
                Assertion.ERROR(Error.GOODS_REPEAT_CODE);
            }

            // 全编码
            Map<String, Object> queryGoodsTypeCodesMap = new HashMap<String, Object>();
            queryGoodsTypeCodesMap.put("thirdRankId", tid);
            queryGoodsTypeCodesMap.put("companyId", companyId);
            Map<String, Object> allRankCodes = goodsTypeDAO.findAllRankCodes(queryGoodsTypeCodesMap);
            if (allRankCodes != null) {
                fullCode = (String) allRankCodes.get("firstRankCode") + allRankCodes.get("secondRankCode") + allRankCodes.get("thirdRankCode") + code;
            }
        }

        Assertion.LIMIT(name, ParamLength.GOODS_NAME, Error.GOODS_NAME_LIMIT);
        Assertion.LIMIT(unit, ParamLength.GOODS_UNIT, Error.GOODS_UNIT_LIMIT);

        String brand = goodsDTO.getBrand();
        Assertion.LIMIT(brand, ParamLength.GOODS_BRAND, Error.GOODS_BRAND_LIMIT);

        String specifications = goodsDTO.getSpecifications();
        Assertion.LIMIT(specifications, ParamLength.GOODS_SPECIFICATIONS, Error.GOODS_SPECIFICATIONS_LIMIT);

        String remarks = goodsDTO.getRemarks();
        Assertion.LIMIT(remarks, ParamLength.GOODS_REMARKS, Error.GOODS_REMARKS_LIMIT);

        String link = goodsDTO.getLink();

        // 添加物资
        GoodsPO goodsPO = new GoodsPO();
        goodsPO.setUsed(used);
        goodsPO.setName(name);
        goodsPO.setCode(code);
        goodsPO.setTid(tid);
        goodsPO.setUnit(unit);
        goodsPO.setCompanyId(companyId);
        goodsPO.setCompanyName(companyName);

        goodsPO.setBrand(brand);
        goodsPO.setSpecifications(specifications);
        goodsPO.setRemarks(remarks);
        goodsPO.setLink(link);
        goodsPO.setCreateId(goodsDTO.getCreateId());
        goodsPO.setCreator(goodsDTO.getCreator());
        goodsPO.setUpdateId(goodsDTO.getCreateId());
        goodsPO.setUpdator(goodsDTO.getUpdator());

        goodsPO.setFullCode(fullCode);

        goodsPO.setStatus(1);

        return goodsPO;
    }

    /*
     * @Title: checkCodes
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#checkCodes(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public List<GoodsAPIVO> checkCodes(GoodsDTO goodsDTO) {
        String companyId;
        String[] codes;
        if (StringUtils.isBlank(companyId = goodsDTO.getCompanyId()) || (codes = goodsDTO.getCodes()) == null || codes.length == 0) {
            return new ArrayList<>();
        }

        List<GoodsAPIVO> result = new ArrayList<GoodsAPIVO>();

        GoodsAPIVO goodsVO;
        for (String code : codes) {
            if (StringUtils.isBlank(code) || code.length() != 12) {// 标准编码格式：BG0100100001
                continue;
            }

            // 查询物资类型ID
            Map<String, Object> queryMap = new HashMap<String, Object>();
            queryMap.put("firstRankCode", code.substring(0, 2));
            queryMap.put("secondRankCode", code.substring(2, 4));
            queryMap.put("thirdRankCode", code.substring(4, 7));
            queryMap.put("companyId", companyId);
            GoodsTypePO goodsTypePO = goodsTypeDAO.findThirdRankOneByCodes(queryMap);

            if (goodsTypePO == null) {
                continue;
            }

            // 物资是否存在
            Map<String, Object> queryGoodsMap = new HashMap<String, Object>();
            queryGoodsMap.put("tid", goodsTypePO.getId());
            queryGoodsMap.put("code", code.substring(7, 12));
            queryGoodsMap.put("companyId", companyId);
            queryGoodsMap.put("approveStatusList", new Long[] { 1L });
            GoodsPO goodsPO = goodsDAO.findOneByTidAndCode(queryGoodsMap);
            if (goodsPO != null) {
                goodsVO = POUtil.convert(goodsPO, GoodsAPIVO.class);
                Map<String, Object> queryGoodsTypeCodesMap = new HashMap<String, Object>();
                queryGoodsTypeCodesMap.put("thirdRankId", goodsTypePO.getId());
                queryGoodsTypeCodesMap.put("companyId", companyId);
                Map<String, Object> allRankCodes = goodsTypeDAO.findAllRankCodes(queryGoodsTypeCodesMap);
                if (allRankCodes != null) {
                    goodsVO.setTypeCodes(
                            (String) allRankCodes.get("firstRankCode") + allRankCodes.get("secondRankCode") + allRankCodes.get("thirdRankCode"));
                }
                result.add(goodsVO);
            }
        }

        return result;
    }

    /*
     * @Title: findGoodsDetail
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#findGoodsDetail(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public GoodsVO findGoodsDetail(GoodsDTO goodsDTO) {
        Long goodsId = goodsDTO.getId();
        String companyId = goodsDTO.getCompanyId();
        if (goodsId == null || StringUtils.isEmpty(companyId)) {
            return null;
        }

        Map<String, Object> queryGoodsMap = new HashMap<String, Object>();
        queryGoodsMap.put("id", goodsId);
        queryGoodsMap.put("companyId", companyId);
        GoodsPO goodsPO = goodsDAO.findOneById(queryGoodsMap);
        if (goodsPO == null) {
            return null;
        }
        GoodsVO goodsVO = POUtil.convert(goodsPO, GoodsVO.class);

        // 查询扩展属性
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("gid", goodsPO.getId());
        List<GoodsSupplyVO> goodsSupplys = POUtil.convert(goodsSupplyDAO.findListByGid(queryMap), GoodsSupplyVO.class,
                new TypeToken<List<GoodsSupplyVO>>() {
                }.getType());
        goodsVO.setGoodsSupplys(goodsSupplys);
        // 是否区分扩展属性
        Boolean isDiffSupplys;
        if ((isDiffSupplys = goodsDTO.getIsDiffSupplys()) != null && isDiffSupplys) {
            List<GoodsSupplyVO> attrSupplys = new ArrayList<GoodsSupplyVO>();
            List<GoodsSupplyVO> imgSupplys = new ArrayList<GoodsSupplyVO>();
            Integer style;
            for (GoodsSupplyVO goodsSupply : goodsSupplys) {
                if (goodsSupply == null) {
                    continue;
                }
                style = goodsSupply.getStyle();
                if (style == 1) {
                    attrSupplys.add(goodsSupply);
                } else if (style == 2) {
                    imgSupplys.add(goodsSupply);
                }
            }
            goodsVO.setAttrSupplys(attrSupplys);
            goodsVO.setImgSupplys(imgSupplys);
        }

        // 查询审核状态
        goodsVO.setGoodsApprove(POUtil.convert(goodsApproveDAO.findByGid(goodsPO.getId()), GoodsApproveVO.class));

        // 分类信息
        Map<String, Object> queryGoodsTypeCodesMap = new HashMap<String, Object>();
        queryGoodsTypeCodesMap.put("thirdRankId", goodsVO.getTid());
        queryGoodsTypeCodesMap.put("companyId", companyId);
        goodsVO.setAllRank(goodsTypeDAO.findAllRankCodes(queryGoodsTypeCodesMap));

        return goodsVO;
    }

    /*
     * @Title: findGoodsListForSearch
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see
     * com.youzhicai.materialstore.service.GoodsService#findGoodsListForSearch(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public Page<GoodsSearchVO> findGoodsListForSearch(GoodsDTO goodsDTO) throws Exception {
        // 查询条件：启用，物资名称/编码，物资分类，审核状态，
        int pageNum;
        int pageSize;
        pageNum = (pageNum = goodsDTO.getPageNum()) > 0 ? pageNum : 1;
        pageSize = (pageSize = goodsDTO.getPageSize()) > 0 ? pageSize : 10;

        String companyId;
        Integer used = goodsDTO.getUsed();
        String nameOrCode;
        Long tid = goodsDTO.getTid();

        GoodsApproveDTO goodsApprove = goodsDTO.getGoodsApprove();
        Integer approveStatus = goodsApprove == null ? null : goodsApprove.getApproveStatus();

        Integer approved = goodsDTO.getApproved();

        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("start", (pageNum - 1) * pageSize);
        queryMap.put("num", pageSize);
        queryMap.put("companyId", StringUtils.isEmpty(companyId = goodsDTO.getCompanyId()) ? "0" : companyId);
        queryMap.put("used", used);
        queryMap.put("tid", tid);
        queryMap.put("approveStatus", approveStatus);
        queryMap.put("approved", approved);
        queryMap.put("nameOrCode", StringUtils.isEmpty(nameOrCode = goodsDTO.getNameOrCode()) ? null : "%" + nameOrCode + "%");
        List<Map<String, Object>> searchList = goodsDAO.findListForSearch(queryMap);
        Integer totalNum = goodsDAO.findListForSearchCount(queryMap);

        List<GoodsSearchVO> list = POUtil.convert(searchList, GoodsSearchVO.class, new TypeToken<List<GoodsSearchVO>>() {
        }.getType());

        Boolean isGidDes = goodsDTO.getIsGidDes();
        if (isGidDes != null && isGidDes) {
            for (GoodsSearchVO goodsSearchVO : list) {
                goodsSearchVO.setGidDES(DESUtil.encryptStr(String.valueOf(goodsSearchVO.getId())));
            }
        }

        return new Page<GoodsSearchVO>(pageNum, pageSize, totalNum == null ? 0 : totalNum, list);
    }

    /*
     * @Title: countForUsedOrNot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#countForUsedOrNot(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public Map<String, Object> countForUsedOrNot(GoodsDTO goodsDTO) {
        String companyId;
        String nameOrCode;
        Long tid = goodsDTO.getTid();

        GoodsApproveDTO goodsApprove = goodsDTO.getGoodsApprove();
        Integer approveStatus = goodsApprove == null ? null : goodsApprove.getApproveStatus();

        Integer approved = goodsDTO.getApproved();

        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("companyId", StringUtils.isEmpty(companyId = goodsDTO.getCompanyId()) ? "0" : companyId);
        queryMap.put("used", 1);
        queryMap.put("tid", tid);
        queryMap.put("approveStatus", approveStatus);
        queryMap.put("approved", approved);
        queryMap.put("nameOrCode", StringUtils.isEmpty(nameOrCode = goodsDTO.getNameOrCode()) ? null : "%" + nameOrCode + "%");
        Integer usedCount = goodsDAO.findListForSearchCount(queryMap);

        queryMap.put("used", "0");
        Integer unUsedCount = goodsDAO.findListForSearchCount(queryMap);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("usedCount", usedCount == null ? 0 : usedCount);
        result.put("unUsedCount", unUsedCount == null ? 0 : unUsedCount);

        return result;
    }

    /*
     * @Title: countForApprovedOrNot
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see
     * com.youzhicai.materialstore.service.GoodsService#countForApprovedOrNot(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public Map<String, Object> countForApprovedOrNot(GoodsDTO goodsDTO) {
        String companyId;
        String nameOrCode;
        GoodsApproveDTO goodsApprove = goodsDTO.getGoodsApprove();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("companyId", StringUtils.isEmpty(companyId = goodsDTO.getCompanyId()) ? "0" : companyId);
        queryMap.put("tid", goodsDTO.getTid());
        queryMap.put("approveStatus", goodsApprove == null ? null : goodsApprove.getApproveStatus());
        queryMap.put("approved", 1);
        queryMap.put("nameOrCode", StringUtils.isEmpty(nameOrCode = goodsDTO.getNameOrCode()) ? null : "%" + nameOrCode + "%");
        Integer approvedCount = goodsDAO.findListForSearchCount(queryMap);

        queryMap.put("approved", "0");
        Integer unApprovedCount = goodsDAO.findListForSearchCount(queryMap);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("approvedCount", approvedCount == null ? 0 : approvedCount);
        result.put("unApprovedCount", unApprovedCount == null ? 0 : unApprovedCount);

        return result;
    }

    /*
     * @Title: findGoodsListForSearchAPI
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#findGoodsListForSearchAPI(com.youzhicai.materialstore.dto.
     * GoodsDTO)
     */
    @Override
    public Page<GoodsAPIVO> findGoodsListForSearchAPI(GoodsDTO goodsDTO) {
        // 查询条件：启用，物资名称/编码，物资分类，审核状态，
        Integer pageNum = ((pageNum = goodsDTO.getPageNum()) != null && pageNum > 0) ? pageNum : 1;
        Integer pageSize = ((pageSize = goodsDTO.getPageSize()) != null && pageSize > 0) ? pageSize : 10;
        String companyId = StringUtils.isEmpty(companyId = goodsDTO.getCompanyId()) ? "0" : companyId;
        String nameOrCode = goodsDTO.getNameOrCode();

        // 三级分类集合
        List<Long> tids = null;

        Integer firstRankId = goodsDTO.getFirstRankId();
        Integer secondRankId = goodsDTO.getSecondRankId();
        Integer thirdRankId = goodsDTO.getThirdRankId();

        GoodsTypePO firstGoodsTypePO;
        GoodsTypePO secondGoodsTypePO;
        GoodsTypePO thirdGoodsTypePO;

        Map<String, Object> queryGoodsTypeMap = new HashMap<String, Object>();
        queryGoodsTypeMap.put("companyId", companyId);
        queryGoodsTypeMap.put("id", firstRankId);
        if (firstRankId != null && firstRankId != 0 && (firstGoodsTypePO = goodsTypeDAO.findGoodsTypeById(queryGoodsTypeMap)) != null) {
            Map<String, Object> queryCodesMap = new HashMap<String, Object>();
            queryCodesMap.put("firstRankId", firstRankId);

            queryGoodsTypeMap.put("id", secondRankId);
            if (secondRankId != null && secondRankId != 0 && (secondGoodsTypePO = goodsTypeDAO.findGoodsTypeById(queryGoodsTypeMap)) != null
                    && secondGoodsTypePO.getPid() == firstGoodsTypePO.getId()) {
                queryCodesMap.put("secondRankId", secondRankId);

                queryGoodsTypeMap.put("id", thirdRankId);
                if (thirdRankId != null && thirdRankId != 0 && (thirdGoodsTypePO = goodsTypeDAO.findGoodsTypeById(queryGoodsTypeMap)) != null
                        && thirdGoodsTypePO.getPid() == secondGoodsTypePO.getId()) {
                    queryCodesMap.put("thirdRankId", thirdRankId);
                }
            }

            tids = goodsTypeDAO.findThirdRankCodes(queryCodesMap);
            if (tids != null && tids.isEmpty()) {
                tids = null;
            }
        }

        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("start", (pageNum - 1) * pageSize);
        queryMap.put("num", pageSize);
        queryMap.put("companyId", companyId);
        queryMap.put("nameOrCode", StringUtils.isEmpty(nameOrCode) ? null : "%" + nameOrCode + "%");
        queryMap.put("tids", tids);

        List<Map<String, Object>> searchList = goodsDAO.findGoodsListForSearchAPI(queryMap);
        Integer totalNum = goodsDAO.findGoodsListForSearchAPICount(queryMap);

        List<GoodsAPIVO> list = POUtil.convert(searchList, GoodsAPIVO.class, new TypeToken<List<GoodsAPIVO>>() {
        }.getType());

        Map<String, Object> querySupplyMap;
        for (GoodsAPIVO goodsAPIVO : list) {
            // 扩展属性查询
            querySupplyMap = new HashMap<String, Object>();
            querySupplyMap.put("gid", goodsAPIVO.getId());
            querySupplyMap.put("style", 1);
            goodsAPIVO.setGoodsSupplys(
                    POUtil.convert(goodsSupplyDAO.findListByGid(querySupplyMap), GoodsSupplyVO.class, new TypeToken<List<GoodsSupplyVO>>() {
                    }.getType()));
        }

        return new Page<GoodsAPIVO>(pageNum, pageSize, totalNum == null ? 0 : totalNum, list);
    }

    /*
     * @Title: modifyGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#modifyGoods(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Transactional
    @Override
    public boolean modifyGoods(GoodsDTO goodsDTO) {
        Long newGoodsId;
        String companyId;
        Assertion.NULL(newGoodsId = goodsDTO.getNewGoodsId(), companyId = goodsDTO.getCompanyId());

        Map<String, Object> queryGoodsMap = new HashMap<String, Object>();
        queryGoodsMap.put("id", newGoodsId);
        queryGoodsMap.put("companyId", companyId);
        if (goodsDAO.findOneById(queryGoodsMap) == null) {
            Assertion.ERROR(Error.GOODS_FAIL_ADD);
        }

        GoodsPO goodsPO = initGoodsPO(goodsDTO);
        goodsPO.setId(newGoodsId);

        // 变更审核状态
        GoodsApproveDTO goodsApproveDTO = goodsDTO.getGoodsApprove();
        Integer approveStatus;
        Assertion.NULL(goodsApproveDTO, (approveStatus = goodsApproveDTO.getApproveStatus()));
        GoodsApprovePO dbGoodsApprovePO = goodsApproveDAO.findByGid(newGoodsId);
        Integer dbApproveStatus = null;
        if (dbGoodsApprovePO == null || (dbApproveStatus = dbGoodsApprovePO.getApproveStatus()) == null) {
            Assertion.ERROR(Error.GOODS_FAIL_ADD);
        }
        if (dbApproveStatus == 1 || dbApproveStatus == 31) {
            // 先删除上次审核状态
            GoodsApprovePO delGoodsApprovePO = new GoodsApprovePO();
            delGoodsApprovePO.setGid(newGoodsId);
            delGoodsApprovePO.setStatus(MaterialStatus.DELETE.getValue());
            if (goodsApproveDAO.modify(delGoodsApprovePO) < 1) {
                Assertion.ERROR(Error.GOODS_FAIL_ADD);
            }
            // 保存新状态
            GoodsApprovePO addGoodsApprovePO = new GoodsApprovePO();
            addGoodsApprovePO.setGid(goodsPO.getId());
            addGoodsApprovePO.setApproveStatus(approveStatus);
            addGoodsApprovePO.setCreateId(goodsDTO.getCreateId());
            addGoodsApprovePO.setCreator(goodsDTO.getCreator());
            if (goodsApproveDAO.save(addGoodsApprovePO) < 1) {
                Assertion.ERROR(Error.GOODS_FAIL_ADD);
            }
        } else {
            // 修改审核状态11 --> 21
            if (dbApproveStatus == 11 && approveStatus == 21) {
                GoodsApprovePO modGoodsApprovePO = new GoodsApprovePO();
                modGoodsApprovePO.setGid(goodsPO.getId());
                modGoodsApprovePO.setApproveStatus(approveStatus);
                modGoodsApprovePO.setCreateId(goodsDTO.getCreateId());
                modGoodsApprovePO.setCreator(goodsDTO.getCreator());
                if (goodsApproveDAO.modify(modGoodsApprovePO) < 1) {
                    Assertion.ERROR(Error.GOODS_FAIL_ADD);
                }
            }
        }

        // 修改物资信息
        goodsDAO.modify(goodsPO);

        // 修改扩展属性
        List<Long> ableSupplyIds = new ArrayList<Long>();// 需要保留的属性ID
        List<GoodsSupplyDTO> ableSupplys = new ArrayList<GoodsSupplyDTO>();// 需要新增的属性
        List<GoodsSupplyDTO> goodsSupplys;
        if ((goodsSupplys = goodsDTO.getGoodsSupplys()) != null && !goodsSupplys.isEmpty()) {
            Long supplyId;
            for (GoodsSupplyDTO goodsSupplyDTO : goodsSupplys) {
                supplyId = goodsSupplyDAO
                        .findOneByFull(new GoodsSupplyPO(newGoodsId, goodsSupplyDTO.getStyle(), goodsSupplyDTO.getName(), goodsSupplyDTO.getValue()));
                if (supplyId == null || supplyId <= 0) {
                    ableSupplys.add(goodsSupplyDTO);
                } else {
                    ableSupplyIds.add(supplyId);
                }
            }
        }
        if (ableSupplyIds.isEmpty()) {
            ableSupplyIds.add(0L);
        }
        // 删除不可用扩展属性
        GoodsSupplyPO deleteGoodsSupplyPO = new GoodsSupplyPO();
        deleteGoodsSupplyPO.setAbleSupplyIds(ableSupplyIds);
        deleteGoodsSupplyPO.setGid(newGoodsId);
        deleteGoodsSupplyPO.setUpdateId(goodsDTO.getUpdateId());
        deleteGoodsSupplyPO.setUpdator(goodsDTO.getUpdator());
        goodsSupplyDAO.deleteByGidExclude(deleteGoodsSupplyPO);
        // 新增扩展属性
        for (GoodsSupplyDTO goodsSupplyDTO : ableSupplys) {
            goodsSupplyDAO.save(new GoodsSupplyPO(newGoodsId, goodsSupplyDTO.getStyle(), goodsSupplyDTO.getName(), goodsSupplyDTO.getValue()));
        }

        return true;
    }

    /*
     * @Title: goodsApproveStatusList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#goodsApproveStatusList()
     */
    @Override
    public Object goodsApproveStatusList() {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (GoodsApproveStatus approveStatus : GoodsApproveStatus.values()) {
            map = new HashMap<String, Object>();
            map.put("code", approveStatus.getCode());
            map.put("msg", approveStatus.getMsg());
            result.add(map);
        }

        return result;
    }

    /*
     * @Title: deleteGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#deleteGoods(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public boolean deleteGoods(GoodsDTO goodsDTO) {
        Long id;
        String companyId;
        if ((id = goodsDTO.getId()) == null || StringUtils.isEmpty(companyId = goodsDTO.getCompanyId())) {
            return false;
        }

        Map<String, Object> queryGoodsMap = new HashMap<String, Object>();
        queryGoodsMap.put("id", id);
        queryGoodsMap.put("companyId", companyId);
        if (goodsDAO.findOneById(queryGoodsMap) == null) {
            return false;
        }

        GoodsApprovePO goodsApprovePO = goodsApproveDAO.findByGid(id);
        Integer approveStatus;
        if (goodsApprovePO == null || (approveStatus = goodsApprovePO.getApproveStatus()) == null || approveStatus == 1 || approveStatus == 21) {
            return false;
        }

        GoodsPO goodsPO = new GoodsPO();
        goodsPO.setId(id);
        goodsPO.setStatus(0);
        goodsPO.setUpdateId(goodsDTO.getUpdateId());
        goodsPO.setUpdator(goodsDTO.getUpdator());
        if (goodsDAO.modify(goodsPO) > 0) {
            return true;
        }
        return false;
    }

    /*
     * @Title: findAlikeGoodsList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see
     * com.youzhicai.materialstore.service.GoodsService#findAlikeGoodsList(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Override
    public List<GoodsVO> findAlikeGoodsList(GoodsDTO goodsDTO) throws Exception {
        String brand = goodsDTO.getBrand();
        String specifications = goodsDTO.getSpecifications();
        String companyId = goodsDTO.getCompanyId();
        if (StringUtils.isEmpty(companyId) || (StringUtils.isEmpty(brand) && StringUtils.isEmpty(specifications))) {
            return new ArrayList<>();
        }

        List<GoodsPO> resultPO = new ArrayList<GoodsPO>();
        List<Long> ids = new ArrayList<Long>();

        // 查询品牌相似物资
        Map<String, Object> queryBrandMap = new HashMap<String, Object>();
        queryBrandMap.put("companyId", companyId);
        List<GoodsPO> brandAlikeGoods;
        out: for (String ap : alikeParams(brand)) {
            queryBrandMap.put("brand", ap + "%");
            brandAlikeGoods = goodsDAO.findListAlikeGoods(queryBrandMap);
            if (brandAlikeGoods == null || brandAlikeGoods.isEmpty()) {
                continue;
            }
            for (GoodsPO goodsPO : brandAlikeGoods) {
                if (goodsPO == null || goodsPO.getId() == null || ids.contains(goodsPO.getId())) {
                    continue;
                }
                ids.add(goodsPO.getId());
                resultPO.add(goodsPO);
                if (resultPO.size() >= 10) {
                    break out;
                }
            }
        }

        // 查询型号相似物资
        if (resultPO.size() < 10) {
            Map<String, Object> querySpecificationsMap = new HashMap<String, Object>();
            querySpecificationsMap.put("companyId", companyId);
            List<GoodsPO> specificationsAlikeGoods;
            out: for (String ap : alikeParams(specifications)) {
                querySpecificationsMap.put("specifications", ap + "%");
                specificationsAlikeGoods = goodsDAO.findListAlikeGoods(querySpecificationsMap);
                if (specificationsAlikeGoods == null || specificationsAlikeGoods.isEmpty()) {
                    continue;
                }
                for (GoodsPO goodsPO : specificationsAlikeGoods) {
                    if (goodsPO == null || goodsPO.getId() == null || ids.contains(goodsPO.getId())) {
                        continue;
                    }
                    ids.add(goodsPO.getId());
                    resultPO.add(goodsPO);
                    if (resultPO.size() >= 10) {
                        break out;
                    }
                }
            }
        }

        if (resultPO.size() > 10) {
            resultPO = resultPO.subList(0, 10);
        }
        List<GoodsVO> result = POUtil.convert(resultPO, GoodsVO.class, new TypeToken<List<GoodsVO>>() {
        }.getType());

        Boolean isGidDes = goodsDTO.getIsGidDes();
        if (isGidDes != null && isGidDes) {
            for (GoodsVO goodsVO : result) {
                goodsVO.setGidDES(DESUtil.encryptStr(String.valueOf(goodsVO.getId())));
            }
        }

        return result;
    }

    private List<String> alikeParams(String str) {
        if (StringUtils.isEmpty(str)) {
            return new ArrayList<>();
        }

        List<String> chs = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        for (char ch : str.toCharArray()) {
            buffer.append(ch);
            chs.add(buffer.toString());
        }

        List<String> list = new ArrayList<String>();
        for (int i = chs.size() - 1; i >= 0; i--) {
            list.add(chs.get(i));
        }

        return list;
    }

    /*
     * @Title: saveExcelGoods
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param goodsDTO
     * @return
     * @see com.youzhicai.materialstore.service.GoodsService#saveExcelGoods(com.youzhicai.materialstore.dto.GoodsDTO)
     */
    @Transactional
    @Override
    public Map<String, Object> saveExcelGoods(GoodsDTO goodsDTO) {
        Map<String, Object> result = new HashMap<String, Object>();

        String companyId = goodsDTO.getCompanyId();
        String companyName = goodsDTO.getCompanyName();
        List<GoodsExcelDTO> excelGoodsList = goodsDTO.getExcelGoodsList();
        if (StringUtils.isEmpty(companyId) || StringUtils.isEmpty(companyName) || excelGoodsList == null || excelGoodsList.isEmpty()) {
            result.put("code", 20001);
            result.put("msg", "物资保存数据异常！");
            return result;
        }

        // 封装入库数据
        List<GoodsDTO> list = new ArrayList<GoodsDTO>();
        for (int i = 0; i < excelGoodsList.size(); i++) {

            GoodsExcelDTO goodsExcelDTO = excelGoodsList.get(i);
            String firstRankName = goodsExcelDTO.getFirstRankName();
            String secondRankName = goodsExcelDTO.getSecondRankName();
            String thirdRankName = goodsExcelDTO.getThirdRankName();

            if (StringUtils.isEmpty(firstRankName) || StringUtils.isEmpty(secondRankName) || StringUtils.isEmpty(thirdRankName)) {
                result.put("code", 20001);
                result.put("msg", "第" + (i + 4) + "行，物资分类数据异常！");
                return result;
            }

            // 根据物资分类名称查询分类
            // 一级分类是否存在
            GoodsTypePO firstType = goodsTypeDAO.findOneByNameAndPid(queryGoodsTypeMap(firstRankName, 0L, companyId, 1));
            if (firstType == null) {
                result.put("code", 20001);
                result.put("msg", "第" + (i + 4) + "行，一级分类不存在！");
                return result;
            }

            // 二级分类是否存在
            GoodsTypePO secondType = goodsTypeDAO.findOneByNameAndPid(queryGoodsTypeMap(secondRankName, firstType.getId(), companyId, 2));
            if (secondType == null) {
                result.put("code", 20001);
                result.put("msg", "第" + (i + 4) + "行，二级分类不存在！");
                return result;
            }

            // 三级分类是否存在
            GoodsTypePO thirdType = goodsTypeDAO.findOneByNameAndPid(queryGoodsTypeMap(thirdRankName, secondType.getId(), companyId, 3));
            if (thirdType == null) {
                result.put("code", 20001);
                result.put("msg", "第" + (i + 4) + "行，三级分类不存在！");
                return result;
            }

            // 物资名称是否重复
            Map<String, Object> queryGoodsMap = new HashMap<String, Object>();
            queryGoodsMap.put("tid", thirdType.getId());
            queryGoodsMap.put("code", goodsExcelDTO.getName());
            queryGoodsMap.put("companyId", companyId);
            queryGoodsMap.put("approveStatusList", new Long[] { 1L, 21L });
            if (goodsDAO.findOneByTidAndName(queryGoodsMap) != null) {
                result.put("code", 20001);
                result.put("msg", "第" + (i + 4) + "行，物资名称已存在！");
                return result;
            }

            GoodsDTO gd = new GoodsDTO();
            gd.setCompanyId(companyId);
            gd.setCompanyName(companyName);
            gd.setName(goodsExcelDTO.getName());
//            gd.setCode(code);
            gd.setTid(thirdType.getId());
            gd.setUnit(goodsExcelDTO.getUnit());
            gd.setBrand(goodsExcelDTO.getUnit());
            gd.setSpecifications(goodsExcelDTO.getSpecifications());
            gd.setRemarks(goodsExcelDTO.getRemarks());
            gd.setLink(goodsExcelDTO.getLink());
            gd.setUsed(goodsExcelDTO.getUsed());
            gd.setGoodsSupplys(goodsExcelDTO.getGoodsSupplys());
            gd.setGoodsApprove(new GoodsApproveDTO(21));

            list.add(gd);
        }

        // 入库保存
        for (int j = 0; j < list.size(); j++) {
            GoodsDTO dto = list.get(j);
            // 生成物资编码
            Map<String, Object> nextGoodsCode = nextGoodsCode(new GoodsDTO(dto.getCompanyId(), dto.getTid()));
            dto.setCode((String) nextGoodsCode.get("code"));

            GoodsPO goodsPO = initGoodsPO(dto);
            int save = 0;

            int c = 2;
            while ((save = goodsDAO.save(goodsPO)) == 0) {
                if (c > 3) {// 尝试三次
                    break;
                }
                goodsPO = initGoodsPO(dto);
                ++c;
            }

            if (save < 1) {
                result.put("code", 20001);
                result.put("msg", "第" + (j + 4) + "行，物资保存失败！");
                return result;
            } else {
                // 审核意见
                GoodsApproveDTO goodsApproveDTO = dto.getGoodsApprove();
                Integer approveStatus;
                Assertion.NULL(goodsApproveDTO, (approveStatus = goodsApproveDTO.getApproveStatus()));
                GoodsApprovePO goodsApprovePO = new GoodsApprovePO();
                goodsApprovePO.setGid(goodsPO.getId());
                goodsApprovePO.setApproveStatus(approveStatus);
                goodsApprovePO.setCreateId(dto.getCreateId());
                goodsApprovePO.setCreator(dto.getCreator());
                goodsApproveDAO.save(goodsApprovePO);

                // 可扩展属性
                List<GoodsSupplyDTO> goodsSupplys = dto.getGoodsSupplys();
                if (goodsSupplys != null && !goodsSupplys.isEmpty()) {
                    addGoodsSupply(goodsSupplys, goodsPO.getId());
                }
            }
        }

        result.put("code", 1000);
        result.put("msg", "保存成功");
        return result;
    }

    private Map<String, Object> queryGoodsTypeMap(String name, Long pid, String companyId, int rank) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("name", name);
        queryMap.put("pid", pid);
        queryMap.put("companyId", companyId);
        queryMap.put("rank", rank);
        return queryMap;
    }

}
