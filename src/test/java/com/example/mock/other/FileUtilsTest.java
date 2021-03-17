package com.example.mock.other;

import com.example.mock.util.file.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

/**
 * @author zhufeihong
 * @since 2021/3/17 09:54
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FileUtils.class})
public class FileUtilsTest {

    @Test
    public void testIsFile() throws Exception {
        String fileName = "test.txt";
        File file = PowerMockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments(fileName).thenReturn(file);
        PowerMockito.when(file.isFile()).thenReturn(true);
        Assert.assertTrue("返回值为假", FileUtils.isFile(fileName));
    }
}
