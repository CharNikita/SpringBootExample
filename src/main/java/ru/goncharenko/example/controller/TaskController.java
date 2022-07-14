package ru.goncharenko.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.goncharenko.example.model.Task;
import ru.goncharenko.example.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<Task> allTasks() {
        return taskService.getAllTask();
    }

    @GetMapping("{id}")
    public Task taskById(@PathVariable final Integer id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createNewTask(@RequestBody final Task newTask) {
        return taskService.createTask(newTask);
    }

    @DeleteMapping("{id}")
    public void deleteTaskById(@PathVariable final Integer id) {
        taskService.deleteTaskById(id);
    }
}
