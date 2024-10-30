package com.questionpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(
   name = "booking",
   schema = "Grocery_items"
)
public class Booking {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Integer bookingId;
   private Integer userId;
   private Integer itemId;
   @Max(
      value = 10L,
      message = "contactNo cannot exceed more than size 10"
   )
   private Long contactNo;
   @Email
   private String email;
   @Min(
      value = 0L,
      message = "quantity cannot be less then 0"
   )
   private Long quantity;
   @CreationTimestamp
   private Timestamp createdAt;
   @UpdateTimestamp
   private Timestamp updatedAt;
   private Integer isactive;

   public Integer getBookingId() {
      return this.bookingId;
   }

   public void setBookingId(Integer bookingId) {
      this.bookingId = bookingId;
   }

   public Integer getUserId() {
      return this.userId;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public Integer getItemId() {
      return this.itemId;
   }

   public void setItemId(Integer itemId) {
      this.itemId = itemId;
   }

   public Long getContactNo() {
      return this.contactNo;
   }

   public void setContactNo(Long contactNo) {
      this.contactNo = contactNo;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Long getQuantity() {
      return this.quantity;
   }

   public void setQuantity(Long quantity) {
      this.quantity = quantity;
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
      return "Booking [bookingId=" + this.bookingId + ", userId=" + this.userId + ", itemId=" + this.itemId + ", contactNo=" + this.contactNo + ", email=" + this.email + ", quantity=" + this.quantity + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isactive=" + this.isactive + "]";
   }
}
