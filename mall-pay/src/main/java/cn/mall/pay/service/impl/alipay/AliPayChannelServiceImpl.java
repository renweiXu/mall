package cn.mall.pay.service.impl.alipay;

import cn.mall.pay.service.PayChannelService;
import cn.mall.utils.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("aliPayService")
public class AliPayChannelServiceImpl implements PayChannelService {


    @Override
    public Result createPay(Map<String, Object> reqMap) {
        return Result.success("创建成功","创建支付宝预支付订单");
    }

    @Override
    public Result refund(Map<String, Object> reqMap) {
        return Result.success("支付宝退款成功",null);
    }
}
