package com.ambrose.ecommerce.services;


import com.ambrose.ecommerce.dto.request.RefreshTokenRequest;
import com.ambrose.ecommerce.dto.request.SignUp;
import com.ambrose.ecommerce.dto.request.SigninRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
  ResponseEntity<?> signin(SigninRequest signinRequest);

  ResponseEntity<?> signinGoogle(String email);
  ResponseEntity<?> refreshToken(RefreshTokenRequest refreshTokenRequest);

  public ResponseEntity<?> checkEmail(String email);
  public String checkResetVerifyToken(String email, Long id);
  public ResponseEntity<?> saveInfor(SignUp signUp);
  //public ResponseEntity<?> saveInforGoogle(SignUpGoogle signUpGoogle);
}
