package com.example.exercise2.demo_exercise2.mapper;

import org.springframework.stereotype.Component;
import com.example.exercise2.demo_exercise2.entity.UserEntity;
import com.example.exercise2.demo_exercise2.model.User;

@Component
public class UserEntityMapper {

  public UserEntity map(User user) {
    return UserEntity.builder().userId(user.getUserId()).name(user.getName())
        .username(user.getUsername()).email(user.getEmail())
        .addressStreet(user.getAddress().getStreet())
        .addressSuite(user.getAddress().getSuite())
        .addressCity(user.getAddress().getCity())
        .addressZipcode(user.getAddress().getZipcode())
        .geoLat(user.getAddress().getGeo().getLat())
        .geoLng(user.getAddress().getGeo().getLng()).phone(user.getPhone())
        .website(user.getWebsite()).companyName(user.getCompany().getName())
        .companyCatchPhrase(user.getCompany().getCatchPhrase())
        .companyBs(user.getCompany().getBs()).build();
  }
}
