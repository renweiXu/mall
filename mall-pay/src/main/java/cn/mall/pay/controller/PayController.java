package cn.mall.pay.controller;

import cn.mall.pay.constant.Constant;
import cn.mall.pay.enums.PayTypeEnum;
import cn.mall.pay.service.PayContext;
import cn.mall.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(value=Constant.PAY_SERVER_CONTEXT)
public class PayController {

    @Resource
    private PayContext payContext;

    @GetMapping("createPay")
    public Result createPay(@RequestParam Map<String,Object> reqMap) throws Exception {
        String payType = (String)reqMap.get("payType");
        return payContext.getContext(PayTypeEnum.get(Integer.valueOf(payType))).createPay(reqMap);
    }
}
