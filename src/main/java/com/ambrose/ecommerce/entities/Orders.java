package com.ambrose.ecommerce.entities;

import com.ambrose.ecommerce.entities.enums.OrdersStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_orders")
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;
  private Date orderDate;
  private OrdersStatus ordersStatus;
  private Float totalAmount;
  private boolean isDelete;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
  @OneToOne(mappedBy = "orders", cascade = CascadeType.ALL)
  private Delivery delivery;
  @OneToOne
  @JoinColumn(name = "paymentsId")
  private Payments payments;
  @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
  private List<Returns> returns;
  @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
  private List<OrderDetails> orderDetails;
}
