package com.example.SpringToDoApp.dto;

import com.example.SpringToDoApp.model.PriorityType;
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
