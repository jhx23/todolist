package com.jh.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) { this.todoService = todoService; }

    @RequestMapping("/todo")
    public String todo(Model model) {
        List<TodoDto> todoDtoList = this.todoService.readAll();
        model.addAttribute("todoList", todoDtoList);
        return "todo";
    }

    @RequestMapping("/")
    public String home() { return "redirect:/todo"; }

    @PostMapping("/todo/create")
    public String create(
            @RequestParam("todo-desc") String content) {
        todoService.createTodo(content);
        return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/update")
    public String update(@PathVariable("id") Long id) {
        todoService.updateTodo(id);
        return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todo";
    }
}