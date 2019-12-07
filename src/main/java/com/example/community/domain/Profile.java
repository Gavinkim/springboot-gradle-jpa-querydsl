package com.example.community.domain;

import com.example.community.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "`profile`")
public class Profile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileSeq;
    private String title;
    private String description;

    @Builder
    public Profile(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
