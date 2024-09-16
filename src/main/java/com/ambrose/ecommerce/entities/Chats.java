package com.ambrose.ecommerce.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_chats")
public class Chats {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long chatId;
  private String name;
  private Date createAt;
  private boolean isDelete;

  @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
  private List<Message> messages;
  @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
  private List<UserChat> userChats;
}
