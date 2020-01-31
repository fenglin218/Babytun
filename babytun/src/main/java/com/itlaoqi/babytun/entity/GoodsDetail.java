package com.itlaoqi.babytun.entity;

/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class GoodsDetail {
    private Long gdId;
    private Long goodsId;
    private String gdPicUrl;
    private Integer gdOrder;

    public Long getGdId() {
        return gdId;
    }

    public void setGdId(Long gdId) {
        this.gdId = gdId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGdPicUrl() {
        return gdPicUrl;
    }

    public void setGdPicUrl(String gdPicUrl) {
        this.gdPicUrl = gdPicUrl;
    }

    public Integer getGdOrder() {
        return gdOrder;
    }

    public void setGdOrder(Integer gdOrder) {
        this.gdOrder = gdOrder;
    }
}
