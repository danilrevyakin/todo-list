package com.example.todo_organizer.repo;

import com.example.todo_organizer.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    List<Task> findAllByTopicId(Long topicId);
}
