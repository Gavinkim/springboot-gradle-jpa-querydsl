package com.example.community.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAddress extends EntityPathBase<Address> {

    private static final long serialVersionUID = 225744928L;

    public static final QAddress address = new QAddress("address");

    public final com.example.community.common.QBaseTimeEntity _super = new com.example.community.common.QBaseTimeEntity(this);

    public final NumberPath<Long> addressSeq = createNumber("addressSeq", Long.class);

    public final StringPath city = createString("city");

    public final StringPath countryCode = createString("countryCode");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath postNumber = createString("postNumber");

    public final StringPath street = createString("street");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata metadata) {
        super(Address.class, metadata);
    }

}

