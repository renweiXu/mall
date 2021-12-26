package cn.mall.pay.service;

import cn.mall.utils.Result;

import java.util.Map;

/**
 * 支付逻辑
 */
public interface PayChannelService {

    /**
     * 创建支付
     * @param reqMap
     * @return
     */
    public Result createPay(Map<String,Object> reqMap);


    /**
     * 退款
     * @param reqMap
     * @return
     */
    public Result refund(Map<String,Object> reqMap);
}
