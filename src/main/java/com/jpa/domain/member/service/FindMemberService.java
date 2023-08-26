package com.jpa.domain.member.service;

import com.jpa.db.entity.member.Member;
import com.jpa.domain.global.exception.member.CannotFindMemberException;
import com.jpa.domain.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindMemberService {

    private final MemberRepository memberRepository;

    public Member findByIdOrElseThrow(Long id) {
        return memberRepository.findById(id).orElseThrow(CannotFindMemberException::new);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
}
