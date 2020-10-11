package com.blackroot.movie.gallery.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blackroot.movie.gallery.api.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
