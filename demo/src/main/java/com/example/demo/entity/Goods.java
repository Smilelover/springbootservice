package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * goods
 * @author 
 */
public class Goods implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品主图url列表 用逗号分隔
     */
    private String picUrls;

    /**
     * 商品详情图url列表 用逗号分隔
     */
    private String detailPicUrls;

    /**
     * 商品简介
     */
    private String synopsis;

    /**
     * 商品标签id
     */
    private Integer tagId;

    /**
     * 商品类别id
     */
    private Integer categoryId;

    /**
     * 商品权重
     */
    private Integer weight;

    /**
     * 是否为实物 0:虚拟 1:实物
     */
    private Byte isReal;

    /**
     * 市场参考价
     */
    private BigDecimal marketPrice;

    /**
     * 采购价
     */
    private BigDecimal purchasePrice;

    /**
     * 消耗积分
     */
    private Integer point;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 商品状态 1:上架中 2:下架中
     */
    private Byte status;

    /**
     * 删除状态 0:未删除 1:已删除
     */
    private Byte deleteFlag;

    /**
     * 审核状态 0:未审核 1:审核通过 2:审核不通过
     */
    private Byte checkStatus;

    /**
     * 审核人id
     */
    private Long checkBy;

    /**
     * 审核时间
     */
    private Integer checkTime;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 修改人id
     */
    private Long updateBy;

    /**
     * 创建时间时间戳
     */
    private Long timeCreate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public String getDetailPicUrls() {
        return detailPicUrls;
    }

    public void setDetailPicUrls(String detailPicUrls) {
        this.detailPicUrls = detailPicUrls;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Byte getIsReal() {
        return isReal;
    }

    public void setIsReal(Byte isReal) {
        this.isReal = isReal;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Long getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(Long checkBy) {
        this.checkBy = checkBy;
    }

    public Integer getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Integer checkTime) {
        this.checkTime = checkTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Long timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}