package com.ambrose.ecommerce.entities;

import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserChatKey implements Serializable {
  private Long chatId;
  private Long userId;

//  public UserChatKey() {}
//
//  public UserChatKey(Long chatId, Long userId) {
//    this.chatId = chatId;
//    this.userId = userId;
//  }

  // Getters and Setters

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserChatKey that = (UserChatKey) o;
    return Objects.equals(chatId, that.chatId) &&
        Objects.equals(userId, that.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chatId, userId);
  }
}
