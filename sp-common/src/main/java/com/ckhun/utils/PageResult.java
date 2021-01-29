package com.ckhun.utils;

import lombok.*;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:55 2021/1/29
 * @description :
 * @since : 1.0.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResult {

    private int pageNum;
    private int pageSize;
    private long totalSize;
    private int totalPages;

    private String errMsg = ErrorEnum.SUCCESS.getErrMsg();
    private Long ts = System.currentTimeMillis();
    private int errCode = ErrorEnum.SUCCESS.getErrCode();
    private boolean success = true;

    private List<?> results;
}
