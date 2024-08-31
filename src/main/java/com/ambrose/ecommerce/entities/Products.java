package com.ambrose.ecommerce.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "tbl_products")
public class Products {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;
  private String name;
  private String description;
  private Float price;
  private String image;
  private boolean isDelete;

  @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
  private List<CartItems> cartItems;
  @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
  private List<Inventory> inventories;
  @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
  private List<OrderDetails> orderDetails;
  @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
  private List<Returns> returns;
  @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
  private List<ProductImages> productImages;
  @ManyToOne
  @JoinColumn(name = "productCategoryId")
  private ProductCategories productCategories;
}
