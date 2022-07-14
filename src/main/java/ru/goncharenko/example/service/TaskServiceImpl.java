package ru.goncharenko.example.service;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import ru.goncharenko.example.model.Task;

import java.util.List;

import static ru.goncharenko.example.jooq.tables.Task.TASK;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final DSLContext dsl;

    @Override
    public List<Task> getAllTask() {
        return dsl
                .selectFrom(TASK)
                .fetch()
                .stream()
                .map(record -> Task.builder()
                        .id(record.getValue(TASK.ID))
                        .text(record.getValue(TASK.TEXT))
                        .completed(record.getValue(TASK.IS_COMPLETED))
                        .build()
                ).toList();
    }

    @Override
    public Task getTaskById(final Integer id) {
        return dsl
                .selectFrom(TASK)
                .where(TASK.ID.eq(id))
                .fetchOptional()
                .orElseThrow()
                .into(Task.class);
    }

    @Override
    public Task createTask(final Task newTask) {
        return dsl.insertInto(TASK)
                  .set(dsl.newRecord(TASK, newTask))
                  .returning()
                  .fetchOptional()
                  .orElseThrow()
                  .into(Task.class);

    }

    @Override
    public void deleteTaskById(final Integer id) {
        dsl.deleteFrom(TASK)
           .where(TASK.ID.eq(id))
           .execute();
    }
}
