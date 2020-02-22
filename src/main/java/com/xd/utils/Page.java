package com.xd.utils;

import com.xd.pojo.Reply;

import java.util.List;

public class Page<E> {
    
    private Integer size;
    private Integer cur;
    private Integer totalRecord;
    private Integer totalPage;
    private List<E> list;



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
