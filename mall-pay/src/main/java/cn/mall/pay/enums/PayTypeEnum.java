package cn.mall.pay.enums;

import lombok.Data;

public enum PayTypeEnum {

    ALIPAY("支付宝",0,"aliPayService"),
    WECHATPay("微信支付",1,"weChatPayService");

    private String name;

    private Integer payType;

    private String channel;

    PayTypeEnum(String name,Integer payType,String channel){
        this.name = name;
        this.payType = payType;
        this.channel = channel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public static PayTypeEnum get(Integer payType) throws Exception {
        for (PayTypeEnum payTypeEnum : PayTypeEnum.values()) {
            if (payTypeEnum.getPayType() == payType){
                return payTypeEnum;
            }
        }
        throw new Exception("暂不支持该支付方式");
    }
}
