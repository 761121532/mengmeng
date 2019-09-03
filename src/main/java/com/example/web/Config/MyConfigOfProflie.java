package com.example.web.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application")
public class MyConfigOfProflie {

    /**
     * 版本
     */
    private String version;
    /**
     * 上传文件路径
     */
    private static String profile;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        MyConfigOfProflie.profile = profile;
    }

}