package cn.mall.order.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @NacosValue(value = "${cn.orderNum}",autoRefreshed = true)
    private Integer orderNum;

    @NacosValue(value = "${cn.orderExpressTime}",autoRefreshed = true)
    private Integer orderExpressTime;

    @NacosInjected
    private NamingService namingService;

    @GetMapping("/getOrder")
    public String getOrder(String orderNo){
        logger.info("请求参数，{}",orderNo);
        return "下单限制次数："+orderNum+",订单过期时间："+orderExpressTime;
    }

    @GetMapping("/getServerStatus")
    public String getServerStatus(){
        return namingService.getServerStatus();
    }

    @GetMapping("/getAllInstances")
    public List<Instance> getAllInstances(String service) throws NacosException {
        return namingService.getAllInstances(service);
    }
}
