package com.lic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author lic
 * @since 2020-09-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yx_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField
    private String username;
    @TableField
    private String mobile;
    @TableField
    private String sign;

    private String headShow;

    private String status;

//    @JsonFormat(pattern ="yyyy-MM-dd")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date regTime;
    @TableField
    private Double score;
    @TableField
    private String wechat;


}
