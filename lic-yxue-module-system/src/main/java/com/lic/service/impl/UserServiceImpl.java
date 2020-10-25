package com.lic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lic.entity.User;
import com.lic.dao.UserDao;
import com.lic.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lic
 * @since 2020-09-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired(required = false)
    private UserDao userDao;



//    @Override
//    public List<User> queryall(Integer page, Integer rows) {
//        IPage<User> page1 = new Page<>(page,rows);
//        // 无条件查询的分页
//        IPage<User> pages = userDao.selectPage(page1, null);
//        return pages.getRecords();
//    }
}
