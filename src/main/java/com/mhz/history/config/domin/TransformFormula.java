package com.mhz.history.config.domin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coll_transform_formula")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class TransformFormula implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "ID")
    private String id;


    /**
     * DTU型号ID
     */
    @Column(name = "DTU_MODEL")
    private String dtuModel;

    /**
     * 监测表型号ID
     */
    @Column(name = "METER_MODEL")
    private String meterModel;

    /**
     * 监测项ID
     */
    @Column(name = "MONITOR_ITEM_ID")
    private String monitorItemId;

    /**
     * 实时数据监测项标识
     */
    @Column(name = "REAL_TIME_MONITOR_ITEM_MARKER")
    private String realTimeMonitorItemMarker;

    /**
     * 转换公式
     */
    @Column(name = "TRANSFORM_FORMULA")
    private String transformFormula;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDtuModel() {
        return dtuModel;
    }

    public void setDtuModel(String dtuModel) {
        this.dtuModel = dtuModel;
    }

    public String getMeterModel() {
        return meterModel;
    }

    public void setMeterModel(String meterModel) {
        this.meterModel = meterModel;
    }

    public String getMonitorItemId() {
        return monitorItemId;
    }

    public void setMonitorItemId(String monitorItemId) {
        this.monitorItemId = monitorItemId;
    }

    public String getRealTimeMonitorItemMarker() {
        return realTimeMonitorItemMarker;
    }

    public void setRealTimeMonitorItemMarker(String realTimeMonitorItemMarker) {
        this.realTimeMonitorItemMarker = realTimeMonitorItemMarker;
    }

    public String getTransformFormula() {
        return transformFormula;
    }

    public void setTransformFormula(String transformFormula) {
        this.transformFormula = transformFormula;
    }

    @Override
    public String toString() {
        return "TransformFormula{" +
                "id='" + id + '\'' +
                ", dtuModel='" + dtuModel + '\'' +
                ", meterModel='" + meterModel + '\'' +
                ", monitorItemId='" + monitorItemId + '\'' +
                ", realTimeMonitorItemMarker='" + realTimeMonitorItemMarker + '\'' +
                ", transformFormula='" + transformFormula + '\'' +
                '}';
    }
}
