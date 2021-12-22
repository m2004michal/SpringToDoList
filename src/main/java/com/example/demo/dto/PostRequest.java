package com.example.demo.dto;

import com.example.demo.model.PriorityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private Long postId;
    private String postName;
    private String description;
    private PriorityType priorityType;
}
