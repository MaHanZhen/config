package com.mhz.history.config.domin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bhsb_clyb_dtu_400v")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Dtu400V implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "ID")
    private String id;

    /**
     * 型号
     */
    @Column(name = "MODEL")
    private String model;

    /**
     * 额定电流
     */
    @Column(name = "RATEDELECTRICITY")
    private String ratedElectricity;


    /**
     * 额定电压
     */
    @Column(name = "RATEDVOLT")
    private String ratedVolt;

    /**
     * 最大装表数
     */
    @Column(name = "MAXINSTALL")
    private String maxInstall;


    /**
     * 生产厂家
     */
    @Column(name = "MANUFACTURER")
    private String manufacturer;



    /**
     * 接收方式
     */
    @Column(name = "RECTYPE")
    private Boolean recType;


    /**
     * 传输格式
     */
    @Column(name = "TRANSFORMAT")
    private Boolean transFormat;


    /**
     * 解码方式
     */
    @Column(name = "DECODETYPE")
    private Boolean decodeType;


    /**
     * 网络型号
     */
    @Column(name = "NETWORKMODEL")
    private Boolean networkModel;

    @Column(name = "ENABLED")
    private Boolean enabled;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRatedElectricity() {
        return ratedElectricity;
    }

    public void setRatedElectricity(String ratedElectricity) {
        this.ratedElectricity = ratedElectricity;
    }

    public String getRatedVolt() {
        return ratedVolt;
    }

    public void setRatedVolt(String ratedVolt) {
        this.ratedVolt = ratedVolt;
    }

    public String getMaxInstall() {
        return maxInstall;
    }

    public void setMaxInstall(String maxInstall) {
        this.maxInstall = maxInstall;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getRecType() {
        return recType;
    }

    public void setRecType(Boolean recType) {
        this.recType = recType;
    }

    public Boolean getTransFormat() {
        return transFormat;
    }

    public void setTransFormat(Boolean transFormat) {
        this.transFormat = transFormat;
    }

    public Boolean getDecodeType() {
        return decodeType;
    }

    public void setDecodeType(Boolean decodeType) {
        this.decodeType = decodeType;
    }

    public Boolean getNetworkModel() {
        return networkModel;
    }

    public void setNetworkModel(Boolean networkModel) {
        this.networkModel = networkModel;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Dtu400V{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", ratedElectricity='" + ratedElectricity + '\'' +
                ", ratedVolt='" + ratedVolt + '\'' +
                ", maxInstall='" + maxInstall + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", recType=" + recType +
                ", transFormat=" + transFormat +
                ", decodeType=" + decodeType +
                ", networkModel=" + networkModel +
                ", enabled=" + enabled +
                '}';
    }
}
