package com.example.exercise2.demo_exercise2.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.infra.NotFoundException;
import com.example.exercise2.demo_exercise2.infra.Protocol;
import com.example.exercise2.demo_exercise2.infra.RestTemplateException;
import com.example.exercise2.demo_exercise2.infra.UrlBuilder;
import com.example.exercise2.demo_exercise2.mapper.CommentEntityMapper;
import com.example.exercise2.demo_exercise2.model.Comment;
import com.example.exercise2.demo_exercise2.repository.CommentRepository;
import com.example.exercise2.demo_exercise2.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String domain;

  @Value(value = "${api.jsonplaceholder.endpoint.comments}")
  private String endpoint;

  @Override
  public List<Comment> getApiData() {
    try {
      Comment[] comments = restTemplate.getForObject(
          UrlBuilder.get(Protocol.HTTP, domain, endpoint), Comment[].class);
      return Arrays.asList(comments);
    } catch (RestClientException e) {
      throw new RestTemplateException();
    }
  }

  @Override
  public List<CommentEntity> saveApiDataToDb(List<Comment> comments) {
    List<CommentEntity> commentEntities = comments.stream()
        .map(x -> commentEntityMapper.map(x)).collect(Collectors.toList());
    return commentRepository.saveAll(commentEntities);
  }

  @Override
  public void deleteAllDb() {
    commentRepository.deleteAll();
  }

  @Override
  public List<CommentEntity> findAllComments() {
    return commentRepository.findAll();
  }

  @Override
  public CommentEntity findbyId(Integer commentId) {
    return commentRepository.findById(commentId).get();
  }

  @Override
  public List<CommentEntity> findByPostId(Integer postId) {
    return commentRepository.findByPostId(postId)
        .orElseThrow(() -> new NotFoundException());
  }
}
