package com.itlaoqi.babytun.entity;

/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class GoodsParam {
    private Long gpId;
    private String gpParamName;
    private String gpParamValue;
    private Long goodsId;
    private Integer gpOrder;

    public Long getGpId() {
        return gpId;
    }

    public void setGpId(Long gpId) {
        this.gpId = gpId;
    }

    public String getGpParamName() {
        return gpParamName;
    }

    public void setGpParamName(String gpParamName) {
        this.gpParamName = gpParamName;
    }

    public String getGpParamValue() {
        return gpParamValue;
    }

    public void setGpParamValue(String gpParamValue) {
        this.gpParamValue = gpParamValue;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGpOrder() {
        return gpOrder;
    }

    public void setGpOrder(Integer gpOrder) {
        this.gpOrder = gpOrder;
    }
}
