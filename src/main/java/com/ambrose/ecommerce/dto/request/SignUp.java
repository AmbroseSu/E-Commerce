package com.ambrose.ecommerce.dto.request;


import com.ambrose.ecommerce.entities.enums.Gender;
import com.ambrose.ecommerce.entities.enums.Role;
import lombok.Data;

@Data
public class SignUp {
  String email;
  String fullname;
  String phone;
  String password;
  String address;
  Gender gender;
  String fcmtoken;
}
