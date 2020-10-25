package com.lic.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lic.common.Result;
import com.lic.entity.Admin;
import com.lic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lic
 * @since 2020-09-22
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private HttpSession session;


    @RequestMapping("logout")
    public String logout(){
        System.out.println("login");
        session.invalidate();
        return "login";
    }

    @RequestMapping("login")
    public String register(Admin admin){
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username",admin.getUsername());
//        wrapper.eq("password",admin.getPassword());


        Admin admin1 = adminService.getOne(wrapper);
        System.out.println(admin1);
        if(admin1!=null){
            if(!admin1.getPassword().equals(admin.getPassword())){
                //密码不正确
                return "login";
            }
            session.setAttribute("admin",admin);
            return "main";
        }else{
//            throw new RuntimeException("用户名不存在");
            return "login";
        }
    }

}

