package com.jpa.domain.member.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jpa.db.entity.member.Member;
import com.jpa.db.valuetype.Address;
import com.jpa.domain.member.model.rq.CreateMemberRq;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private FindMemberService findMemberService;

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("회원을 등록할 수 있습니다.")
    void saveMemberTest() {
        // given
        CreateMemberRq rq = CreateMemberRq.of("이수찬", new Address("수원시", "매봉로", "1234"));

        // when
        Member member = memberService.saveMember(rq);
        Member findMember = findMemberService.findByIdOrElseThrow(member.getId());

        // then
        assertThat(findMember.getName()).isEqualTo("이수찬");
        assertThat(findMember.getAddress()).isEqualTo(new Address("수원시", "매봉로", "1234"));
    }
}