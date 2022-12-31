package com.vacinas.service;

import com.vacinas.model.UserModel;
import com.vacinas.model.UserPrincipal;
import com.vacinas.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel existsUserModel = userRepository.finByUsernameFetchRoles(username);

        //UserModel existsUserModel = userRepository.findByUsername(username);
        if (existsUserModel == null) {
            throw new NullPointerException("Não existe este utilizador");
        }
        return UserPrincipal.create(existsUserModel);
    }
}
