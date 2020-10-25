package com.lic.service.impl;

import com.lic.entity.Group;
import com.lic.dao.GroupDao;
import com.lic.service.GroupService;
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
public class GroupServiceImpl extends ServiceImpl<GroupDao, Group> implements GroupService {

}
