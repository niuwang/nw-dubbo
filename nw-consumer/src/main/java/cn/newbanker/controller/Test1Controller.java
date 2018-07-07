package cn.newbanker.controller;


import cn.newbanker.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * restful-controller
 */
@RestController
public class Test1Controller {

    @Autowired
    private IConsumerService consumerService;

    @GetMapping(value = "/test/{name}")
    public String test(@PathVariable String name){
        return consumerService.sayHello(name);
    }
}
