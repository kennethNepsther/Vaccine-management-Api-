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
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
    public UserModel finByUsernameFetchRoles(String username) {

        UserModel user = userRepository.finByUsernameFetchRoles(username);

        if (Assert.isNull(user)) {
            throw new ObjectNotFoundException("Utilizador Inválido");

        }
        return user;
    }

    @Override
    public void findByUsername(String username) {
        UserModel user = userRepository.findByUsername(username.trim());
        if (Assert.isNotNull(user)) {
            throw new DataIntegrityViolationException("Já  existe um utilizador com este username "+ user.getUsername());
        }

    }

    @Override
    public UserModel create(UserModel user) {
        findByUsername(user.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);

    }

    @Override
    public UserModel update(UserModel user) {
        findById(user.getId());
        findByUsername(user.getUsername());
        UserModel oldData =  findById(user.getId());

        if (!user.getPassword().equals(oldData.getPassword()))
            user.setPassword( new BCryptPasswordEncoder().encode( user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public UserModel updateUserByFields(Long id, Map<String, Object> fields) {
        Optional<UserModel> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(UserModel.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingUser.get(), value);
            });
            return userRepository.save(existingUser.get());
        }
        return null;
    }



    @Override
    public void delete(Long id) {
        findById(id);
        userRepository.deleteById(id);

    }
}
