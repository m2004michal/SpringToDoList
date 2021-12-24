package com.example.SpringToDoApp.service;

import com.example.SpringToDoApp.dto.PostRequest;
import com.example.SpringToDoApp.dto.PostResponse;
import com.example.SpringToDoApp.exceptions.SpringToDoException;
import com.example.SpringToDoApp.mapper.PostMapper;
import com.example.SpringToDoApp.model.Post;
import com.example.SpringToDoApp.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    @Transactional
    public void save(PostRequest postRequest) {
        postRepository.save(postMapper.map(postRequest, authService.getCurrentUser()));
    }

    @Transactional
    public PostResponse getPost(Long id) {
      Post post = postRepository.findById(id)
              .orElseThrow(() -> new SpringToDoException("No post with id: " + id + " found"));
        return postMapper.mapToDto(post);
    }
}
