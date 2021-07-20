package com.imooc.cloud.mall.practice.advertisement.model.request;

public class AdvertisementListReq {

    private String keyword;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "AdvertisementListReq{" +
            "keyword='" + keyword + '\'' +
            ", pageNum=" + pageNum +
            ", pageSize=" + pageSize +
            '}';
    }
}