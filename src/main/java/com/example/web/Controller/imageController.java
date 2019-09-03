package com.example.web.Controller;

import com.example.web.Entity.Pagination;
import com.example.web.Entity.ResponseResult;
import com.example.web.ServiceImpl.imageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class imageController {
    @Autowired
    imageServiceImpl imageService;

    /**
     *  返回图片信息的方法
     * @param pagination 传入页码数量
     * @return 返回指定页码图片  titly 和id
     */
    @RequestMapping(value = "getimage")
    public ResponseResult getImage(Pagination pagination){
        return imageService.getimage(pagination);
    }
}
