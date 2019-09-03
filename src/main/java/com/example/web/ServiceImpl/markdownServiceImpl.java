package com.example.web.ServiceImpl;

import com.example.web.Entity.markdownEntity;

public interface markdownServiceImpl {
    /**
     *  查询出所有的 markdown文件
     * @return markdownEntity的数组 包含所有的markdown文件
     */
    markdownEntity[] find();
}
