package com.ambrose.ecommerce.dto.response;

import com.ambrose.ecommerce.dto.UserDTO;
import lombok.Data;

@Data
public class JwtAuthenticationResponse {
  private UserDTO userDTO;
  private String token;
  private String refreshToken;
}
