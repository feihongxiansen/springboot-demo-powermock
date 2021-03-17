package com.example.mock.service;

import com.example.mock.mapper.ArticleMapper;
import com.example.mock.service.impl.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * @author zhufeihong
 * @since 2021/3/17 01:28
 */
@Slf4j
@RunWith(PowerMockRunner.class)
public class ArticleServiceTest {

    @Mock
    private ArticleMapper articleMapper;

    @InjectMocks
    private ArticleServiceImpl articleService;

    @Before
    public void setup() {
        //初始化
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetLikesByIdSuccess() {
        Integer id = 1;
        Long expect = 50L;
        PowerMockito.when(articleMapper.getLikesById(id)).thenReturn(expect);
        Long actual = articleService.getLikesById(id);
        Assert.assertEquals("返回值不相等", expect, actual);
    }

    @Test(expected = RuntimeException.class)
    public void testGetLikesByIdError() {
        Integer id = null;
        Long expect = 50L;
        PowerMockito.when(articleMapper.getLikesById(id)).thenReturn(expect);
        Long actual = articleService.getLikesById(id);
        Assert.assertEquals("返回值不相等", expect, actual);
    }

    @Test
    public void testGetLikesById() {
        Long expectLikes = 1000L;

        Integer id = 2;
        ArticleService articleService = PowerMockito.mock(ArticleService.class);
        PowerMockito.when(articleService.getLikesById(id)).thenReturn(expectLikes);

        Long actualLikes = articleService.getLikesById(id);
        log.info("actualLikes is {}", actualLikes);
        Assert.assertEquals("返回值不相等", expectLikes, actualLikes);
    }

    @Test
    public void testGetLikesByIdWhenReturn() {
        Long expectLikes = 1000L;

        Integer id = 2;
        ArticleService articleService = PowerMockito.spy(new ArticleServiceImpl());
        PowerMockito.when(articleService.getLikesById(id)).thenReturn(expectLikes);

        Long actualLikes = articleService.getLikesById(id);
        log.info("actualLikes is {}", actualLikes);
        Assert.assertEquals("返回值不相等", expectLikes, actualLikes);
    }

    @Test
    public void testGetLikesByIdDoReturnWhen() {
        Long expectLikes = 1000L;

        Integer id = 2;
        ArticleService articleService = PowerMockito.spy(new ArticleServiceImpl());
        PowerMockito.doReturn(expectLikes).when(articleService).getLikesById(id);

        Long actualLikes = articleService.getLikesById(id);
        log.info("actualLikes is {}", actualLikes);
        Assert.assertEquals("返回值不相等", expectLikes, actualLikes);
    }


    @Test
    public void testGetUserLimit() {
        Integer expected = 10;
        Whitebox.setInternalState(articleService, "LIMIT", expected);
        Integer actual = articleService.getLimit();
        Assert.assertEquals("返回值不相等", expected, actual);
    }
}
