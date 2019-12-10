package com.newre.common;

import com.newre.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ResponseResult<T> {
    private CommonCode commonCode;
    private T t;
    private List<T> list;

    public ResponseResult(CommonCode commonCode) {
        this.commonCode = commonCode;
    }
}
