package com.jpa.domain.member.service;

import static org.junit.jupiter.api.Assertions.*;

import net.bytebuddy.asm.Advice.Unused;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EntityManagerMemberServiceTest {

    @Autowired
    private EntityManagerMemberService memberService;

    @Test
    @DisplayName("쓰기지연 테스트")
    void test(){
        // when
        memberService.save();

        // then
        System.out.println();
    }

}