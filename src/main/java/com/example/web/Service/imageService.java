package com.example.web.Service;

import com.example.web.DAO.ArticleMapper;
import com.example.web.Entity.ArticleEntity;
import com.example.web.Entity.Pagination;
import com.example.web.Entity.ResponseResult;
import com.example.web.RedisUtil.redisUtil;
import com.example.web.ServiceImpl.imageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class imageService implements imageServiceImpl {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    redisUtil redisUtil;
    @Override
    public ResponseResult getimage(Pagination pagination) {
        ResponseResult<ArticleEntity[]> result=new ResponseResult<>();
        result.setData(articleMapper.image(pagination));
        result.setMassage("ok");
        result.setState( redisUtil.hmget("maps").size());
        return result;
    }
}
