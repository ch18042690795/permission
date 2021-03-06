package com.mmall.controller;

import com.mmall.common.JsonData;
import com.mmall.param.UserParam;
import com.mmall.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-05 11:25
 **/
@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;
    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveUser(UserParam param) {
        sysUserService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateUser(UserParam param) {
        sysUserService.update(param);
        return JsonData.success();
    }

}
