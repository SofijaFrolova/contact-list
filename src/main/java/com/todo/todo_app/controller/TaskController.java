package com.todo.todo_app.controller;

import com.todo.todo_app.models.Task;
import com.todo.todo_app.repository.TaskRepository;
import com.todo.todo_app.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;
    private TaskService taskService;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/task")
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);;
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);;
        return "redirect:/tasks";
    }
}
