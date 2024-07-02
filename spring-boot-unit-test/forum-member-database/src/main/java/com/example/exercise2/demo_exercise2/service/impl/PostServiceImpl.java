package com.example.exercise2.demo_exercise2.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.example.exercise2.demo_exercise2.entity.PostEntity;
import com.example.exercise2.demo_exercise2.infra.NotFoundException;
import com.example.exercise2.demo_exercise2.infra.Protocol;
import com.example.exercise2.demo_exercise2.infra.RestTemplateException;
import com.example.exercise2.demo_exercise2.infra.UrlBuilder;
import com.example.exercise2.demo_exercise2.mapper.PostEntityMapper;
import com.example.exercise2.demo_exercise2.model.Post;
import com.example.exercise2.demo_exercise2.repository.PostRepository;
import com.example.exercise2.demo_exercise2.service.PostService;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String domain;

  @Value(value = "${api.jsonplaceholder.endpoint.posts}")
  private String endpoint;

  @Override
  public List<Post> getApiData() {
    try {
      Post[] posts = restTemplate.getForObject(
          UrlBuilder.get(Protocol.HTTP, domain, endpoint), Post[].class);
      return Arrays.asList(posts);
    } catch (RestClientException e) {
      throw new RestTemplateException();
    }
  }

  @Override
  public List<PostEntity> saveApiDataToDb(List<Post> posts) {
    List<PostEntity> postEntities = posts.stream()
        .map(x -> postEntityMapper.map(x)).collect(Collectors.toList());
    return postRepository.saveAll(postEntities);
  }

  @Override
  public void deleteAllDb() {
    postRepository.deleteAll();
  }

  @Override
  public List<PostEntity> findAllPosts() {
    return postRepository.findAll();
  }

  @Override
  public PostEntity findbyId(Integer postId) {
    return postRepository.findById(postId)
        .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public List<PostEntity> findByUserId(Integer userId) {
    return postRepository.findByUserId(userId)
        .orElseThrow(() -> new NotFoundException());
  }

}
