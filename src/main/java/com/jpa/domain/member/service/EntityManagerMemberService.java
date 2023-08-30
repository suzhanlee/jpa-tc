package com.jpa.domain.member.service;

import com.jpa.db.entity.member.Member;
import com.jpa.db.valuetype.Address;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntityManagerMemberService {

    @Autowired
    private EntityManager em;

    public void save() {

        Member member = Member.createMember("name", new Address("city", "street", "zipcode"));
        Member member2 = Member.createMember("name", new Address("city", "street", "zipcode"));

        em.persist(member);
        em.persist(member2);

        System.out.println("member2 = " + member2);
        System.out.println("member = " + member);
    }



}
