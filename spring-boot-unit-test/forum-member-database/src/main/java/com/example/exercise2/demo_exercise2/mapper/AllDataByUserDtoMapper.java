package com.example.exercise2.demo_exercise2.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.AdderssDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.AdderssDto.GeoDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.CompanyDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.PostDto;
import com.example.exercise2.demo_exercise2.dto.AllDataByUserDto.PostDto.CommentDto;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;
import com.example.exercise2.demo_exercise2.entity.PostEntity;
import com.example.exercise2.demo_exercise2.entity.UserEntity;

@Component
public class AllDataByUserDtoMapper {

  public AllDataByUserDto map(UserEntity userEntity,
      List<PostDto> postDtoList) {
    GeoDto geoDto = GeoDto.builder().lat(userEntity.getGeoLat())
        .lng(userEntity.getGeoLng()).build();
    AdderssDto addressDto = AdderssDto.builder()
        .street(userEntity.getAddressStreet())
        .suite(userEntity.getAddressSuite()).city(userEntity.getAddressCity())
        .zipcode(userEntity.getAddressZipcode()).geoDto(geoDto).build();
    CompanyDto companyDto =
        CompanyDto.builder().name(userEntity.getCompanyName())
            .catchPhrase(userEntity.getCompanyCatchPhrase())
            .bs(userEntity.getCompanyBs()).build();

    return AllDataByUserDto.builder().id(userEntity.getUserId())
        .name(userEntity.getName()).username(userEntity.getUsername())
        .email(userEntity.getEmail()).address(addressDto)
        .phone(userEntity.getPhone()).website(userEntity.getWebsite())
        .company(companyDto).posts(postDtoList).build();
  }

  public PostDto mapToPostDto(PostEntity postEntity,
      List<CommentDto> commentDtoList) {
    return PostDto.builder().id(postEntity.getPostId())
        .title(postEntity.getTitle()).body(postEntity.getBody())
        .comments(commentDtoList).build();
  }

  public CommentDto mapToCommentDto(CommentEntity commentEntity) {
    return CommentDto.builder().id(commentEntity.getCommentId())
        .name(commentEntity.getCommentName()).email(commentEntity.getEmail())
        .body(commentEntity.getCommentBody()).build();
  }
}
