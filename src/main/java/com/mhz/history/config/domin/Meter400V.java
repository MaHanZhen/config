package com.mhz.history.config.domin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bhsb_clyb_meter_400v")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Meter400V implements Serializable {

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
     * 名称
     */
    @Column(name = "MODELNAME")
    private String modelName;


    /**
     * 生产厂家
     */
    @Column(name = "MANUFACTURER")
    private String manufacturer;


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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Meter400V{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", ratedElectricity='" + ratedElectricity + '\'' +
                ", ratedVolt='" + ratedVolt + '\'' +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
