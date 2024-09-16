package com.ambrose.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_message")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long messageId;
  private String content;
  private Date sendAt;
  private boolean isDelete;
  private boolean isSend;
  private boolean isDelivered;
  private boolean isRead;

  @ManyToOne
  @JoinColumn(name = "senderId")
  private User sender;
  @ManyToOne
  @JoinColumn(name = "chatId")
  private Chats chat;
}
