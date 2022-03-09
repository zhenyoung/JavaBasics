package pers.yangzhen.exceptionandlog;

// 自定义异常类
public class CustomizedException extends Exception {
    static final long serialVersionUID = -7034897190745766939L;

    public CustomizedException() {
    }

    public CustomizedException(String message) {
        super(message);
    }
}
