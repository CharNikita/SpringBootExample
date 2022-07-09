package ru.goncharenko.example.service;

import ru.goncharenko.example.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();

    Task getTaskById(final Integer id);

    Task createTask(final Task newTask);

    void deleteTaskById(final Integer id);
}
