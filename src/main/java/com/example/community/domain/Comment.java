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
@Table(name = "`Comment`")
@Where(clause = "deleted = 0")
@SQLDelete(sql = "update `comment` set deleted = 1 where comment_seq = ?", check = ResultCheckStyle.COUNT)
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentSeq;
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "memberSeq",referencedColumnName = "memberSeq",nullable = false)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "topicSeq",referencedColumnName = "topicSeq",nullable = false)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Topic topic;

    @Builder
    public Comment(String title, String description,Member member,Topic topic) {
        this.title = title;
        this.description = description;
        this.member = member;
        this.topic = topic;
    }
}
