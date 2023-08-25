package com.jpa.domain.member.service;

import com.jpa.db.entity.member.Member;
import com.jpa.domain.member.model.rq.CreateMemberRq;
import com.jpa.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(CreateMemberRq rq) {
        Member member = rq.toEntity();
        memberRepository.save(member);
        return member;
    }
}
