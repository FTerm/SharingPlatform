package com.ckhun.utils;

import com.github.pagehelper.PageInfo;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:56 2021/1/29
 * @description :
 * @since : 1.0.0
 */
public class pageUtil {
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setResults(pageInfo.getList());
        return pageResult;
    }
}
