package com.example.Rentit.hello;

import org.springframework.data.repository.CrudRepository;

import com.example.Rentit.hello.User;

//this will be auto implemented by the spring into the bean named userRepository

public interface UserRepository extends CrudRepository<User, Integer> {

}
