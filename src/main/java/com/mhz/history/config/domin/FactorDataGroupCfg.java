package com.mhz.history.config.domin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mea_factor_data_group_cfg")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class FactorDataGroupCfg {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "ID")
    private String id;

    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     *
     */
    @Column(name = "KEY")
    private String key;

    /**
     *
     */
    @Column(name = "FULL_KEY")
    private String fullKey;


    /**
     *  信道ID
     */
    @Column(name = "FACTOR_ID")
    private String factorId;

    /**
     *  含有率的二级父类ID
     */
    @Column(name = "CROSS_PARENT_ID")
    private String crossParentId;

    /**
     * 类型
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 上级分类
     */
    @Column(name = "PARENT_ID")
    private String parentId;



    /**
     * 分层
     */
    @Column(name = "LAYER_ORDER")
    private String layerOrder;

    /**
     * 名称
     */
    @Column(name = "UI_CONTROL")
    private String uiControl;


    /**
     * 自定义处理器的标识
     */
    @Column(name = "HANDLER_IDENTIFY")
    private String handlerIdentify;

    /**
     * 自定义处理器用到的字段
     */
    @Column(name = "HANDLER_FIELDS")
    private String handlerFields;

    /**
     * 自定义处理器用到的字段频率
     */
    @Column(name = "HANDLER_FIELD_RATES")
    private String handlerFieldRates;




    /**
     * 单位
     */
    @Column(name = "UNIT")
    private String unit;


    /**
     *
     */
    @Column(name = "SHOW_PRICE")
    private String showPrice;


    /**
     * 排序
     */
    @Column(name = "ORDER_NO")
    private Integer orderNo;


    /**
     * 名称
     */
    @Column(name = "ENABLED")
    private Boolean enabled;


    /**
     *
     */
    @Column(name = "data_name")
    private String dataName;

    /**
     *
     */
    @Column(name = "target_field")
    private String targetField;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFullKey() {
        return fullKey;
    }

    public void setFullKey(String fullKey) {
        this.fullKey = fullKey;
    }

    public String getFactorId() {
        return factorId;
    }

    public void setFactorId(String factorId) {
        this.factorId = factorId;
    }

    public String getCrossParentId() {
        return crossParentId;
    }

    public void setCrossParentId(String crossParentId) {
        this.crossParentId = crossParentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLayerOrder() {
        return layerOrder;
    }

    public void setLayerOrder(String layerOrder) {
        this.layerOrder = layerOrder;
    }

    public String getUiControl() {
        return uiControl;
    }

    public void setUiControl(String uiControl) {
        this.uiControl = uiControl;
    }

    public String getHandlerIdentify() {
        return handlerIdentify;
    }

    public void setHandlerIdentify(String handlerIdentify) {
        this.handlerIdentify = handlerIdentify;
    }

    public String getHandlerFields() {
        return handlerFields;
    }

    public void setHandlerFields(String handlerFields) {
        this.handlerFields = handlerFields;
    }

    public String getHandlerFieldRates() {
        return handlerFieldRates;
    }

    public void setHandlerFieldRates(String handlerFieldRates) {
        this.handlerFieldRates = handlerFieldRates;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getTargetField() {
        return targetField;
    }

    public void setTargetField(String targetField) {
        this.targetField = targetField;
    }
}
