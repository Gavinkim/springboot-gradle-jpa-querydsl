package com.example.community.repository.topic;

import com.example.community.domain.QMember;
import com.example.community.domain.QProfile;
import com.example.community.domain.QTopic;
import com.example.community.domain.Topic;
import com.example.community.service.topic.TopicSearchResultDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public TopicRepositorySupport(JPAQueryFactory queryFactory) {
        super(Topic.class);
        this.queryFactory = queryFactory;
    }

    /*
    select
        m.name,p.title '직업',t.title '제목',t.created_at '작성일자',t.topic_seq '번호'
        from `member` m
        join `topic` t
        on m.member_seq = t.member_seq
        join `profile` p
        on  p.profile_seq = m.profile_seq
        where m.name='gavin';
    */
    public List<TopicSearchResultDto> findByName(String name){
        QMember member = QMember.member;
        QTopic topic = QTopic.topic;
        QProfile profile = QProfile.profile;
        return queryFactory.select(TopicResult.topic())
                .from(member)
                .join(topic)
                .on(member.memberSeq.eq(topic.member.memberSeq))
                .join(profile)
                .on(profile.profileSeq.eq(member.profile.profileSeq))
                .where(TopicPredicate.byMemberName(name))
                .fetch();
    }

}
