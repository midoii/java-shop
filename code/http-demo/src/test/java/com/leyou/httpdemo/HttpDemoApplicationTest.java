package com.leyou.httpdemo;

import com.leyou.httpdemo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpDemoApplicationTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void httpGet(){
        User user = this.restTemplate.getForObject("http://localhost:8888/user/17",User.class);
        System.out.println(user);
    }
}