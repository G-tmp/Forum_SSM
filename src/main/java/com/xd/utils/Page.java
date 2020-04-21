package com.xd.utils;

import java.util.List;


/**
 *  泛型分页类
 *
 * @param <E>
 */
public class Page<E> {
    
    private Integer size;        //一页多少条
    private Integer cur;         //当前第几页
    private Integer totalRecord; //一共多少条记录
    private Integer totalPage;   //一共多少页
    private List<E> list;        //存放当前页数据


    /**
     *  获取参数，计算 totalPage
     *
     * @param size  页数
     * @param cur   当前第几页
     * @param totalRecord   总记录条数
     */
    public void setProperties(Integer size,Integer cur,Integer totalRecord){
        this.size = size;
        this.totalRecord = totalRecord;
        this.list = list;

        // 计算有几页
        if (totalRecord%size == 0)
            this.totalPage = totalRecord/size;
        else
            this.totalPage = totalRecord/size + 1;

        // 限制 page,防止非法参数
        if (cur == null || cur <= 0)
            this.cur = 1;
        else if(cur > this.totalPage)
            this.cur = totalPage;
        else
            this.cur = cur;
    }




    public Integer getSize() {
        return size;
    }

    public Integer getCur() {
        return cur;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
