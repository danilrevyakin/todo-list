package com.example.todo_organizer.service;

import com.example.todo_organizer.entity.Topic;
import com.example.todo_organizer.repo.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public List<Topic> findAllTopics(){
        return topicRepository.findAll();
    }

    public Topic findById(Long id){
        return topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public Topic post(Topic topic) {
        return topicRepository.save(topic);
    }

    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }

    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }
}
