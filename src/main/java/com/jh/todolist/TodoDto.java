package com.jh.todolist;

public class TodoDto {
    private Long id;
    private String content;
    private boolean done;

    public TodoDto() {}

    public TodoDto(Long id, String content, Boolean done) {
        this.id = id;
        this.content = content;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", done=" + done +
                '}';
    }
}

