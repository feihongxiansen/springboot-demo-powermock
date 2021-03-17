package com.example.mock.service;

import com.example.mock.entity.Article;

import java.util.List;

/**
 * @author zhufeihong
 * @since 2021/3/16 23:02
 */
public interface ArticleService {

    void add(Article saveParam);

    void update(Article updateParam);

    Article findById(Integer id);

    List<Article> findList(Article queryParam);

    Long getLikesById(Integer id);

    Integer getLimit();
}
