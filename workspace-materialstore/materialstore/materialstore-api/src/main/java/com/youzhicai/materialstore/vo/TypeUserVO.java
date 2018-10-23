/**  
 * @Title: TypeUserVO.java
 * @Package com.youzhicai.materialstore.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年10月10日 下午6:49:39
 * @version V1.0  
 */
package com.youzhicai.materialstore.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youzhicai.materialstore.entity.TypeUser;

/**
 * @ClassName: TypeUserVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年10月10日 下午6:49:39
 */
public class TypeUserVO extends TypeUser {

    @JsonIgnore
    protected String companyId;

    @JsonIgnore
    protected String companyName;

    @JsonIgnore
    protected Integer status;

    @JsonIgnore
    protected String createId;

    @JsonIgnore
    protected String creator;

    @JsonIgnore
    protected Date createTime;

    @JsonIgnore
    protected String updateId;

    @JsonIgnore
    protected String updator;

    @JsonIgnore
    protected Date updateTime;

}
