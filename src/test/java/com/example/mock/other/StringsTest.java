package com.example.mock.other;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author zhufeihong
 * @since 2021/3/17 01:50
 */
@Slf4j
@RunWith(PowerMockRunner.class)
@PrepareForTest({Strings.class, StringUtils.class})
public class StringsTest {

    @Test
    public void testIsEmpty() {
        String string = "abc";
        boolean expected = true;
        PowerMockito.mockStatic(Strings.class);
        PowerMockito.when(Strings.isEmpty(string)).thenReturn(expected);
        boolean actual = Strings.isEmpty(string);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testIsNotEmpty() {
        String string = "abc";
        PowerMockito.spy(Strings.class);
        PowerMockito.when(Strings.isNotEmpty(string)).thenReturn(false);
        Assert.assertFalse("返回值不相等", Strings.isNotEmpty(string));
        Assert.assertFalse("返回值不相等", Strings.isEmpty(string));
    }

    @Test
    public void testUnfinishedStubbingException() {
        PowerMockito.mockStatic(Strings.class);
        PowerMockito.doReturn(100).when(Strings.isEmpty("333"));
    }

    @Test
    public void testStartWith() {
        String string = "abc";
        String prefix = "b";
        boolean expected = true;
        PowerMockito.spy(StringUtils.class);
        PowerMockito.when(StringUtils.startsWith(Mockito.anyString(), Mockito.eq(prefix))).thenReturn(expected);
        boolean actual = StringUtils.startsWith(string, prefix);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testVerifyStatic() {
        PowerMockito.mockStatic(StringUtils.class);
        String expected = "abc";
        StringUtils.isEmpty(expected);
        PowerMockito.verifyStatic(StringUtils.class);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        StringUtils.isEmpty(argumentCaptor.capture());
        Assert.assertEquals("参数不相等", argumentCaptor.getValue(), expected);
    }

}
