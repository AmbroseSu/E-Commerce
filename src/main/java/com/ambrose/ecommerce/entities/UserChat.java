package com.ambrose.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_user_chat")
@IdClass(UserChatKey.class)
public class UserChat {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long userChatId;

  @Id
  private Long chatId;

  @Id
  private Long userId;


  @ManyToOne
  @JoinColumn(name = "chatId", nullable = false)
  private Chats chat;


  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;

}
