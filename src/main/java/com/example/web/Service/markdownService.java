package com.example.web.Service;

import com.example.web.DAO.MarkdownMapper;
import com.example.web.Entity.markdownEntity;
import com.example.web.ServiceImpl.markdownServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class markdownService implements markdownServiceImpl {
    @Autowired
    MarkdownMapper markdownMapper;
    @Override
    public markdownEntity[] find() {
        return markdownMapper.find();
    }
}
