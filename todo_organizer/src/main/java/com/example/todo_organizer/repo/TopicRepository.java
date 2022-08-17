package com.example.todo_organizer.repo;

import com.example.todo_organizer.entity.Task;
import com.example.todo_organizer.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {}
