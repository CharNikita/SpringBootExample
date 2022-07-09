package ru.goncharenko.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.goncharenko.example.model.Task;
import ru.goncharenko.example.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTask() {
        List<Task> resultList = new ArrayList<>();
        taskRepository.findAll().forEach(resultList::add);

        return resultList;
    }

    @Override
    public Task getTaskById(final Integer id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public Task createTask(final Task newTask) {
        return taskRepository.save(newTask);
    }

    @Override
    public void deleteTaskById(final Integer id) {
        taskRepository.deleteById(id);
    }
}
