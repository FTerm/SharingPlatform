package com.ckhun.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:54 2021/1/29
 * @description :
 * @since : 1.0.0
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    private int pageNum;
    private int pageSize;
}
