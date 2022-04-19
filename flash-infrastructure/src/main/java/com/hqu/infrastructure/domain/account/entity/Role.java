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
 * 角色表
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    @TableLogic
    private Boolean deleted;


}
