package com.example.community.domain;

import com.example.community.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "`Address`")
public class Address  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressSeq;
    private String countryCode;
    private String city;
    private String street;
    private String postNumber;

    @Builder
    public Address(String countryCode, String city,String street, String postNumber) {
        this.countryCode = countryCode;
        this.city = city;
        this.street = street;
        this.postNumber = postNumber;
    }
}
