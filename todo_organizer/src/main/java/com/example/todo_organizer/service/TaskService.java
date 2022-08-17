package com.example.todo_organizer.service;

import com.example.todo_organizer.entity.Task;
import com.example.todo_organizer.repo.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task add(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with id " + id + " does not exist"));
        taskRepository.delete(task);
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getTasksByTopicId(Long topicId){
        return taskRepository.findAllByTopicId(topicId);
    }
}
