package com.example.community.service.topic;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TopicSearchResultDto {

    private Long topicNum;
    private String name;
    private String title;
    private LocalDateTime createdAt;
    private String jobTitle;

    @Builder
    public TopicSearchResultDto(Long topicNum,String name, String title, LocalDateTime createdAt, String jobTitle) {
        this.topicNum = topicNum;
        this.name = name;
        this.title = title;
        this.createdAt = createdAt;
        this.jobTitle = jobTitle;
    }
}
