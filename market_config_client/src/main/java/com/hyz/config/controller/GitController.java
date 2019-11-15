package com.hyz.config.controller;

import com.hyz.config.domain.entity.GitConfig;
import com.hyz.config.domain.entity.GitConfigPro;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class GitController {

    @Resource
    private GitConfig gitConfig;

    @Resource
    private GitConfigPro gitConfigPro;

    @GetMapping(value = "show")
    public Object show() {
        return gitConfig;
    }

    @GetMapping(value = "autoShow")
    public Object autoShow() {
        return gitConfigPro;
    }

}
