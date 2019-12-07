package com.example.community.service.topic;

import com.example.community.repository.topic.TopicRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepositorySupport topicRepositorySupport;

    public Optional<List<TopicSearchResultDto>> findByName(String name){
        if(StringUtils.isEmpty(name)){
            return Optional.empty();
        }
        List<TopicSearchResultDto> result = topicRepositorySupport.findByName(name);
        return ObjectUtils.isEmpty(result) ? Optional.empty() : Optional.of(result);
    }
}
