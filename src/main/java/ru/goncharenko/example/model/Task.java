package ru.goncharenko.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
@ToString
public class Task {
    @Id
    private Integer id;
    private String text;
    private Boolean isCompleted;
}
