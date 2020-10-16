package com.blackroot.movie.gallery.api.service;

import org.springframework.http.ResponseEntity;

import com.blackroot.movie.gallery.api.dto.Sale;
import com.blackroot.movie.gallery.api.utils.ServiceResponse;

public interface ShoppingService {

	public abstract ResponseEntity<ServiceResponse> sale(Sale sales);
}
