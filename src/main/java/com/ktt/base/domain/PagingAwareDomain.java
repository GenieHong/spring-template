package com.ktt.base.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PagingAwareDomain extends BaseDomain {

    @JsonIgnore
    private String total;

    @JsonIgnore
    private String page;

    @JsonIgnore
    private String rowNum;

    @JsonIgnore
    private String maxPage;

    @JsonIgnore
    private String pageNum;

    @JsonIgnore
    private String pageCon;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(String maxPage) {
        this.maxPage = maxPage;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageCon() {
        return pageCon;
    }

    public void setPageCon(String pageCon) {
        this.pageCon = pageCon;
    }
}
