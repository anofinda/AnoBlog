package com.anofinda.anoblog.common.lang;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dongyudeng
 */
@Data
@AllArgsConstructor
public class Result {
    private String code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        return new Result("0", "success", data);
    }

    public static Result success(String message) {
        return new Result("0", message, null);
    }

    public static Result success(String message, Object data) {
        return new Result("0", message, data);
    }

    public static Result success(String code, String message, Object data) {
        return new Result(code, message, data);
    }

    public static Result fail(String message) {
        return new Result("-1", message, null);
    }

    public static Result fail(String message, Object data) {
        return new Result("-1", message, data);
    }

    public static Result fail(String code, String message, Object data) {
        return new Result(code, message, data);
    }
}
