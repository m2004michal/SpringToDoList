package com.example.SpringToDoApp.mapper;


import com.example.SpringToDoApp.dto.PostRequest;
import com.example.SpringToDoApp.dto.PostResponse;
import com.example.SpringToDoApp.model.Post;
import com.example.SpringToDoApp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "Spring")
public abstract class PostMapper {


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "priorityType", source = "postRequest.priorityType")
    @Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "userName", source = "user.username")
    public abstract PostResponse mapToDto(Post post);
}


