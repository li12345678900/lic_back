package com.lic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lic
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yx_like")
//点赞
@AllArgsConstructor
@NoArgsConstructor
public class Like implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.UUID)
    private String id;

    private String userId;

    private String sourceId;

    private Date createAt;


}
