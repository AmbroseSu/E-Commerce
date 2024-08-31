package com.ambrose.ecommerce.entities;

import com.ambrose.ecommerce.entities.enums.PaymentMethod;
import com.ambrose.ecommerce.entities.enums.PaymentStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_payments")
public class Payments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymentId;
  private Date paymentDate;
  private Float totalAmount;
  private PaymentMethod paymentMethod;
  private PaymentStatus paymentStatus;
  private boolean isDelete;
  @OneToOne(mappedBy = "payments", cascade = CascadeType.ALL)
  private Orders orders;
}
