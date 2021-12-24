package com.example.SpringToDoApp.model;


import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;
    @NotBlank(message = "Post name cannot be empty or Null")
    private String postName;
    @Nullable
    @Lob
    private String description;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName ="userId")
    private User user;
    private Instant createdDate;
    private PriorityType priorityType;


}