package com.itlaoqi.babytunseckill.entity;

import java.util.Date;

/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class Order {
    private Long orderId;
    private String orderNo;
    private Integer orderStatus;
    private String userid;
    private String recvName;
    private String recvAddress;
    private String recvMobile;
    private Float postage;
    private Float amout;
    private Date createTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }

    public String getRecvMobile() {
        return recvMobile;
    }

    public void setRecvMobile(String recvMobile) {
        this.recvMobile = recvMobile;
    }

    public Float getPostage() {
        return postage;
    }

    public void setPostage(Float postage) {
        this.postage = postage;
    }

    public Float getAmout() {
        return amout;
    }

    public void setAmout(Float amout) {
        this.amout = amout;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
