package com.example.web.ServiceImpl;

import com.example.web.Entity.Pagination;
import com.example.web.Entity.ResponseResult;

public interface imageServiceImpl {
    //相册功能
    ResponseResult getimage(Pagination pagination);
}
