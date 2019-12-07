package com.example.community.repository.topic;

import com.example.community.domain.QMember;
import com.example.community.domain.QProfile;
import com.example.community.domain.QTopic;
import com.querydsl.core.BooleanBuilder;

public class TopicPredicate {
    private final static QMember member = QMember.member;
    private final static  QTopic topic = QTopic.topic;
    private final static  QProfile profile = QProfile.profile;

    public static BooleanBuilder byMemberName(String name){
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(member.name.eq(name));
        return builder;
    }
}
