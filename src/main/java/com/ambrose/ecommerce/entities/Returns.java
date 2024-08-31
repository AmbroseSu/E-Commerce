package com.ambrose.ecommerce.entities;

import com.ambrose.ecommerce.entities.enums.ReturnStatus;
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
@Table(name = "tbl_returns")
public class Returns {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long returnId;
  private Date returnDate;
  private int quantity;
  private Date manufactureDate;
  private Date expiryDate;
  private String reason;
  private ReturnStatus returnStatus;
  private boolean isDelete;

  @ManyToOne
  @JoinColumn(name = "ordersId")
  private Orders orders;
  @ManyToOne
  @JoinColumn(name = "productsId")
  private Products products;
  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}
