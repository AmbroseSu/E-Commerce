package com.ambrose.ecommerce.entities;

import com.ambrose.ecommerce.entities.enums.Gender;
import com.ambrose.ecommerce.entities.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@ToString
@Entity
@Table(name = "tbl_user")
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
  private String fullname;
  private String login;
  private String address;
  private String email;
  private String password;
  private String phone;
  private String image;
  private String status;
  private Gender gender;
  private Role role;
  private String fcm;
  private boolean isDelete;
  @OneToMany(mappedBy = "shipper", cascade = CascadeType.ALL)
  private List<Delivery> deliveries;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Orders> orders;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Returns> returns;
  @OneToOne
  @JoinColumn(name = "cartId")
  private Cart cart;
  @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
  private List<Message> messages;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<UserChat> userChats;
  private boolean isEnabled = false;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getUsername() {
    return login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return isEnabled;
  }
}
