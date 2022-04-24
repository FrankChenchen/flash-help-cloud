package com.hqu.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "wechat")
@Component
public class WechatKeys {
    String appId;
    String appSecret;
    String notifyUrl;
    String apiKey;
    String apiKey3;
    String mchId;
    String keyPath;
    String certPath;
    String certP12Path;
    String platformCertPath;
}
