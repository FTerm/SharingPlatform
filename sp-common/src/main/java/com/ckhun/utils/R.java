package com.ckhun.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:40 2021/1/29
 * @description : Restful API structure
 * @since : 1.0.0
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String errMsg = ErrorEnum.SUCCESS.getErrMsg();
    private Long ts = System.currentTimeMillis();
    private int errCode = ErrorEnum.SUCCESS.getErrCode();
    private boolean success = true;
    private T data;

    // ============================= //
    // 独立数据                       //
    // private int page;
    // private int totals;
    // private String token;
    // private int per_page;
    // ============================= //


    public R(String errMsg) {
        this.errMsg = errMsg;
    }

    public R(String errMsg, T data) {
        super();
        this.errMsg = errMsg;
        this.data = data;
    }

    public R(Throwable e) {
        super();
        this.errMsg = e.getMessage();
        try {
            this.errCode = ErrorEnum.valueOf(ErrorEnum.getNameForValue(e.getMessage())).getErrCode();
        } catch (IllegalArgumentException illegalArgumentException) {
            this.errCode = ErrorEnum.FAIL.getErrCode();
        }
        this.success = false;
    }

    public R<?> fail(ErrorEnum resultEnum, T data) {
        R<T> results = new R<>();
        results.setErrCode(resultEnum.getErrCode());
        results.setErrMsg(resultEnum.getErrMsg());
        results.setSuccess(false);
        results.setData(data);
        results.setTs(this.ts);
        return results;
    }
}
