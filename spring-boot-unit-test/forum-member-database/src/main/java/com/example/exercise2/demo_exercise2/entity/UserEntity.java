package com.example.exercise2.demo_exercise2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserEntity {

  @Id
  private Integer userId;
  private String name;
  private String username;
  private String email;
  private String addressStreet;
  private String addressSuite;
  private String addressCity;
  private String addressZipcode;
  private String geoLat;
  private String geoLng;
  private String phone;
  private String website;
  private String companyName;
  private String companyCatchPhrase;
  private String companyBs;
}
