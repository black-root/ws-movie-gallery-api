package com.blackroot.movie.gallery.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blackroot.movie.gallery.api.entity.User;
import com.blackroot.movie.gallery.api.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	public UserEntity findByEmail(String email);
}
