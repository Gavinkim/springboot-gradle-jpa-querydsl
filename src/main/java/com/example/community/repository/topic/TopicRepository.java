package com.example.community.repository.topic;

import com.example.community.domain.*;
import com.example.community.repository.core.CommonRepository;
import com.example.community.service.topic.TopicSearchResultDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public interface TopicRepository extends CommonRepository<Topic,Long> {
}
