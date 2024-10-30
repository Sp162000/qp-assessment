package com.questionpro.beans;

public class UserRequest {
   private Integer userId;
   private String fisrtName;
   private String lastName;

   public Integer getUserId() {
      return this.userId;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public String getFisrtName() {
      return this.fisrtName;
   }

   public void setFisrtName(String fisrtName) {
      this.fisrtName = fisrtName;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String toString() {
      return "UserRequest [userId=" + this.userId + ", fisrtName=" + this.fisrtName + ", lastName=" + this.lastName + "]";
   }
}
