package cn.mall.pay.service;

import cn.mall.pay.enums.PayTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PayContext {

    @Autowired
    private Map<String,PayChannelService> channelMap;

    public PayChannelService getContext(PayTypeEnum payType){
        return channelMap.get(payType.getChannel());
    }
}
