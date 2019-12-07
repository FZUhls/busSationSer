package com.example.lessonthree.utils;

import com.example.lessonthree.model.Result;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result wrongParame(){
        Result result = new Result();
        result.setCode(101);
        result.setMsg("Wrong Parame");
        return  result;
    }
}
