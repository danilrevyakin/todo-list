package com.example.todo_organizer.controller;

import com.example.todo_organizer.service.TaskService;
import com.example.todo_organizer.entity.Task;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task newTask = taskService.add(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Task> updateStudent(@RequestBody Task task) {
        Task updatedTask = taskService.updateTask(task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasksByTopicId(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> createTaskForm(@RequestBody Task task) {
        Task newTask = taskService.add(task);
        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }
}
