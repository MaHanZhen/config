package com.mhz.history.config.domin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coll_transform_formula")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class TransformFormula implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "ID")
    private String id;

    @JoinColumn(name = "DTU_MODEL")
    @ManyToOne
    private Dtu400V dtu400V;


    @JoinColumn(name = "METER_MODEL")
    @ManyToOne
    private Meter400V meter400V;


    /**
     * 监测项ID
     */

    @JoinColumn(name = "MONITOR_ITEM_ID")
    @ManyToOne
    private MeterChannel meterChannel;

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

    public Dtu400V getDtu400V() {
        return dtu400V;
    }

    public void setDtu400V(Dtu400V dtu400V) {
        this.dtu400V = dtu400V;
    }

    public Meter400V getMeter400V() {
        return meter400V;
    }

    public void setMeter400V(Meter400V meter400V) {
        this.meter400V = meter400V;
    }

    public MeterChannel getMeterChannel() {
        return meterChannel;
    }

    public void setMeterChannel(MeterChannel meterChannel) {
        this.meterChannel = meterChannel;
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
                ", dtu400V=" + dtu400V +
                ", meter400V=" + meter400V +
                ", meterChannel=" + meterChannel +
                ", realTimeMonitorItemMarker='" + realTimeMonitorItemMarker + '\'' +
                ", transformFormula='" + transformFormula + '\'' +
                '}';
    }
}
