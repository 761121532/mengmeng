package com.example.web.DAO;

import com.example.web.Entity.ArticleEntity;
import com.example.web.Entity.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface ArticleMapper {
    //查询指定文章的方法
    ArticleEntity find(ArticleEntity articleEntity);

    //查询所有文章比重的方法
    ArticleEntity[] findProportion();

    //添加文章的方法
    boolean addArticle(ArticleEntity articleEntity);

    //删除文章的方法
    boolean deleteArticle(ArticleEntity articleEntity);

    //查询图片位置 以及文章titly 还有文章id 每次查询8条
    ArticleEntity[] image(Pagination Pagination);
}
