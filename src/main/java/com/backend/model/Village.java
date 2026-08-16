package com.backend.model;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class Village {
    private Long id;
    private String name;
    private String location;
    private long population;
    private int priorityScore;
}
