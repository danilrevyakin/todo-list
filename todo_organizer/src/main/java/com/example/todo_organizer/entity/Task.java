package com.example.todo_organizer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    private boolean isDone;

    @ManyToOne
    @JoinColumn(name="topic_id", nullable=false)
    private Topic topic;

    public Task(String description, LocalDate deadline) {
        this.description = description;
        this.deadline = deadline;
        this.isDone = false;
    }
}
