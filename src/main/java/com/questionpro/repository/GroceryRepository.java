package com.questionpro.repository;

import com.questionpro.entity.Grocery;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
   List<Grocery> findByIsactive(Integer isactive);

   Grocery findByItemIdAndIsactive(Integer itemId, Integer isactive);
}
