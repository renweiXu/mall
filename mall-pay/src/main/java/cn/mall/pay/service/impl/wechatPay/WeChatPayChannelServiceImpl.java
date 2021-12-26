package cn.mall.pay.service.impl.wechatPay;

import cn.mall.pay.service.PayChannelService;
import cn.mall.utils.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("weChatPayService")
public class WeChatPayChannelServiceImpl implements PayChannelService {
    @Override
    public Result createPay(Map<String, Object> reqMap) {
        return Result.success("支付成功","创建微信预支付订单");
    }

    @Override
    public Result refund(Map<String, Object> reqMap) {
        return Result.success("微信退款成功",null);
    }
}
