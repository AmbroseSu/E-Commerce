package com.ambrose.ecommerce.services.impl;

import com.ambrose.ecommerce.config.ResponseUtil;
import com.ambrose.ecommerce.converter.GenericConverter;
import com.ambrose.ecommerce.dto.UserDTO;
import com.ambrose.ecommerce.entities.User;
import com.ambrose.ecommerce.entities.VerificationToken;
import com.ambrose.ecommerce.entities.enums.Role;
import com.ambrose.ecommerce.repository.UserRepository;
import com.ambrose.ecommerce.repository.VerificationTokenRepository;
import com.ambrose.ecommerce.services.UserService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final VerificationTokenRepository tokenRepository;
  //private final TravelReferencesRepository travelReferencesRepository;
  //private final UserTravelReferencesRepository userTravelReferencesRepository;
  private final GenericConverter genericConverter;
  //private final OtpSmsRepository otpSmsRepository;

  @Override
  public UserDetailsService userDetailsService(){
    return new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String username){
        return userRepository.findByLogin(username)
            //.map(UserSignupDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
      }
    };
  }

  @Override
  public void saveUserVerificationToken(User theUser, String token) {
    var verificationToken = new VerificationToken(token, theUser);
    tokenRepository.save(verificationToken);
  }


  @Override
  public String validateToken(String theToken, Long id) {
    VerificationToken token = tokenRepository.findByToken(theToken);
    if(token == null || !token.getUser().getUserId().equals(id)){
      return "Invalid verification token";
    }
    User user = token.getUser();
    Calendar calendar = Calendar.getInstance();
    Long to = token.getExpirationTime().getTime();
    long no = calendar.getTime().getTime();
    //Long time = (token.getTokenExpirationTime().getTime() - calendar.getTime().getTime());
    Long time = (to - no);
    if( time <= 0){
      tokenRepository.delete(token);
      return "Token already expired";
    }
    user.setEnabled(true);
    userRepository.save(user);
    tokenRepository.delete(token);
    return "Valid";
  }




  private void convertListUserToListUserDTO(List<User> users, List<UserDTO> result){
    for(User user : users){
      UserDTO newUserDTO = (UserDTO) genericConverter.toDTO(user, UserDTO.class);
      result.add(newUserDTO);
    }
  }


}
