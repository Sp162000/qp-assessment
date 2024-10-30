package com.questionpro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.questionpro.beans.BookingRequest;
import com.questionpro.beans.GroceryRequestBean;
import com.questionpro.beans.UserRequest;
import com.questionpro.entity.Booking;
import com.questionpro.entity.User;
import com.questionpro.repository.BookingRepository;
import com.questionpro.repository.GroceryRepository;
import com.questionpro.repository.UserRepository;
import com.questionpro.util.Constants;
import com.questionpro.util.GroceryServiceException;
import com.questionpro.util.Mapper;

@Service
public class UserServiceImpl {
   
	@Autowired
   private GroceryRepository groceryRepository;
   
   @Autowired
   private BookingRepository bookingRepository;
   
   @Autowired
   private UserRepository userRepository;
   
   private ModelMapper mapper = Mapper.getModelMapperInstance();

   public List<GroceryRequestBean> index() {
      try {
         List<GroceryRequestBean> response = new ArrayList();
         Optional.ofNullable(groceryRepository.findByIsactive(Constants.ISACTIVE)).ifPresentOrElse((groc) -> {
            groc.stream().map((ee) -> mapper.map(ee, GroceryRequestBean.class)).collect(Collectors.toCollection(()->response));
         }, () -> {
            throw new GroceryServiceException("No active items found", HttpStatus.NOT_FOUND);
         });
         return response;
      } catch (Exception e) {
         throw new GroceryServiceException("Some techincal error occcured", HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

   public List<BookingRequest> bookItems(List<BookingRequest> request) {
      try {
         List<Booking> bookings = request.stream().map((req) ->mapper.map(req, Booking.class)).collect(Collectors.toList());
         bookings=bookingRepository.saveAll(bookings);
         return bookings.stream().map((save) -> mapper.map(save, BookingRequest.class)).collect(Collectors.toList());
      } catch (Exception e) {
         throw new GroceryServiceException("Some techincal error occcured", HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

   public UserRequest createUser(UserRequest request) {
      try {
         User user = mapper.map(request, User.class);
         user.setIsactive(Constants.ISACTIVE);
         user = userRepository.save(user);
         return mapper.map(user, UserRequest.class);
      } catch (Exception e) {
         throw new GroceryServiceException("Some techincal error occcured", HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
}
