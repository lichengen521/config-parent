package com.itheima.consumer.controller;


import com.itheima.consumer.domain.Goods;
import com.itheima.consumer.feign.GoodsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@RefreshScope//自动刷新配置中心文件信息
public class OrderController {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private String age;

    @Value("${person.birteday}")
    private String birthday;

    @Autowired
    private GoodsFeignClient goodsFeignClient;

    @GetMapping("/goods/{id}")
    public Goods findGoodsById(@PathVariable("id") int id){
        Goods goods = goodsFeignClient.findGoodsById(id);

//        goods.setTitle(goods.getTitle() + name + age + birthday);

        System.out.println(name);
        System.out.println(age);
        System.out.println(birthday);

        return goods;
    }


}
