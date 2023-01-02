package com.vacinas.service;

import com.vacinas.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel findById(Long id);

    List<UserModel> findAll();

    UserModel finByUsernameFetchRoles(String username);

    void findByUsername(String username);

    UserModel create(UserModel userModel);

    UserModel update(UserModel userModel);

    void delete(Long id);
}
