package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//首先这是一个接口，Feign会通过动态代理，帮我们生成实现类。这点跟mybatis的mapper很像
@FeignClient(value = "user-service", fallback = UserClientFallback.class)    //只告诉了Feign负载名称，但实现了访问，说明里面内置负载均衡
public interface UserClient {

    @GetMapping("user/{id}")
    User queryById(@PathVariable("id")Long id);
}
