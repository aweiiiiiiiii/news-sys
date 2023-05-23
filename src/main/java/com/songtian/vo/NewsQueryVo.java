package com.songtian.vo;

import lombok.Data;

@Data
public class NewsQueryVo {
    //新闻类别的ID
    private Integer ntid;
    //页码
    private Integer pageNo=1;
    //每页显示的记录条数
    private Integer pageSize=10;

    public Integer getNtid() {
        return ntid;
    }

    public void setNtid(Integer ntid) {
        this.ntid = ntid;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
