package com.jpa.domain.member.model.rq;

import com.jpa.db.entity.member.Member;
import com.jpa.db.valuetype.Address;

public class CreateMemberRq {

    private String name;
    private Address address;

    public static CreateMemberRq of(String name, Address address) {
        CreateMemberRq rq = new CreateMemberRq();
        rq.name = name;
        rq.address = address;
        return rq;
    }

    public Member toEntity() {
        return Member.createMember(name, address);
    }
}
