package com.example.repo;

import com.example.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    @Query("select t from Task t where t.isDone is true")
    List<Task> findTasksByDoneTrue();

    @Query("select t from Task t where t.isDone is false")
    List<Task> findTasksByDoneFalse();
}
