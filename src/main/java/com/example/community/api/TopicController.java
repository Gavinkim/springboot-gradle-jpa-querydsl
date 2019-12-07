package com.example.community.api;

import com.example.community.common.CommonResponse;
import com.example.community.common.StaticValues;
import com.example.community.service.topic.TopicSearchResultDto;
import com.example.community.service.topic.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping("/find")
    public CommonResponse getTopicWithName(String name){
        Optional<List<TopicSearchResultDto>> result = topicService.findByName(name);
        if(result.isPresent()){
            return CommonResponse.ok(result.get(),StaticValues.SUCCESS_CODE,StaticValues.SUCCESS_MSG);
        }
        return CommonResponse.error(StaticValues.FAIL_CODE,StaticValues.SUCCESS_MSG,"Please....");
    }
}
