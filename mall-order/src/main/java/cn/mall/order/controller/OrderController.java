package cn.mall.order.controller;

import cn.mall.order.constant.Constant;
import cn.mall.utils.Result;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constant.ORDER_SERVER_CONTEXT)
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * 要使用自动刷新功能 必须配置 autoRefreshed = true，即使 @NacosPropertySource 配置了 autoRefreshed = true
     */
    @NacosValue(value = "${cn.orderNum}",autoRefreshed = true)
    private Integer orderNum;

    /**
     * 用了value注解 貌似不支持自动刷新了，即使 @NacosPropertySource 配置了 autoRefreshed = true
     */
    @Value(value = "${cn.orderExpressTime}")
    private Integer orderExpressTime;

    @NacosInjected
    private NamingService namingService;

    @GetMapping("/getOrder")
    public Result getOrder(String orderNo){
        logger.info("下单限制次数：{},订单过期时间：{}",orderNum,orderExpressTime);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("orderNo",orderNo);
        resultMap.put("productName","商品名称");
        resultMap.put("purchaseNum",10);
        resultMap.put("price",new BigDecimal("10.5"));
        return Result.success("获取订单成功",resultMap);
    }

    @PostMapping("/createOrder")
    public Result createOrder(){
        return Result.success("创建订单成功","000001000002000003");
    }

    @PostMapping("/updateOrder")
    public Result updateOrder(String service) {
        return Result.success("修改订单成功","000001000002000003");
    }
}
