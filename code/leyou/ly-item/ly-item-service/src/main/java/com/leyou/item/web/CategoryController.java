package com.leyou.item.web;


import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public List<Category> queryCategoryListByPid(@RequestParam("pid")Long pid){
        return (categoryService.queryCategoryListByPid(pid));
    }
}
