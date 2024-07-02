package com.example.exercise2.demo_exercise2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.AdderssDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.AdderssDto.GeoDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.CompanyDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.PostDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.PostDto.CommentDto;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.entity.PostEntity;
import com.example.exercise2.demo_exercise2.entity.UserEntity;
import com.example.exercise2.demo_exercise2.mapper.AllDataByUserDtoMapper;
import com.example.exercise2.demo_exercise2.service.CommentService;
import com.example.exercise2.demo_exercise2.service.PostService;
import com.example.exercise2.demo_exercise2.service.UserService;

@SpringBootTest
public class ForumServiceTest {

  @MockBean
  private UserEntity userEntity;
  @MockBean
  private PostEntity postEntity;
  @MockBean
  private CommentEntity commentEntity;
  @MockBean
  private UserService userService;
  @MockBean
  private PostService postService;
  @MockBean
  private CommentService commentService;
  @Autowired
  private AllDataByUserDtoMapper allDataByUserDtoMapper;

  CommentDto commentDto;
  PostDto postDto;
  AllDataByUserDto allDataByUserDto;

  UserEntity userEntity1;
  UserEntity userEntity2;
  PostEntity postEntity1;
  PostEntity postEntity2;
  CommentEntity commentEntity1;
  CommentEntity commentEntity2;
  List<CommentEntity> commentEntities;

  CommentDto commentDto1;
  CommentDto commentDto2;
  List<CommentDto> comments;
  PostDto postDto1;
  PostDto postDto2;
  List<PostDto> posts;
  GeoDto geo;
  AdderssDto address;
  CompanyDto company;
  AllDataByUserDto result1;

  @BeforeEach
  void setUp() {
    // sample for Entity
    userEntity1 = UserEntity.builder().userId(1).name("Person1")
        .username("test1").email("person1.com").addressStreet("123 St")
        .addressSuite("Suite 456").addressCity("HK").addressZipcode("000000")
        .geoLat("12.345").geoLng("-34.567").phone("3456-7890").website("na.com")
        .companyName("ABC Ltd").companyCatchPhrase("unknown").companyBs("bssss")
        .build();
    userEntity2 =
        UserEntity.builder().userId(2).name("Person2").username("test2")
            .email("person2.com").addressCity("XYZ").companyName("na").build();
    postEntity1 = PostEntity.builder().userId(1).postId(1).title("Post Title1")
        .body("post body 1").build();
    postEntity2 = PostEntity.builder().userId(2).postId(2).title("Post Title2")
        .body("post body 2").build();
    commentEntity1 = CommentEntity.builder().postId(1).CommentId(1)
        .commentName("hello1").email("comment@1").commentBody("cbody1").build();
    commentEntity2 = CommentEntity.builder().postId(1).CommentId(2)
        .commentName("hello2").email("comment@2").commentBody("cbody2").build();

    // sample for question 1
    commentDto1 = CommentDto.builder().id(1).name("hello1").email("comment@1")
        .body("cbody1").build();
    commentDto2 = CommentDto.builder().id(2).name("hello2").email("comment@2")
        .body("cbody2").build();
    comments = List.of(commentDto1, commentDto2);
    postDto1 = PostDto.builder().id(1).title("Post Title1").body("post body 1")
        .comments(comments).build();
    postDto2 = PostDto.builder().id(2).title("Post Title2").body("post body 2")
        .comments(comments).build();
    posts = List.of(postDto1, postDto2);
    geo = GeoDto.builder().lat("12.345").lng("-34.567").build();
    address = AdderssDto.builder().street("123 St").suite("Suite 456")
        .city("HK").zipcode("000000").geoDto(geo).build();
    company = CompanyDto.builder().name("ABC Ltd").catchPhrase("unknown")
        .bs("bssss").build();
    result1 = AllDataByUserDto.builder().id(1).name("Person1").username("test1")
        .email("person1.com").address(address).phone("3456-7890")
        .website("na.com").company(company).posts(posts).build();
  }

  @Test
  void testGetAllDataByUser() {

    assertEquals(commentDto1,
        allDataByUserDtoMapper.mapToCommentDto(commentEntity1));
    assertEquals(commentDto2,
        allDataByUserDtoMapper.mapToCommentDto(commentEntity2));
    assertEquals(postDto1,
        allDataByUserDtoMapper.mapToPostDto(postEntity1, comments));
    assertEquals(result1, allDataByUserDtoMapper.map(userEntity1, posts));

    Mockito.when(commentService.findByPostId(Mockito.anyInt()))
        .thenReturn(List.of(commentEntity1, commentEntity2));
    Mockito.when(postService.findByUserId(Mockito.anyInt()))
        .thenReturn(List.of(postEntity1, postEntity2));
    Mockito.when(userService.findAllUsers())
        .thenReturn(List.of(userEntity1, userEntity2));

    // verify(userService, times(1)).findAllUsers();
    // verify(postService, times(1)).findByUserId(userEntity.getUserId());
    // verify(commentService, times(1)).findByPostId(postEntity.getPostId());
    // verify(allDataByUserDtoMapper, times(1)).mapToCommentDto(commentEntity1);
    // verify(allDataByUserDtoMapper, times(1)).mapToPostDto(postEntity1,comments);
    // verify(allDataByUserDtoMapper, times(1)).map(userEntity1,posts);

  }

  @Test
  void testgetAllCommentByUser() {

    Mockito.when(postService.findAllPosts())
        .thenReturn(List.of(postEntity1, postEntity2));
    Mockito.when(commentService.findAllComments())
        .thenReturn(List.of(commentEntity1, commentEntity2));

    List<CommentEntity> excepted =
        new ArrayList<>(List.of(commentEntity1, commentEntity2));
    List<CommentEntity> actual = new ArrayList<>();
    postService.findAllPosts().stream().filter(x -> x.getUserId().equals(1))
        .forEach(postEntity -> {
          actual.addAll(commentService.findAllComments().stream()
              .filter(x -> x.getPostId() == postEntity.getPostId())
              .collect(Collectors.toList()));
        });

    assertEquals(excepted, actual);
  }
}
