package com.ambrose.ecommerce.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_cart")
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cartId;
  private Date createAt;
  private Date updateAt;
  private boolean isDelete;

  @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
  private User user;
  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
  private List<CartItems> cartItems;
}
