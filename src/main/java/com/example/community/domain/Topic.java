package com.example.community.domain;

import com.example.community.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "`Topic`")
@Where(clause = "deleted = 0")
@SQLDelete(sql = "update `topic` set deleted = 1 where topic_seq = ?", check = ResultCheckStyle.COUNT)
public class Topic extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicSeq;
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "memberSeq",referencedColumnName = "memberSeq",nullable = false)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Member member;

    @Builder
    public Topic(String title, String description, Member member) {
        this.title = title;
        this.description = description;
        this.member = member;
    }
}
