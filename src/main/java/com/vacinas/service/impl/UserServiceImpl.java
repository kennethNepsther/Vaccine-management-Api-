package com.vacinas.service.impl;

import com.vacinas.exception.DataIntegrityViolationException;
import com.vacinas.exception.ObjectNotFoundException;
import com.vacinas.model.UserModel;
import com.vacinas.repository.UserRepository;
import com.vacinas.service.UserService;
import com.vacinas.util.Assert;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;


    @Override
    public UserModel findById(Long id) {
        if(Assert.isNull(id)) {
            throw new NullPointerException("O id  é obrigatorio");
        }
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado  objecto com o indetificador " + id));
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel create(UserModel userModel) {
        UserModel existsUserModel = userRepository.findByUsername(userModel.getUsername().trim());
        if (existsUserModel != null) {
            throw new DataIntegrityViolationException("Já existe utilizador com este username");
        }

        userModel.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        return userRepository.save(userModel);

    }

    @Override
    public UserModel update(Long id, UserModel userModel) {
        return null;
    }


    @Override
    public void delete(Long id) {
        findById(id);
        userRepository.deleteById(id);

    }
}
