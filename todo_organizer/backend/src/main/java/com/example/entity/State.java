package com.example.entity;

public enum State {
    DONE("done"),
    IN_PROGRESS("in progress");

    State(String condition) {
        this.condition = condition;
    }
    final String condition;
}
