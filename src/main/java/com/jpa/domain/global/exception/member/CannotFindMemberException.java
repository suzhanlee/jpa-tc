package com.jpa.domain.global.exception.member;

import com.jpa.domain.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class CannotFindMemberException extends GeneralException {

    public CannotFindMemberException() {
        super(HttpStatus.BAD_REQUEST, "회원을 찾을 수 없습니다!");
    }
}
