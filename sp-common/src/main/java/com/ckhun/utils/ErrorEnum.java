package com.ckhun.utils;

import lombok.Getter;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:43 2021/1/29
 * @description :
 * @since : 1.0.0
 */

@Getter
public enum ErrorEnum {
    // ======================== //
    // 接口错误码定义              //
    FAIL(0, "请求失败"),
    SUCCESS(1, "数据获取成功"),
    VALIDATION_EOR(-101, "参数验证错误"),
    UPDATE_EOR_BY_ID(404001, "修改失败, 无效id"),

    // 密码修改错误定义
    UPDATE_EOR_NOT_MATCH_PWD(404002, "修改失败, 密码必须是8 - 20 位"),
    EOR_PATTERN_NOT_MATCH_PWD(404003, "密码必须包含大写字母、小写字母、数字和特殊符号"),

    // 用户登录相关错误定义
    EOR_LOGIN_PWD(404000, "密码错误"),
    EOR_USER_NOT_FOUND(404000, "用户不存在"),
    EOR_LOGIN_USER_NOT_ACTIVE(404000, "账号未激活"),
    EOR_LOGIN_USER_BAN(404000, "账号被禁用，请联系管理人员处理"),
    LOGIN_SUCCESS(SUCCESS.getErrCode(), "登陆成功"),


    EOR_MAIL_REPEAT(404001, "邮箱已存在"),
    EOR_USERNAME_REPEAT(404001, "用户名已存在"),


    // ======================== //


    // ======================== //
    // 自定义异常使用              //
    EX_NOT_FOUND(1404401, "用户没找到"),
    EX_NOT_MATCH_PWD(1404402, "旧密码不匹配"),
    EX_NOT_DIFF_PASSWORD(1404403, "新密码和旧密码一致"),
    // ======================== //


    // ======================== //
    // 固定标准错误码              //
    CREATE_EOR(244401, "创建失败"),
    UPDATE_EOR(244402, "修改失败"),
    DELETE_EOR(244403, "删除失败"),
    NO_UPDATE(244404, "没有任何修改"),
    CREATE_SUCCESS(SUCCESS.getErrCode(), "创建成功"),
    UPDATE_SUCCESS(SUCCESS.getErrCode(), "修改成功"),
    DELETE_SUCCESS(SUCCESS.getErrCode(), "删除成功"),
    // ======================== //

    // ======================== //
    // 服务器相关的错误码定义       //
    HTTP_SUCCESS(200, "请求成功"),
    HTTP_CREATED(201, "资源创建成功"),
    HTTP_NOT_AUTH(401, "可以先登陆一下嘛"),
    HTTP_NOT_FOUND(404, "没有相关的资源哦"),
    HTTP_NO_PERMISSION(403, "没有权限访问"),
    HTTP_SERVER_EOR(500, "服务器走了啊"),
        // ======================== //
    ;


    private final Integer errCode;
    private final String errMsg;

    ErrorEnum(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public static String getNameForValue(String  v) {
        ErrorEnum[] values = ErrorEnum.values();
        ErrorEnum enumValue = null;
        for (ErrorEnum value : values) {
            enumValue = value;

            if (enumValue.getErrMsg().equals(v)) {
                return value.name();
            }
        }
        return String.valueOf(enumValue);
    }
}
