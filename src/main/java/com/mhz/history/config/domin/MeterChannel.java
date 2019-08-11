package com.mhz.history.config.domin;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "perce_meter_channel")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class MeterChannel {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "ID")
    private String id;

    /*
     * 名称
     */
    @Column(name = "NAME")
    private String name;

    /*
     * 地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /*
     * 类型
     */
    @Column(name = "TYPE")
    private String type;

    /*
     * 数据长度
     */
    @Column(name = "DATALENGHT")
    private BigDecimal dataLenght;

    /*
     * 数据类型
     */
    @Column(name = "DATATYPE")
    private String dataType;


    /*
     * 采集频率
     */
    @Column(name = "RATE")
    private BigDecimal rate;

    /*
     * 计算方式
     */
    @Column(name = "METHOD")
    private String method;

    @Column(name = "ACC")
    private String acc;

    /*
     * 单位
     */
    @Column(name = "UNIT")
    private String unit;

    /*
     * 值类型
     */
    @Column(name = "VALUETYPE")
    private String valueType;

    /*
     * 值范围
     */
    @Column(name = "VALUERANGE")
    private String valueRange;

    @Column(name = "HILO")
    private String hilo;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @Column(name = "RECORDER")
    private String recorder;

    @Column(name = "RECORDDATE")
    private Date recordDate;

    @Column(name = "MODIFIER")
    private String modifier;

    @Column(name = "MODIFYDATE")
    private Date modifyDate;

    @Column(name = "DISABLER")
    private String disabler;

    @Column(name = "DISABLEDATE")
    private Date disableDate;

    /*
     * 附件
     */
    @Column(name = "ATTR")
    private String attr;

    /*
     * 是否可以进行虚拟计算
     */
    @Column(name = "CANVIRTUALCOUNT")
    private Boolean canvirtualCount;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getDataLenght() {
        return dataLenght;
    }

    public void setDataLenght(BigDecimal dataLenght) {
        this.dataLenght = dataLenght;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValueRange() {
        return valueRange;
    }

    public void setValueRange(String valueRange) {
        this.valueRange = valueRange;
    }

    public String getHilo() {
        return hilo;
    }

    public void setHilo(String hilo) {
        this.hilo = hilo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getDisabler() {
        return disabler;
    }

    public void setDisabler(String disabler) {
        this.disabler = disabler;
    }

    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Boolean getCanvirtualCount() {
        return canvirtualCount;
    }

    public void setCanvirtualCount(Boolean canvirtualCount) {
        this.canvirtualCount = canvirtualCount;
    }

    @Override
    public String toString() {
        return "MeterChannel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", dataLenght=" + dataLenght +
                ", dataType='" + dataType + '\'' +
                ", rate=" + rate +
                ", method='" + method + '\'' +
                ", acc='" + acc + '\'' +
                ", unit='" + unit + '\'' +
                ", valueType='" + valueType + '\'' +
                ", valueRange='" + valueRange + '\'' +
                ", hilo='" + hilo + '\'' +
                ", enabled=" + enabled +
                ", recorder='" + recorder + '\'' +
                ", recordDate=" + recordDate +
                ", modifier='" + modifier + '\'' +
                ", modifyDate=" + modifyDate +
                ", disabler='" + disabler + '\'' +
                ", disableDate=" + disableDate +
                ", attr='" + attr + '\'' +
                ", canvirtualCount=" + canvirtualCount +
                '}';
    }
}
