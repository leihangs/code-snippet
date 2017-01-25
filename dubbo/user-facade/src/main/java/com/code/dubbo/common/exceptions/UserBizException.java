package com.code.dubbo.common.exceptions;

/**
 * 用户接口异常类
 */
public class UserBizException extends BizException {

    private static final long serialVersionUID = -3175990411418914329L;

    /***
     * 登录：用户名不存在
     */
    public static final int LOGIN_LOGNAME_NOT_EXIST = 20020001;
    /***
     * 登录：密码错误
     */
    public static final int LOGIN_PWD_ERROR = 20020002;

    /***
     * 登录：密码错误次数超限
     */
    public static final int LOGIN_PWDERRORTIMES_OVERRUN = 20020003;

    /***
     * 登录：操作员状态为冻结
     */
    public static final int LOGIN_OPERATORSTATUS_INACTIVE = 20020004;

    /***
     * 登录：操作员被销户
     */
    public static final int LOGIN_OPERATORSTATUS_CANCELLATION = 20020005;

    public UserBizException() {
    }

    public UserBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }

    public UserBizException(int code, String msg) {
        super(code, msg);
    }
}
