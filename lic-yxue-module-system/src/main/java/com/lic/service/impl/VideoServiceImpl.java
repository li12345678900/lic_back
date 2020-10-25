package com.lic.service.impl;

import com.lic.entity.Video;
import com.lic.dao.VideoDao;
import com.lic.service.VideoService;
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
public class VideoServiceImpl extends ServiceImpl<VideoDao, Video> implements VideoService {

}
