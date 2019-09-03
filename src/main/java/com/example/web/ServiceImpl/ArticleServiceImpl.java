package com.example.web.ServiceImpl;

import com.example.web.Entity.ArticleEntity;
import com.example.web.Entity.LoginMsg;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

public interface ArticleServiceImpl {

    //查询文章的方法  必须要参数id值
    ArticleEntity findArticle(ArticleEntity articleEntity);

    //查询文章比重的方法，不需要传参
    ArticleEntity[] findProportion(int number);

    //上传图片的方法
    LoginMsg picture(MultipartFile file, RedirectAttributes redirectAttributes, Model model, HttpSession session,ArticleEntity articleEntity);

    //删除文章
    boolean deleteArticle(ArticleEntity articleEntity);

    //返回文章总数
    int getArticleMsg();

    //echarts用的统计信息
    Object[] Echarts();
}
