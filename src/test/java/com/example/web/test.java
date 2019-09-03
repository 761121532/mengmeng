package com.example.web;

import com.example.web.DAO.MarkdownMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Autowired
    MarkdownMapper MarkdownMapper;
    @Test
    public void contextLoads() {
        System.out.println(MarkdownMapper.find()[1]);
    }
}