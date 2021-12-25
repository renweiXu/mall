package cn.mall.utils;

import lombok.Data;

/**
 * @author xurw
 * @description .
 * @date 2021/12/22
 */
@Data
public class Result {

    private Integer code;

    private String message;

    private Object data;

    public Result(Integer code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(String message,Object data){
        return new Result(200,message,data);
    }

    public Result faile(String message){
        return new Result(-1,message,null);
    }
}
