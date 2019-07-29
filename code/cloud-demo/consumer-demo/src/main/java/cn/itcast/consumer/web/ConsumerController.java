package cn.itcast.consumer.web;

import cn.itcast.consumer.client.UserClient;
import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "queryByIdFallback")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private RibbonLoadBalancerClient client;


//    @HystrixCommand(commandProperties =
//            {
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")}) //失败熔断的开启
//    @HystrixCommand
//    @GetMapping("{id}")
//    public String queryById(@PathVariable("id")Long id) {
//        String url = "http://user-service/user/" + id;    //在restTemplate加入负载均衡后，对于eureka返回的列表根据策略链接
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
//    public String queryByIdFallback(){
//        return "对不起，服务器炸了";
//    }
//}
        //随机、轮询、hash
        //根据服务ID来获取实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //从实例当中取出IP和端口
//        ServiceInstance instance = instances.get(0);
//        ServiceInstance instance = client.choose("user-service");
//        String url = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/"+ id;

    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id")Long id) {
        return userClient.queryById(id);
    }
    public String queryByIdFallback(){
        return "对不起，服务器炸了";
    }
}