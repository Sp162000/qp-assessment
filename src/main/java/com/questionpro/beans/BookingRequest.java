package com.questionpro.beans;

public class BookingRequest {
   private Integer bookingId;
   private Integer userId;
   private Integer itemId;
   private Long contactNo;
   private String email;
   private Long quantity;

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

   public Integer getBookingId() {
      return this.bookingId;
   }

   public void setBookingId(Integer bookingId) {
      this.bookingId = bookingId;
   }

   public String toString() {
      return "BookingRequest [bookingId=" + this.bookingId + ", userId=" + this.userId + ", itemId=" + this.itemId + ", contactNo=" + this.contactNo + ", email=" + this.email + ", quantity=" + this.quantity + "]";
   }
}
