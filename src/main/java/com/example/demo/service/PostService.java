package com.example.demo.service;

import com.example.demo.dto.PostRequest;
import com.example.demo.mapper.PostMapper;
import com.example.demo.repository.PostRepository;
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
}
