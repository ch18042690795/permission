package com.mmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-05 15:18
 **/
@Controller
@RequestMapping("/admin")
public class adminController {
   @RequestMapping("/index.page")
    public ModelAndView index(){
       return new ModelAndView("admin");
   }
}
