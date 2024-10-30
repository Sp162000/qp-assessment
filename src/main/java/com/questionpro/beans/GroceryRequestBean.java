package com.questionpro.beans;

public class GroceryRequestBean {
   private Integer itemId;
   private String name;
   private Double price;
   private Long quantity;

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

   public Long getQuantity() {
      return this.quantity;
   }

   public void setQuantity(Long quantity) {
      this.quantity = quantity;
   }

   public Integer getItemId() {
      return this.itemId;
   }

   public void setItemId(Integer itemId) {
      this.itemId = itemId;
   }

   public String toString() {
      return "GroceryRequestBean [itemId=" + this.itemId + ", name=" + this.name + ", price=" + this.price + ", quantity=" + this.quantity + "]";
   }
}
