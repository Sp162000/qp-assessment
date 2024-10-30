package com.questionpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(
   name = "user",
   schema = "Grocery_items"
)
public class User {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Integer userId;
   @Column(
      name = "fisrt_name"
   )
   private String fisrtName;
   @Column(
      name = "last_name"
   )
   private String lastName;
   @CreationTimestamp
   @Column(
      name = "created_at"
   )
   private Timestamp createdAt;
   @UpdateTimestamp
   @Column(
      name = "updated_at"
   )
   private Timestamp upatedAt;
   private Integer isactive;

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

   public Timestamp getCreatedAt() {
      return this.createdAt;
   }

   public void setCreatedAt(Timestamp createdAt) {
      this.createdAt = createdAt;
   }

   public Timestamp getUpatedAt() {
      return this.upatedAt;
   }

   public void setUpatedAt(Timestamp upatedAt) {
      this.upatedAt = upatedAt;
   }

   public Integer getIsactive() {
      return this.isactive;
   }

   public void setIsactive(Integer isactive) {
      this.isactive = isactive;
   }

   public String toString() {
      return "User [userId=" + this.userId + ", fisrtName=" + this.fisrtName + ", lastName=" + this.lastName + ", createdAt=" + this.createdAt + ", upatedAt=" + this.upatedAt + ", isactive=" + this.isactive + "]";
   }
}
