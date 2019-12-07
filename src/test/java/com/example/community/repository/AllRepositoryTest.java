package com.example.community.repository;

import com.example.community.domain.*;
import com.example.community.repository.core.CommonRepository;
import com.example.community.repository.topic.TopicRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest
public class AllRepositoryTest {

    private Member member;
    private Profile profile;
    private Address address;
    private Topic topic;
    private Comment comment;

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CommentRepository commentRepository;


    @Before
    public void setUp() throws Exception {
        address = Address.builder()
                .city(UUID.randomUUID().toString())
                .countryCode("KOR")
                .street("test")
                .postNumber("123")
                .build();
        profile = Profile.builder()
                .title(UUID.randomUUID().toString())
                .description("test")
                .build();
    }

    @Test
    public void save(){
        profile = profileRepository.save(profile);
        address = addressRepository.save(address);
        member = memberRepository.save(member.builder()
                .profile(profile)
                .address(address)
                .email("test@test.com")
                .name("test")
                .password("password")
                .build());
        assertThat(member.getEmail()).isEqualTo("test@test.com");

        topic = topicRepository.save(Topic.builder()
                .member(member)
                .title("test")
                .description("test")
                .build());
        assertThat(topic.getTitle()).isEqualTo("test");

        comment = commentRepository.save(
                Comment.builder()
                        .title("test")
                        .description("test")
                        .topic(topic)
                        .member(member)
                        .build()
        );
    }

    @After
    public void tearDown() throws Exception {
        topicRepository.delete(topic);
        profileRepository.delete(profile);
        commentRepository.delete(comment);
        memberRepository.delete(member);
    }

}