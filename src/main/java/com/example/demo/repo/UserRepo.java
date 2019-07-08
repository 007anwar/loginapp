package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Uuser;

public interface UserRepo extends CrudRepository<Uuser, Integer> {

}
