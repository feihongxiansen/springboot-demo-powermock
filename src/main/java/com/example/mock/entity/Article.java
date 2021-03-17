package com.example.mock.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文章实体
 * @author zhufeihong
 * @since 2021/3/16 23:03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private Long id;

    private String title;

    private String author;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDate;

    private Long likes;
}
