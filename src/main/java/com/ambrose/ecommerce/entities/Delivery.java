package com.ambrose.ecommerce.entities;

import com.ambrose.ecommerce.entities.enums.DeliveryStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Timer;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_delivery")
public class Delivery {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long deliveryId;
  private Date deliveryDate;
  private String deliveryAddress;
  private DeliveryStatus deliveryStatus;
  private String currentLocation;
  private String estimatedDeliveryTime;
  private boolean isDelete;
  @OneToOne
  @JoinColumn(name = "orderId")
  private Orders orders;
  @ManyToOne
  @JoinColumn(name = "userId")
  private User shipper;
}
