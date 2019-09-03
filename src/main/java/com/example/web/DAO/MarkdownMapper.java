package com.example.web.DAO;

import com.example.web.Entity.markdownEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MarkdownMapper {
    markdownEntity[]  find();
}
