package org.zgd.code.domain.base;

import lombok.Data;
import org.zgd.code.enums.ResultCode;

import java.io.Serializable;

/**
 * @author thesky
 * @date 2022/8/9 15:53
 */
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public Result<T> success(){
        return success(null);
    }
    public Result<T> success(T data){
        this.code = ResultCode.SUCCESS.getCode();
        this.message =ResultCode.SUCCESS.getMessage();
        this.data =data;
        return this;
    }

    public Result<T> error(){
        return error(null);
    }
    public Result<T> error(T data){
        this.code = ResultCode.BAD_REQUEST.getCode();
        this.message =ResultCode.BAD_REQUEST.getMessage();
        this.data =data;
        return this;
    }
}
