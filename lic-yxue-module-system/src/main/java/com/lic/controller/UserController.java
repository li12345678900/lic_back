package com.lic.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lic.common.Result;
import com.lic.entity.User;
import com.lic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lic
 * @since 2020-09-22
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;


    @ResponseBody
    @RequestMapping("edit")
    public Result<?> deleteUser(User user,String oper) {
        if("del".equals(oper)){
            String str[] = user.getId().split(",");
            for (int i = 0; i < str.length; i++) {
                 userService.removeById(str[i]);
            }
        }else if("add".equals(oper)){
            System.out.println(user);
            user.setId(null);
            userService.save(user);
            System.out.println(user);
        }else if(oper.equals("edit")){
//            System.out.println(user);
//            user.setRegTime(new Date());
            System.out.println(user);
            System.out.println("我进来了");
            userService.updateById(user);
        }
//        System.out.println(user);
        return Result.ok(user);
    }

    @RequestMapping("show")
    @ResponseBody
    public Result<?> showUser(Long page,Long rows,User user) {
        IPage iPage = new Page(page, rows);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
      IPage<User> page1 = userService.page(iPage, queryWrapper);

        return Result.ok(page1.getRecords(),page1.getCurrent(),page1.getPages(),page1.getTotal());
    }

    @RequestMapping("headUpload")
    @ResponseBody
    public void headUpload(MultipartFile headShow,String id) throws IOException {
        String filename = headShow.getOriginalFilename();
        String name = UUID.randomUUID()+filename;
        String path = request.getServletContext().getRealPath("/static/yxue/upload");
        System.out.println(path);
//        System.out.println(name);
        String realpath = path+"/"+filename;
        headShow.transferTo(new File(path,name));
        System.out.println(realpath);

        User user = new User();
        user.setId(id);
        user.setHeadShow(name);
        userService.updateById(user);

        System.out.println("我进来了呢");
        System.out.println(request.getServletContext()+"/static/yxue/upload/"+filename);
        System.out.println(id);

    }

    @RequestMapping("change")
    public List<String> change(){
        List<String > list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        System.out.println("经来过");
        return list;
    }

}

