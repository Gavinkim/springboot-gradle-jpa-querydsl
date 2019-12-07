package com.example.community.repository.topic;

import com.example.community.domain.QMember;
import com.example.community.domain.QProfile;
import com.example.community.domain.QTopic;
import com.example.community.service.topic.TopicSearchResultDto;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;

public class TopicResult {
    private static final  QMember member = QMember.member;
    private static final QTopic topic = QTopic.topic;
    private static final QProfile profile = QProfile.profile;

    public static ConstructorExpression<TopicSearchResultDto> topic(){
        return Projections.constructor(TopicSearchResultDto.class,
                topic.topicSeq.as("topicNum"),
                member.name.as("name"),
                topic.title.as("title"),
                topic.createdAt.as("createdAt"),
                profile.title.as("jobTitle")
        );
    }
}