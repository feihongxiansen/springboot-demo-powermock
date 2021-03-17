package com.example.mock.util.file;

import java.io.File;

/**
 * @author zhufeihong
 * @since 2021/3/17 09:54
 */
public final class FileUtils {

    public static boolean isFile(String fileName) {
        return new File(fileName).isFile();
    }

}
