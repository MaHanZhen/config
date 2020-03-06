package com.mhz.history.config.vo;

import com.mhz.history.config.domin.TransformFormula;

import javax.persistence.Entity;

@Entity
public class TransformFormulaVO extends TransformFormula {

    private String dtuName;

    private String channelAddress;

    private String channelName;

    private String rate;

    private String channelId;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDtuName() {
        return dtuName;
    }

    public void setDtuName(String dtuName) {
        this.dtuName = dtuName;
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


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TransformFormulaVO{");
        sb.append(super.toString());
        sb.append("dtuName='").append(dtuName).append('\'');
        sb.append(", channelAddress='").append(channelAddress).append('\'');
        sb.append(", channelName='").append(channelName).append('\'');
        sb.append(", rate='").append(rate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
