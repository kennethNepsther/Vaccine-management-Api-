package com.vacinas.service.impl;

import com.vacinas.exception.DataIntegrityViolationException;
import com.vacinas.exception.ObjectNotFoundException;
import com.vacinas.model.User;
import com.vacinas.repository.UserRepository;
import com.vacinas.service.UserService;
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
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado  objecto com o indetificador " + id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        User existsUser = userRepository.findByUsername(user.getUsername().trim());
        if (existsUser != null) {
            throw new DataIntegrityViolationException("Já existe utilizador com este username");
        }
        user.setId(null);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }


    @Override
    public void delete(Long id) {
        findById(id);
        userRepository.deleteById(id);

    }
}
