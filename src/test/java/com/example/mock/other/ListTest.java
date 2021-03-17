package com.example.mock.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;
import org.powermock.api.mockito.PowerMockito;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhufeihong
 * @since 2021/3/17 01:19
 */
@Slf4j
public class ListTest {

    @Test
    public void testSize() {
        Integer expected = 100;
        List list = PowerMockito.mock(List.class);
        PowerMockito.when(list.size()).thenReturn(expected);
        Integer actual = list.size();
        log.info("actual is {}", actual);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testGet() {
        int index = 0;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(index)).thenReturn(expected);
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        int index = -1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(index)).thenThrow(new IndexOutOfBoundsException());
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testGetAnswer() {
        int index = 1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(index)).thenAnswer(invocation -> {
            Integer value = invocation.getArgument(0);
            return value * 100;
        });
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testGetCallRealMethod() {
        int index = 0;
        Integer expected = 100;
        List<Integer> oldList = new ArrayList<>();
        oldList.add(expected);
        List<Integer> spyList = PowerMockito.spy(oldList);
        PowerMockito.when(spyList.get(index)).thenCallRealMethod();
        Integer actual = spyList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testGetDoReturn() {
        int index = 0;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.doReturn(expected).when(mockList).get(index);
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsException() {
        int index = -1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.doThrow(new IndexOutOfBoundsException()).when(mockList).get(index);
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testGetDoAnswer() {
        int index = 0;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.doAnswer(param->{
            Integer idx = param.getArgument(0);
            return ++idx * 100;
        }).when(mockList).get(index);
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testGetDoNothing() {
        int index = 1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.doNothing().when(mockList).add(index, expected);
        mockList.add(index, expected);
    }

    @Test
    public void testGetDoCallRealMethod() {
        int index = 0;
        Integer expected = 100;
        List<Integer> oldList = new ArrayList<>();
        oldList.add(expected);
        oldList.add(expected);
        List<Integer> spyList = PowerMockito.spy(oldList);
        PowerMockito.doCallRealMethod().when(spyList).get(index);
        Integer actual = spyList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }


    @Test
    public void testGetAnyInt() {
        int index = 1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(Mockito.anyInt())).thenReturn(expected);
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testAdditionalMatchers() {
        int index = 1;
        Integer expected = 100;
        List<Integer> mockList = PowerMockito.mock(List.class);
        PowerMockito.when(mockList.get(AdditionalMatchers.geq(0))).thenReturn(expected);
        PowerMockito.when(mockList.get(AdditionalMatchers.lt(0))).thenThrow(new IndexOutOfBoundsException());
        Integer actual = mockList.get(index);
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testVerifyMethod() {
        List<Integer> mockList = PowerMockito.mock(List.class);
        mockList.add(3);
        Mockito.verify(mockList).add(3);
    }

    @Test
    public void testCallNum() {
        List<Integer> mockList = PowerMockito.mock(List.class);
        mockList.clear();
        Mockito.verify(mockList, Mockito.times(1)).clear();
    }

    @Test
    public void testAddOrder() {
        List<Integer> mockedList = PowerMockito.mock(List.class);
        PowerMockito.doReturn(true).when(mockedList).add(Mockito.anyInt());
        mockedList.add(1);
        mockedList.add(2);
        mockedList.add(3);
        InOrder inOrder = Mockito.inOrder(mockedList);
        inOrder.verify(mockedList).add(1);
        inOrder.verify(mockedList).add(2);
        inOrder.verify(mockedList).add(3);
    }

    @Test
    public void testVerifyNoMoreInteractions() {
        List<Integer> mockedList = PowerMockito.mock(List.class);
        mockedList.isEmpty();
//        mockedList.size();
        Mockito.verify(mockedList).isEmpty();
        Mockito.verifyNoMoreInteractions(mockedList); // 抛出异常
    }

}
