package com.example.web.Controller;

import com.example.web.Entity.ArticleEntity;
import com.example.web.Entity.LoginMsg;
import com.example.web.ServiceImpl.ArticleServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


//所有方法的控制器，可以控制路径和传值
@RestController    //该注解下的所有方法返回值都将被解释为json对象 并标注本类为一个控制器
public class ArticleController {
    private final
    ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }


    /**
     * 返回文章前七个
     * @return 文章的对象数组，是点击量前七
     */
    @RequestMapping(value="articles",method = RequestMethod.GET)
    public ArticleEntity[] findArticle(@RequestParam(value = "page",defaultValue = "0",required = false) int number){ return articleService.findProportion(number); }

    /**
     * 返回文章数量的方法
     * @return  从redis中获得文章数量
     */
    @RequestMapping(value="articleMsg",method = RequestMethod.GET)
    public int greArticleMsg(){ return articleService.getArticleMsg(); }

    /**
     * 用来查询单个文章的方法
     * @param articleEntity 传入文章的id
     * @return 返回文章的所有信息
     */
    @RequestMapping(value = "article",method = RequestMethod.GET)
    public ArticleEntity findIdArticle(ArticleEntity articleEntity){ return articleService.findArticle(articleEntity); }

//    @RequestMapping(value = "addArticle",method = RequestMethod.POST)
//    public LoginMsg AddArticle(ArticleEntity articleEntity){ return userService.AddArticle(articleEntity); }

    //处理文章上传的方法，如果有图片的话
    /**
     * 上传图片
     *
     * @return 上传成功与否信息
     */
    // 文件上传按钮action
    @PostMapping("/uploadPic")
    public LoginMsg handleFileUpload(@RequestParam(value = "file",required=false) MultipartFile file,
                                     RedirectAttributes redirectAttributes,
                                     Model model,
                                     HttpSession session,
                                     @RequestParam(value ="text",required=false) String text,
                                     @RequestParam(value ="titly",required=false) String titly,
                                     @RequestParam(value ="briefIntroduction",required=false) String briefIntroduction,
                                     @RequestParam(value ="cateName",required=false) String groupID)  {
        ArticleEntity articleEntity=new ArticleEntity();
        if (groupID!=null) articleEntity.setGroupID(Integer.parseInt(groupID));
        articleEntity.setBriefIntroduction(briefIntroduction);
        articleEntity.setTitly(titly);
        articleEntity.setText(text);
        return articleService.picture(file,redirectAttributes,model,session,articleEntity);
    }

    /**
     * 删除文章的方法
     * @param articleEntity  传入一个文章的id  删除掉对应文章
     * @return 删除成功与否   true  为成功  false 为失败
     */
    @RequestMapping(value="delete/articles",method = RequestMethod.GET)
    public Boolean deleteArticle(ArticleEntity articleEntity){ return articleService.deleteArticle(articleEntity); }


    @RequestMapping(value = "echarts" , method = RequestMethod.GET)
    public Object[] Echarts(){
        return articleService.Echarts(); }

}
