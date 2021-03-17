package com.example.mock.service.impl;

import com.example.mock.entity.Article;
import com.example.mock.mapper.ArticleMapper;
import com.example.mock.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author zhufeihong
 * @since 2021/3/16 23:08
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private Integer LIMIT = 100;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article saveParam) {
        saveParam.setLikes(0L);
        articleMapper.insert(saveParam);
    }

    @Override
    public void update(Article updateParam) {
        articleMapper.update(updateParam);
    }

    @Override
    public Article findById(Integer id) {
        return articleMapper.findById(id);
    }

    @Override
    public List<Article> findList(Article queryParam) {
        return articleMapper.findList(queryParam);
    }

    @Override
    public Long getLikesById(Integer id) {
        if(Objects.isNull(id)) {
            throw new RuntimeException("ID不能为空");
        }
        log.info("调用方法获取点赞数");
//        return 1000L;
        return articleMapper.getLikesById(id);
    }

    @Override
    public Integer getLimit() {
        return this.LIMIT;
    }
}
