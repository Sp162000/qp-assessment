package com.questionpro.service;

import com.questionpro.beans.GroceryRequestBean;
import com.questionpro.entity.Grocery;
import com.questionpro.repository.GroceryRepository;
import com.questionpro.util.Constants;
import com.questionpro.util.GroceryServiceException;
import com.questionpro.util.Mapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {

	@Autowired
	private GroceryRepository groceryRepository;

	private ModelMapper mapper = Mapper.getModelMapperInstance();

	public GroceryRequestBean addItem(GroceryRequestBean request) {
		try {
			Grocery grocery = mapper.map(request, Grocery.class);
			grocery.setIsactive(Constants.ISACTIVE);
			grocery = groceryRepository.save(grocery);
			return mapper.map(grocery, GroceryRequestBean.class);
		} catch (Exception var3) {
			throw new GroceryServiceException("Some techincal error occcured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<GroceryRequestBean> index() {
		try {
			List<GroceryRequestBean> response = new ArrayList<GroceryRequestBean>();
			Optional.ofNullable(groceryRepository.findByIsactive(Constants.ISACTIVE)).ifPresentOrElse((groc) -> {
				groc.stream().map((ee) -> mapper.map(ee, GroceryRequestBean.class))
						.collect(Collectors.toCollection(() -> response));
			}, () -> {
				throw new GroceryServiceException("No active items found", HttpStatus.NOT_FOUND);
			});
			return response;
		} catch (Exception e) {
			throw new GroceryServiceException("Some techincal error occcured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public void deleteItem(Integer itemId) {
		try {
			Optional.ofNullable(groceryRepository.findByItemIdAndIsactive(itemId, Constants.ISACTIVE))
					.ifPresentOrElse((groc) -> {
						groc.setIsactive(0);
						groceryRepository.save(groc);
					}, () -> {
						throw new GroceryServiceException("No active items found for itemId: " + itemId,
								HttpStatus.NOT_FOUND);
					});
		} catch (Exception e) {
			throw new GroceryServiceException("Some techincal error occcured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public GroceryRequestBean updateItem(Integer itemId, GroceryRequestBean request) {
		try {
			GroceryRequestBean response = new GroceryRequestBean();
			Optional.ofNullable(groceryRepository.findByItemIdAndIsactive(itemId, Constants.ISACTIVE))
					.ifPresentOrElse((groc) -> {
						mapper.map(request, groc);
						groc = groceryRepository.save(groc);
						mapper.map(groc, response);
					}, () -> {
						throw new GroceryServiceException("No active items found for itemId: " + itemId,
								HttpStatus.NOT_FOUND);
					});
			return response;
		} catch (Exception e) {
			throw new GroceryServiceException("Some techincal error occcured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
