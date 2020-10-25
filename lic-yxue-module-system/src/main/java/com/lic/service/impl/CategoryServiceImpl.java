package com.lic.service.impl;

import com.lic.entity.Category;
import com.lic.dao.CategoryDao;
import com.lic.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lic
 * @since 2020-09-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

}
