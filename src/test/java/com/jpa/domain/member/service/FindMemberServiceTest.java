package com.jpa.domain.member.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import com.jpa.db.entity.member.Member;
import com.jpa.db.valuetype.Address;
import com.jpa.domain.member.repository.MemberRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FindMemberServiceTest {

    @Autowired
    private FindMemberService findMemberService;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        // given
        Member member1 = Member.createMember("회원1", new Address("수원시", "매봉로", "1234"));
        Member member2 = Member.createMember("회원2", new Address("서울시", "강남구", "5678"));

        memberRepository.saveAll(List.of(member1, member2));
    }

    @Test
    @DisplayName("회원 목록을 조회할 수 있습니다.")
    void findAllMembersTest() {
        // when
        List<Member> memberList = findMemberService.findAllMembers();

        // then
        assertThat(memberList)
            .extracting("name", "address")
            .contains(tuple("회원1", new Address("수원시", "매봉로", "1234")),
                tuple("회원2", new Address("서울시", "강남구", "5678")));
    }

}