package com.example.mock.controller;

import com.example.mock.entity.Article;
import com.example.mock.service.ArticleService;
import com.example.mock.util.result.Results;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author zhufeihong
 * @since 2021/3/16 23:30
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("add")
    public Results<Boolean> add(@RequestBody Article param) {
        if (Strings.isBlank(param.getTitle())) {
            return Results.failed("文章标题不能为空");
        }
        articleService.add(param);
        return Results.successWith(Boolean.TRUE);
    }

    @RequestMapping("updateById")
    public Results<Boolean> updateById(@RequestBody Article param) {
        if (Objects.isNull(param.getId())) {
            return Results.failed("ID不能为空");
        }
        articleService.update(param);
        return Results.successWith(Boolean.TRUE);
    }

    @RequestMapping("findById")
    public Results<Article> findById(@RequestParam Integer id) {
        if (Objects.isNull(id)) {
            return Results.failed("ID不能为空");
        }
        return Results.successWith(articleService.findById(id));
    }

    @RequestMapping("findList")
    public Results<List<Article>> findList(@RequestBody Article param) {
        return Results.successWith(articleService.findList(param));
    }
}
