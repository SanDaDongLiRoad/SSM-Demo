package com.xulizhi.demo.utils;

import java.util.UUID;

/**
 * @author lenovo
 */
public class UUIDUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
