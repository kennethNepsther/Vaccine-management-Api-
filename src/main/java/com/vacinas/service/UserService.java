package com.vacinas.service;

import com.vacinas.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel findById(Long id);

    List<UserModel> findAll();

    UserModel create(UserModel userModel);

    UserModel update(Long id, UserModel userModel);

    void delete(Long id);
}
