package com.blackroot.movie.gallery.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blackroot.movie.gallery.api.entity.PercentDiscount;

@Repository
public interface PercentDiscountRepository extends CrudRepository<PercentDiscount, Integer>{

}
