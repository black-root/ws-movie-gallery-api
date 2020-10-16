package com.blackroot.movie.gallery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackroot.movie.gallery.api.dto.Sale;
import com.blackroot.movie.gallery.api.service.ShoppingcarServiceImpl;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

	@Autowired
	private ShoppingcarServiceImpl shoppingcarService;
	
	@PostMapping
	public ResponseEntity<ServiceResponse> sale(@RequestBody Sale sales){
		return shoppingcarService.sale(sales);
	}
}
