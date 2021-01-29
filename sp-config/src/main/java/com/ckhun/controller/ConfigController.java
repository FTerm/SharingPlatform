package com.ckhun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Kunhong Chan
 * @date : Created in 15:36 2021/1/29
 * @description :
 * @since : 1.0.0
 */

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${user:false}")
    private boolean useLocalCache;

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
}
