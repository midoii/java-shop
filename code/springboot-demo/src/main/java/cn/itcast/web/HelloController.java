package cn.itcast.web;


import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("user")
public class HelloController {


//    @Autowired
//    private DataSource dataSource;
    @Autowired
    private UserService userService;


    @GetMapping("{id}")
    @ResponseBody
    public User hello(@PathVariable("id") Long id){
        return userService.queryById(id);
    }
}
