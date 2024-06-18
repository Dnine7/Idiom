package org.dnine7.idiom.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Result<T> {
    // Getter和Setter
    private Integer code;
    private String message;
    private T data;

    // 成功时的构造器
    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功的静态方法
    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "Success", data);
    }

    public static <T> Result<T> ok() {
        return new Result<>(200, "Success", null);
    }

    // 失败的静态方法
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }

}
