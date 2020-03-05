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



    public void setProperties(Integer size,Integer cur,Integer totalRecord){
        this.size = size;
        this.cur = cur;
        this.totalRecord = totalRecord;
        this.list = list;

        if (totalRecord%size == 0)
            this.totalPage = totalRecord/size;
        else
            this.totalPage = totalRecord/size + 1;
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
