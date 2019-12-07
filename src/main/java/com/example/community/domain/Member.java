package com.example.community.domain;

import com.example.community.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "`member`")
@Where(clause = "deleted = 0")
@SQLDelete(sql = "update `member` set deleted = 1 where member_seq = ?", check = ResultCheckStyle.COUNT)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;
    private String name;
    private String email;
    private String password;
    private boolean deleted=false;

    @OneToOne(fetch = FetchType.LAZY,targetEntity = Address.class)
    @JoinColumn(name = "addressSeq", referencedColumnName = "addressSeq", nullable = false)
    private Address address;

    @OneToOne(fetch = FetchType.LAZY,targetEntity = Profile.class)
    @JoinColumn(name = "profileSeq", referencedColumnName = "profileSeq", nullable = false)
    private Profile profile;

    @Builder
    public Member(String name,String email,String password,Profile profile, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.profile = profile;
    }
}
