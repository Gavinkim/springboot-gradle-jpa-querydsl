package com.example.community.repository.topic;

import com.example.community.domain.QAddress;
import com.example.community.domain.QMember;
import com.querydsl.core.types.dsl.SimpleExpression;

public class TopicGroup {
    private static final QMember member = QMember.member;
    private static final QAddress address = QAddress.address;

    public static SimpleExpression[] member(){
        return new SimpleExpression[]{
                member.name
                //,address.city
        };
    }
    public static SimpleExpression[] city(){
        return new SimpleExpression[]{
                address.city
        };
    }
}
