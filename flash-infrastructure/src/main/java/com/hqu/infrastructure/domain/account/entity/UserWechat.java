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
 * 
 * </p>
 *
 * @author 起凡
 * @since 2022-04-24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user_wechat")
public class UserWechat implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 微信openId
     */
    private String openId;

    /**
     * 关联sys_user的id
     */
    private Long userId;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    @TableLogic
    private Boolean deleted;


}
