package com.questionpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(
   name = "grocery",
   schema = "Grocery_items"
)
public class Grocery {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Integer itemId;
   @NotNull(
      message = "name is mandatory"
   )
   private String name;
   @Min(
      value = 0L,
      message = "price cannot be less then 0.0"
   )
   private Double price;
   @CreationTimestamp
   private Timestamp createdAt;
   @UpdateTimestamp
   private Timestamp updatedAt;
   private Integer isactive;

   public Integer getItemId() {
      return this.itemId;
   }

   public void setItemId(Integer itemId) {
      this.itemId = itemId;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Double getPrice() {
      return this.price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public Timestamp getCreatedAt() {
      return this.createdAt;
   }

   public void setCreatedAt(Timestamp createdAt) {
      this.createdAt = createdAt;
   }

   public Timestamp getUpdatedAt() {
      return this.updatedAt;
   }

   public void setUpdatedAt(Timestamp updatedAt) {
      this.updatedAt = updatedAt;
   }

   public Integer getIsactive() {
      return this.isactive;
   }

   public void setIsactive(Integer isactive) {
      this.isactive = isactive;
   }

   public String toString() {
      return "Grocery [itemId=" + this.itemId + ", name=" + this.name + ", price=" + this.price + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isactive=" + this.isactive + "]";
   }
}
