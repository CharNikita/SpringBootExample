package ru.goncharenko.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Builder
@Accessors(fluent = true, chain = true)
public class Task {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("isCompleted")
    private Boolean completed;
}
