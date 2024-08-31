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
@Table(name = "tbl_cart_items")
public class CartItems {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cartItemId;
  private int quantity;
  private Date addedAt;
  private boolean isDelete;

  @ManyToOne
  @JoinColumn(name = "cartId")
  private Cart cart;
  @ManyToOne
  @JoinColumn(name = "productsId")
  private Products products;
}
