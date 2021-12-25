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
import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public List<PostResponse> getPostsByCurrentUser() {
        List<Post> posts= postRepository.findAllByUser(authService.getCurrentUser());
        return posts.stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional
    public void deletePostById(Long id){
        Post post = postRepository.findByPostId(id);
        if(authService.getCurrentUser().equals(post.getUser())) {
            postRepository.delete(postRepository.findByPostId(id));
            System.out.println("Post Deleted Successfully");
        }else throw new SpringToDoException("U cannot delete other users posts");
    }
}
