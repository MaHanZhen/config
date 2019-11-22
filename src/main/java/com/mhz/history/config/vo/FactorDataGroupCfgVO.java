package com.mhz.history.config.vo;

import com.mhz.history.config.domin.FactorDataGroupCfg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FactorDataGroupCfgVO {

    @Id
    private String id;

    private String name;

    private String handlerIdentify;

    private String handlerFields;


    private String uiControl;

    private String handlerFieldRates;

    private String channelAddress;

    private String channelName;

    private String channelRate;


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

    public String getUiControl() {
        return uiControl;
    }

    public void setUiControl(String uiControl) {
        this.uiControl = uiControl;
    }

    public String getHandlerFieldRates() {
        return handlerFieldRates;
    }

    public void setHandlerFieldRates(String handlerFieldRates) {
        this.handlerFieldRates = handlerFieldRates;
    }

    public String getChannelAddress() {
        return channelAddress;
    }

    public void setChannelAddress(String channelAddress) {
        this.channelAddress = channelAddress;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelRate() {
        return channelRate;
    }

    public void setChannelRate(String channelRate) {
        this.channelRate = channelRate;
    }
}
