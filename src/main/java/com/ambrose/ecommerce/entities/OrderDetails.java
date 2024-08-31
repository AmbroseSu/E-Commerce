package com.ambrose.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_order_details")
public class OrderDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderDetailId;
  private int quantity;
  private Float price;
  private boolean isDelete;

  @ManyToOne
  @JoinColumn(name = "ordersId")
  private Orders orders;
  @ManyToOne
  @JoinColumn(name = "productsId")
  private Products products;
}
