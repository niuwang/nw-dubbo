package cn.newbanker.service.impl;

import cn.newbanker.common.DemoService;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.newbanker.service.IConsumerService;
import org.springframework.stereotype.Service;

/**
 * @Author niuwang
 * 调用dubbo服务，整合服务供controller调用
 */
@Service
public class ConsumerServiceImpl implements IConsumerService {

//    @Autowired
//    private DemoService demoService;

    @Reference(check = false,registry = "aaa")
    private DemoService demoService;


    @Override
    public String sayHello(String name) {
        //调用dubbo
        String hello = demoService.sayHello(name);

        return hello;
    }

}
