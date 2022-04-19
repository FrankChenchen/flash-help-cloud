package com.hqu.infrastructure.domain.account.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String gender;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 昵称
     */
    private String nickname;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    @TableLogic
    private Boolean deleted;


}
