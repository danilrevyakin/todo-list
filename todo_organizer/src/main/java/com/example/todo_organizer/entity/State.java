package com.example.todo_organizer.entity;

public enum State {
    DONE("done"),
    IN_PROGRESS("in progress");

    State(String condition) {
        this.condition = condition;
    }
    final String condition;
}
