package com.example.mock.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mock.entity.Article;
import com.example.mock.service.ArticleService;
import com.example.mock.service.impl.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhufeihong
 * @since 2021/3/17 00:28
 */
@Slf4j
@RunWith(PowerMockRunner.class) // 告诉JUnit使用PowerMockRunner进行测试
@PrepareForTest({ArticleController.class}) // 所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
//@PowerMockIgnore({"javax.*.*", "com.sun.*", "org.xml.*", "org.apache.*"}) //为了解决使用powermock后，提示classloader错误
public class ArticleControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private ArticleController articleController;

    @Before
    public void setup() {
        //初始化
        MockitoAnnotations.openMocks(this);
        //构建mvc环境
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
    }

    @Test
    public void testAddSuccess() throws Exception {
        Article article = Article.builder()
                .title("万峰林景区推荐")
                .content("文章内容主题")
                .author("小明")
                .releaseDate(new Date())
                .build();
        PowerMockito.doNothing().when(articleService).add(article);

        JSONObject expect = new JSONObject();
        expect.put("data", true);
        expect.put("code", 200);
        expect.put("msg", "成功");
        expect.put("success", true);

        //模拟接口调用
        mockMvc.perform(MockMvcRequestBuilders.post("/article/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(article)))
                .andExpect(status().isOk())
                //对接口响应进行验证
                .andExpect(content().json(expect.toJSONString()));
    }

    @Test
    public void testAddTitleEmpty() throws Exception {
        Article article = Article.builder()
                .content("文章内容主题")
                .author("小明")
                .releaseDate(new Date())
                .build();
        PowerMockito.doNothing().when(articleService).add(article);

        JSONObject expect = new JSONObject();
        expect.put("data", null);
        expect.put("code", 500);
        expect.put("msg", "文章标题不能为空");
        expect.put("success", false);

        //模拟接口调用
        mockMvc.perform(MockMvcRequestBuilders.post("/article/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(article)))
                .andExpect(status().isOk())
                //对接口响应进行验证
                .andExpect(content().json(expect.toJSONString()));
    }

    @Test
    public void testUpdateByIdSuccess() throws Exception {
        Article article = Article.builder()
                .id(1L)
                .content("文章内容主题")
                .author("小明")
                .releaseDate(new Date())
                .build();
        PowerMockito.doNothing().when(articleService).update(article);

        JSONObject expect = new JSONObject();
        expect.put("data", true);
        expect.put("code", 200);
        expect.put("msg", "成功");
        expect.put("success", true);

        //模拟接口调用
        mockMvc.perform(MockMvcRequestBuilders.post("/article/updateById")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(article)))
                .andExpect(status().isOk())
                //对接口响应进行验证
                .andExpect(content().json(expect.toJSONString()));
    }

}
