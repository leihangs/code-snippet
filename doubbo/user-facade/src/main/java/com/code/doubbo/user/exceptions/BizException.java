package com.code.doubbo.user.exceptions;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常
 * 定义规则：
 * 子系统名称（xx）+模块（xx）+4位唯一的异常编码（xxxx）
 * 子系统定义：
 * 10：用户模块
 * 11：
 * 12：
 * <p>
 * 90:
 */

public class BizException extends RuntimeException {

    private static final long serialVersionUID = -5875371379845226068L;

    /**
     * 数据库操作,insert返回0
     */
    public static final BizException DB_INSERT_RESULT_0 = new BizException(90040001, "数据库操作,insert返回0");

    /**
     * 数据库操作,update返回0
     */
    public static final BizException DB_UPDATE_RESULT_0 = new BizException(90040002, "数据库操作,update返回0");

    /**
     * 数据库操作,selectOne返回null
     */
    public static final BizException DB_SELECTONE_IS_NULL = new BizException(90040003, "数据库操作,selectOne返回null");

    /**
     * 数据库操作,list返回null
     */
    public static final BizException DB_LIST_IS_NULL = new BizException(90040004, "数据库操作,list返回null");

    /**
     * 获取序列出错
     */
    public static final BizException DB_GET_SEQ_NEXT_VALUE_ERROR = new BizException(90040007, "获取序列出错");

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    public BizException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public BizException() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message) {
        super(message);
    }
}
