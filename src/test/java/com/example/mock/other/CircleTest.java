package com.example.mock.other;

import com.example.mock.util.math.Circle;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author zhufeihong
 * @since 2021/3/17 01:44
 */
@Slf4j
@RunWith(PowerMockRunner.class)
@PrepareForTest({Circle.class})
public class CircleTest {

    @Test
    public void testGetArea() {
        double expectArea = 3.14D;
        Circle circle = PowerMockito.mock(Circle.class);
        PowerMockito.when(circle.getArea(1)).thenReturn(expectArea);
        double actualArea = circle.getArea(1);
        log.info("actualArea is {}", actualArea);
        Assert.assertEquals("返回值不相等", expectArea, actualArea, 1E-6D);
    }
}
