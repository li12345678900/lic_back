package com.lic.service.impl;

import com.lic.entity.Comment;
import com.lic.dao.CommentDao;
import com.lic.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

}
