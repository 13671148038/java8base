package com.balimiao.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户访问
 */
@Data
public class UserVisitMsg {

    private Long userId;
    //上一次活跃时间
    private LocalDateTime lastTime;
    //来源，1 ios,2 android
    private Integer source = 0;
    //访问路径
    private String path;
    //设备id
    private String deviceCode;
    //版本号
    private String version;
    //ip
    private String ip;
    //qudao
    private String channel;
    //更新时间
    private LocalDateTime createTime;

    public UserVisitMsg() {
    }
}
