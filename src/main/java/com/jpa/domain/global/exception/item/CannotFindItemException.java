package com.jpa.domain.global.exception.item;

import com.jpa.domain.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class CannotFindItemException extends GeneralException {

    public CannotFindItemException() {
        super(HttpStatus.BAD_REQUEST, "상품을 찾을 수 없습니다!");
    }
}
