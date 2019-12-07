package com.example.community.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTopic is a Querydsl query type for Topic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTopic extends EntityPathBase<Topic> {

    private static final long serialVersionUID = 27059291L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTopic topic = new QTopic("topic");

    public final com.example.community.common.QBaseTimeEntity _super = new com.example.community.common.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final QMember member;

    public final StringPath title = createString("title");

    public final NumberPath<Long> topicSeq = createNumber("topicSeq", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTopic(String variable) {
        this(Topic.class, forVariable(variable), INITS);
    }

    public QTopic(Path<? extends Topic> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTopic(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTopic(PathMetadata metadata, PathInits inits) {
        this(Topic.class, metadata, inits);
    }

    public QTopic(Class<? extends Topic> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

