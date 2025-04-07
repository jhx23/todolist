package com.jh.todolist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Service
public class TodoService {
    private final List<TodoDto> todoList = new ArrayList<>();
    private Long nextId = 2L;

    public void createTodo(String content) {
        TodoDto newTodo = new TodoDto(nextId,content,false);
        nextId++;
        todoList.add(newTodo);
        System.out.println(todoList);
    }
    public List<TodoDto> readAll() { return todoList; }

    public void updateTodo(Long id) {
        TodoDto todoDto = todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .peek(todo -> todo.setDone(!todo.getDone()))
                .findFirst()
                .orElse(null);
        System.out.println(todoDto);
    }

    public void deleteTodo(Long id) {
        OptionalInt idx = IntStream
                .range(0, todoList.size())
                .filter(i -> todoList.get(i).getId().equals(id))
                .findFirst();
        if (idx.isPresent()) todoList.remove(idx.getAsInt());
        System.out.println(idx);
    }
}