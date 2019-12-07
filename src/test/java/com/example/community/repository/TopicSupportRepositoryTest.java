package com.example.community.repository;

import com.example.community.repository.topic.TopicRepositorySupport;
import com.example.community.service.topic.TopicSearchResultDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicSupportRepositoryTest {
    @Autowired
    private TopicRepositorySupport topicRepositorySupport;

    @Test
    public void findByName(){
        List<TopicSearchResultDto> result = topicRepositorySupport.findByName("gavin");
        System.out.println(result);
    }
}