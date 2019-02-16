package com.lanyou.test.viewpagerdemo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 */

public class CarControlMenuBean implements Serializable {


    /**
     * appModule : CtrlVehicle
     * displayItemCode : 1
     * displayItemName : 空调
     * switchAuth : 2
     * time : null
     */

    private String appModule; //模块
    public String displayItemCode;//显示项编码
    private String displayItemName;//显示项名称
    public String switchAuth;//开关权限,0：关；1：开；2：开关
    private int time;//时长，单位：S

    private HashMap<String, String> cold;
    private HashMap<String, String> hot;

    public HashMap<String, String> getCold() {
        return cold;
    }

    public void setCold(HashMap<String, String> cold) {
        this.cold = cold;
    }

    public WindData getWind() {
        return wind;
    }

    public void setWind(WindData wind) {
        this.wind = wind;
    }

    private WindData wind;

    public static class WindData {

        private String min;
        private String max;
        private String mid;

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }
    }


    public HashMap<String, String> getHot() {
        return hot;
    }

    public void setHot(HashMap<String, String> hot) {
        this.hot = hot;
    }

    public String getAppModule() {
        return appModule;
    }

    public void setAppModule(String appModule) {
        this.appModule = appModule;
    }

    public String getDisplayItemCode() {
        return displayItemCode;
    }

    public void setDisplayItemCode(String displayItemCode) {
        this.displayItemCode = displayItemCode;
    }

    public String getDisplayItemName() {
        return displayItemName;
    }

    public void setDisplayItemName(String displayItemName) {
        this.displayItemName = displayItemName;
    }

    public String getSwitchAuth() {
        return switchAuth;
    }

    public void setSwitchAuth(String switchAuth) {
        this.switchAuth = switchAuth;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

/*    @Override
    public String toString() {
        return "CarControlMenuBean{" +
                "appModule='" + appModule + '\'' +
                ", displayItemCode='" + displayItemCode + '\'' +
                ", displayItemName='" + displayItemName + '\'' +
                ", switchAuth='" + switchAuth + '\'' +
                ", time=" + time +
                '}';
    }*/

    /**
     * 获取控制菜单初始数据
     */
    public static ArrayList<CarControlMenuBean> getChangedDataList() {
        ArrayList<CarControlMenuBean> beans = new ArrayList<>();

        CarControlMenuBean bean5 = new CarControlMenuBean();
        bean5.setAppModule("002");
        bean5.setDisplayItemCode(ControlConstants.ITEM_SKY);
        bean5.setDisplayItemName("天窗");
        bean5.setSwitchAuth("2");
        bean5.setTime(10);

        CarControlMenuBean bean6 = new CarControlMenuBean();
        bean6.setAppModule("002");
        bean6.setDisplayItemCode(ControlConstants.ITEM_SIDE);
        bean6.setDisplayItemName("车窗");
        bean6.setSwitchAuth("2");
        bean6.setTime(10);

        beans.add(bean5);
        beans.add(bean6);
        return beans;
    }

    public static ArrayList<CarControlMenuBean> getControlMenuDataList() {
        ArrayList<CarControlMenuBean> beans = new ArrayList<>();


        CarControlMenuBean bean7 = new CarControlMenuBean();
        bean7.setAppModule("002");
        bean7.setDisplayItemCode(ControlConstants.ITEM_BACK_DOOR);
        bean7.setDisplayItemName("后背门");
        bean7.setSwitchAuth("2");
        bean7.setTime(10);

        beans.add(bean7);
        return beans;
    }
}
