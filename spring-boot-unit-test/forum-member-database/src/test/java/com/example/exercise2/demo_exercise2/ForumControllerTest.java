package com.example.exercise2.demo_exercise2;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.exercise2.demo_exercise2.controller.impl.ForumController;
import com.example.exercise2.demo_exercise2.dto.AllCommentByUserDto;
import com.example.exercise2.demo_exercise2.dto.AllCommentByUserDto.CommentsOfUser;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.AdderssDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.AdderssDto.GeoDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.CompanyDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.PostDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.PostDto.CommentDto;
import com.example.exercise2.demo_exercise2.mapper.AllCommentByUserDtoMapper;
import com.example.exercise2.demo_exercise2.service.ForumService;

@WebMvcTest(ForumController.class)
public class ForumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ForumService forumService;

    @MockBean
    private AllCommentByUserDtoMapper allCommentByUserDtoMapper;

    CommentsOfUser commentsOfUser1;
    CommentsOfUser commentsOfUser2;
    AllCommentByUserDto allCommentByUserDto;
    List<CommentsOfUser> list;
    CommentDto comment1;
    CommentDto comment2;
    List<CommentDto> comments;
    PostDto post1;
    List<PostDto> posts;
    GeoDto geo;
    AdderssDto address;
    CompanyDto company;
    AllDataByUserDto result1;

    @BeforeEach
    void setUp() {
        // sample for question 2
        commentsOfUser1 = CommentsOfUser.builder().name("com1")
                .email("sample1.com").body("body1").build();
        commentsOfUser2 = CommentsOfUser.builder().name("com2")
                .email("sample2.com").body("body2").build();
        list = List.of(commentsOfUser1, commentsOfUser2);
        allCommentByUserDto = AllCommentByUserDto.builder().id(1)
                .username("person1").commentOfUserList(list).build();

        // sample for question 1
        comment1 = CommentDto.builder().id(1).name("hello1")
                .email("comment@1").body("cbody1").build();
        comment2 = CommentDto.builder().id(2).name("hello2")
                .email("comment@2").body("cbody2").build();
        comments = Arrays.asList(comment1, comment2);
        post1 = PostDto.builder().id(1).title("Post Title1").body("post body 1")
                .comments(comments).build();
        posts = Arrays.asList(post1);
        geo = GeoDto.builder().lat("12.345").lng("-34.567").build();
        address = AdderssDto.builder().street("123 St").suite("Suite 456")
                .city("HK").zipcode("000000").geoDto(geo).build();
        company = CompanyDto.builder().name("ABC Ltd").catchPhrase("unknown")
                .bs("bssss").build();

        result1 = AllDataByUserDto.builder().id(1).name("Person1")
                .username("test1").email("person1.com").address(address)
                .phone("3456-7890").website("na.com").company(company)
                .posts(posts).build();
    }

    @Test
    void testGetAllDataByUser() throws Exception {

        Mockito.when(forumService.getAllDataByUser())
                .thenReturn(List.of(result1));

        mockMvc.perform(MockMvcRequestBuilders.get("/getalldatabyuser"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Person1"))
                .andExpect(jsonPath("$[0].username").value("test1"))
                .andExpect(jsonPath("$[0].email").value("person1.com"))
                .andExpect(jsonPath("$[0].address.street").value("123 St"))
                .andExpect(jsonPath("$[0].address.suite").value("Suite 456"))
                .andExpect(jsonPath("$[0].address.city").value("HK"))
                .andExpect(jsonPath("$[0].address.zipcode").value("000000"))
                .andExpect(jsonPath("$[0].address.geoDto.lat").value("12.345"))
                .andExpect(jsonPath("$[0].address.geoDto.lng").value("-34.567"))
                .andExpect(jsonPath("$[0].phone").value("3456-7890"))
                .andExpect(jsonPath("$[0].website").value("na.com"))
                .andExpect(jsonPath("$[0].company.name").value("ABC Ltd"))
                .andExpect(jsonPath("$[0].company.catchPhrase").value("unknown"))
                .andExpect(jsonPath("$[0].company.bs").value("bssss"))
                .andExpect(jsonPath("$[0].posts[0].id").value(1))
                .andExpect(jsonPath("$[0].posts[0].title").value("Post Title1"))
                .andExpect(jsonPath("$[0].posts[0].body").value("post body 1"))
                .andExpect(jsonPath("$[0].posts[0].comments[0].id").value(1))
                .andExpect(jsonPath("$[0].posts[0].comments[0].name").value("hello1"))
                .andExpect(jsonPath("$[0].posts[0].comments[0].email").value("comment@1"))
                .andExpect(jsonPath("$[0].posts[0].comments[0].body").value("cbody1"))
                .andExpect(jsonPath("$[0].posts[0].comments[1].id").value(2))
                .andExpect(jsonPath("$[0].posts[0].comments[1].name").value("hello2"))
                .andExpect(jsonPath("$[0].posts[0].comments[1].email").value("comment@2"))
                .andExpect(jsonPath("$[0].posts[0].comments[1].body").value("cbody2"));
    }

    @Test
    void testGetAllCommentByUserException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getallcommentbyuser")
                .param("id", "hello")).andExpect(status().isBadRequest());
    }

    @Test
    void testGetAllCommentByUser() throws Exception {
        Mockito.when(allCommentByUserDtoMapper.map(Mockito.anyInt(),
                Mockito.anyList())).thenReturn(allCommentByUserDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/getallcommentbyuser")
                .param("id", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("person1"))
                .andExpect(jsonPath("$.commentOfUserList[0].name").value("com1"))
                .andExpect(jsonPath("$.commentOfUserList[0].email").value("sample1.com"))
                .andExpect(jsonPath("$.commentOfUserList[0].body").value("body1"))
                .andExpect(jsonPath("$.commentOfUserList[1].name").value("com2"))
                .andExpect(jsonPath("$.commentOfUserList[1].email").value("sample2.com"))
                .andExpect(jsonPath("$.commentOfUserList[1].body").value("body2"));
    }
}
