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
@Table(name = "tbl_inventory")
public class Inventory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long inventoryId;
  private Date manufactureDate;
  private Date expiryDate;
  private boolean isDelete;

  @ManyToOne
  @JoinColumn(name = "productsId")
  private Products products;
  @ManyToOne
  @JoinColumn(name = "warehouseId")
  private Warehouse warehouse;
}
