package com.example.mock.mapper;

import com.example.mock.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhufeihong
 * @since 2021/3/16 23:10
 */
@Mapper
@Repository
public interface ArticleMapper {

    int insert(Article saveParam);

    int update(Article updateParam);

    Article findById(Integer id);

    List<Article> findList(Article queryParam);

    Long getLikesById(Integer id);
}
