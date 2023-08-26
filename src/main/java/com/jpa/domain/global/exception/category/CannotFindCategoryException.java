package com.jpa.domain.global.exception.category;

import com.jpa.domain.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class CannotFindCategoryException extends GeneralException {

    public CannotFindCategoryException() {
        super(HttpStatus.BAD_REQUEST, "카테고리를 찾을 수 없습니다!");
    }
}
