package com.example.web.Bean;

import com.example.web.Method.articleHelpMethod;
import org.springframework.context.annotation.Configuration;

/**
 * 将帮助方法类注册成为一个bean节点
 */
@Configuration
public class Bean {
    @org.springframework.context.annotation.Bean
    articleHelpMethod getarticleHelpMethod(){
       return new articleHelpMethod();
    }
}
