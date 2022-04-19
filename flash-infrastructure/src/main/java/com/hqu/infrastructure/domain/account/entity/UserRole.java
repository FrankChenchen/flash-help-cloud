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
 * 用户关联角色表
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    @TableLogic
    private Boolean deleted;


}
