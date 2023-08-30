package com.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.jpa.db.entity.member.Member;
import com.jpa.db.valuetype.Address;
import com.jpa.domain.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.PropertyAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class JpaTest {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("준영속 상태의 식별자 테스트")
    void mergeTest() {
        // given
        Member member = Member.createMember("이름", new Address("city", "street", "zipcode"));
        em.persist(member);

        // when
        Long memberId = member.getId();
        System.out.println("memberId = " + memberId);
        Member findMember = em.find(Member.class, memberId);

        em.flush();
        em.clear();

        Member mergedMember = em.merge(member);
        Long mergedId = mergedMember.getId();
        System.out.println("mergedId = " + mergedId);
        Member newMember = em.find(Member.class, mergedId);

        // then
        assertThat(memberId).isEqualTo(mergedId);
        assertThat(findMember).isNotEqualTo(newMember);
    }

    @Test
    @DisplayName("준영속 상태의 변경감지")
    void mergeTest2() {
        // given
        Member member = Member.createMember("이름", new Address("city", "street", "zipcode"));
        em.persist(member);

        // when
        em.flush();
        em.clear();
        member.setMember("newName");

        Member mergedMember = em.merge(member);
        em.flush();
        em.clear();

        // then
        assertThat(member.getName()).isEqualTo(mergedMember.getName());
    }

    @Test
    @DisplayName("IDENTITY 키 생성 전략 DB 추가 조회 테스트")
    void generateKeyTest() {
        // given
        Member member = Member.createMember("이름", new Address("city", "street", "zipcode"));
        Member member2 = Member.createMember("이름", new Address("city", "street", "zipcode"));

        // when
        memberRepository.save(member);
        memberRepository.save(member2);
//        em.persist(member);
//        em.persist(member2);

        Member newMember = Member.createMember("이름", new Address("city", "street", "zipcode"));

        System.out.println("member = " + member.getId());

        // then
    }

    @Test
    @DisplayName("자바 원시타입과 @Column을 사용한다면?")
    void primitiveTypeTest() {
        assertThatThrownBy(() -> em.find(Member.class, 21L)).isInstanceOf(PropertyAccessException.class);
    }


}
