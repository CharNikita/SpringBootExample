package ru.goncharenko.example.repository;

import org.springframework.data.repository.CrudRepository;
import ru.goncharenko.example.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
