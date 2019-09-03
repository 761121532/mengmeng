package com.example.web.Service;

import com.example.web.Config.MyConfigOfProflie;
import com.example.web.DAO.ArticleMapper;
import com.example.web.Entity.ArticleEntity;
import com.example.web.Entity.Echart;
import com.example.web.Entity.LoginMsg;
import com.example.web.Method.articleHelpMethod;
import com.example.web.RedisUtil.redisUtil;
import com.example.web.ServiceImpl.ArticleServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


//实现了UserServiceImpl的方法的实现类，用来做正真的逻辑运算，各种逻辑代码都得存在这里面
@Service // 标注 这个类为一个service 注入到容器中
public class ArticleService implements ArticleServiceImpl {

    private final Logger logger = Logger.getLogger(this.getClass());
    //装配文章帮助方法的实现类
    private final
    articleHelpMethod articleHelpMethod;
    //装配redis的工具类
    private final
    redisUtil redisUtil;
    //自动装配 文章的类，由容器自动注入 自动销毁
    private final
    ArticleMapper articleMapper;

    public ArticleService(articleHelpMethod articleHelpMethod, redisUtil redisUtil, ArticleMapper articleMapper) {
        this.articleHelpMethod = articleHelpMethod;
        this.redisUtil = redisUtil;
        //配置文件上传及下载位置
        this.articleMapper = articleMapper;
    }

    //寻找指定文章
    @Override
    public ArticleEntity findArticle(ArticleEntity articleEntity) {
        return articleMapper.find(articleEntity);
    }


    //根据比重返回前七的文章
    @Override
    public ArticleEntity[] findProportion(int number) {
       int[] articleId= articleHelpMethod.aaa(number);                                   //从帮助方法取值
        ArticleEntity[] article ;
        if (articleId.length < 7) {
            article = new ArticleEntity[articleId.length];                        //比重最高的文章的所有值
            for (int i = 0; i < articleId.length; i++) {
                ArticleEntity articleEntity = new ArticleEntity();
                articleEntity.setId(articleId[i]);
                article[i] = articleMapper.find(articleEntity);
            }
            return article;
        } else {
            int len = articleId.length;
            int max = 7 + (number * 7);
            if (len < max) {
                article = new ArticleEntity[max - len];//比重最高的文章的所有值
            } else {
                article = new ArticleEntity[7];
            }
            for (int i = 0; i < article.length; i++) {
                ArticleEntity articleEntity = new ArticleEntity();
                if (articleId[i + (number * 6)]==0)continue;
                articleEntity.setId(articleId[i + (number * 6)]);
                article[i] = articleMapper.find(articleEntity);
            }
            return article;
        }
    }

    /**
     *      提交文章的方法
     * @param file  上传的图片
     * @param redirectAttributes redis 的上下文
     * @param model file模型
     * @param session      获取session
     * @param articleEntity 提交的文章的具体内容
     * @return  是否提交成功
     */
    @Override
    public LoginMsg picture(MultipartFile file, RedirectAttributes redirectAttributes, Model model, HttpSession session, ArticleEntity articleEntity) {
        LoginMsg loginMsg = new LoginMsg();
        if (file == null && articleEntity != null) {
            if (session.getAttribute("pictureName") != null) {
                String pictureName = session.getAttribute("pictureName").toString();
                articleEntity.setPicture(pictureName);
            }
            articleEntity.setProportion(1);
            articleEntity.setAuthor(session.getAttribute("name").toString());
            articleMapper.addArticle(articleEntity);
            loginMsg.setErrcode(1);
            loginMsg.setMsg("干得漂亮");
        } else {
            try {
                // 存储图片到本地
                assert file != null;
                storePic(file);
                String filename = StringUtils.cleanPath(file.getOriginalFilename());
                filename = articleHelpMethod.change(filename);
                redirectAttributes.addFlashAttribute("message", "成功上传" + filename + "!");

                session.setAttribute("pictureName", filename);
                model.addAttribute("picName", filename); // 将文件传输成功之后的名字传回界面，用于展示图片
                loginMsg.setErrcode(1);
                loginMsg.setMsg("干得漂亮");
            } catch (Exception e) {
                loginMsg.setErrcode(0);
                loginMsg.setMsg("有猫饼");
                e.printStackTrace();
            }
        }
        return loginMsg;
    }

    /**
     *  删除文章的方法 先将redis清空 然后查询数据库中所有的文章 在存入redis  非常消耗新能
     * @param articleEntity     删除指定文章的id
     * @return  放回一个是否删除的 boolean值 true 为成功
     */
    @Override
    public boolean deleteArticle(ArticleEntity articleEntity) {
        redisUtil.del("maps");
        boolean isok=articleMapper.deleteArticle(articleEntity);
        articleHelpMethod.aaa(0);
        return isok;
    }

    /**
     *  从redis中获取所有文章的数量
     * @return  文章的总数
     */
    @Override
    public int getArticleMsg() { return redisUtil.hmget("maps").size(); }

    @Override
    public Object[] Echarts() {
        ArticleEntity[] articleEntities= findProportion(0);
        Echart[] c=new Echart[7];
        for (int i=0;i<7;i++){
            int values=articleEntities[i].getProportion();
            String names=articleEntities[i].getTitly();
            Echart echart=new Echart();
            echart.setName(names);
            echart.setValue(values);
            c[i]=echart;
        }
        return c;
    }

    /**
     *   处理图片存储的方法
     */
    private void storePic(MultipartFile file) throws Exception {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        filename = articleHelpMethod.change(filename);
        try {
            InputStream inputStream = file.getInputStream();
            File file1 = new File(file.getOriginalFilename());
            FileUtils.write(file1, MyConfigOfProflie.getProfile() + filename, "utf-8");
            Files.copy(inputStream, Paths.get(MyConfigOfProflie.getProfile() + "/" + filename), // 这里指定了下载的位置
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new Exception("失败！" + filename, e);
        }
    }
}
