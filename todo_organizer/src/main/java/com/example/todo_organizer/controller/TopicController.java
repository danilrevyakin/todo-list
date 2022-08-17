package com.example.todo_organizer.controller;

import com.example.todo_organizer.entity.Topic;
import com.example.todo_organizer.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics(){
        List<Topic> topics = topicService.findAllTopics();
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> findTopicById(@PathVariable("id") Long id){
        Topic topic = topicService.findById(id);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic){
        Topic newTopic = topicService.post(topic);
        return new ResponseEntity<>(newTopic, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic){
        Topic updatedTopic = topicService.updateTopic(topic);
        return new ResponseEntity<>(updatedTopic, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTopicById(@PathVariable("id") Long id){
        topicService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/completed")
//    public ResponseEntity<List<Topic>> getCompletedTopics(){
//        List<Topic> topics = topicService.findAllTopics();
//        return new ResponseEntity<>(topics, HttpStatus.OK);
//    }


}
