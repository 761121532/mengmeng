package com.example.web;

import com.example.web.DAO.ArticleMapper;
import com.example.web.Entity.ArticleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {
    @Autowired
    ArticleMapper articleMapper;
    @Test
    public void contextLoads() {
        ArticleEntity articleEntity=new ArticleEntity();
        articleEntity.setAuthor("老夫");
        articleEntity.setPicture("拍外景图.png");
        articleEntity.setText("在下萝莉控");
        articleEntity.setTitly("就是试试");
        articleEntity.setBriefIntroduction("debug");
        articleEntity.setGroupID(1);
        System.out.println(articleMapper.addArticle(articleEntity));
    }
}