package org.zgd.code.enums;

import lombok.Getter;

/**
 * @author thesky
 * @date 2022/8/9 15:49
 */
@Getter
public enum ResultCode {

    SUCCESS(200,"成功"),
    BAD_REQUEST(400,"Bad Request");


    private Integer code;
    private String message;

    ResultCode(Integer code, String message){
        this.code =code;
        this.message=message;
    }

}
