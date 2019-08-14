package com.mhz.history.config.vo;

import com.mhz.history.config.domin.MeterChannel;

public class MeterChannelVO extends MeterChannel {

    public String keyWord;


    public String getKeyWord() {
        return keyWord;
    }


    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {

        return super.toString()+"MeterChannelParam{" +
                "keyWord='" + keyWord + '\'' +
                '}';
    }
}
