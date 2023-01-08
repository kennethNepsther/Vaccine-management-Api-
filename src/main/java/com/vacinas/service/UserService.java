package com.vacinas.service;

import com.vacinas.model.UserModel;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface UserService {

    UserModel findById(Long id);

    List<UserModel> findAll();

    UserModel finByUsernameFetchRoles(String username);

    void findByUsername(String username);

    @Transactional
    UserModel create(UserModel userModel);

    UserModel update(UserModel userModel);

    UserModel updateUserByFields(Long id, Map<String,Object> fields);

    void delete(Long id);
}
