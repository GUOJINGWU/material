/**  
 * @Title: Page.java
 * @Package com.youzhicai.materialstore.common.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author XieXianpeng
 * @date 2018年9月29日 上午11:08:57
 * @version V1.0  
 */
package com.youzhicai.materialstore.handler;

import java.util.List;

/**
 * @ClassName: Page
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XieXianpeng
 * @date 2018年9月29日 上午11:08:57
 */
public class Page<T> {

    private int pageNum;

    private int pageSize;

    private int totalNum;

    private List<T> list;

    private int totalPageNum;

    /**
     * 创建一个新的实例 Page.
     * 
     * @param pageNum
     * @param pageSize
     * @param totalNum
     * @param list
     */
    public Page(int pageNum, int pageSize, int totalNum, List<T> list) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPageNum = (totalNum + pageSize - 1) / pageSize;
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

}
