package com.vacinas.service.impl;

import com.vacinas.model.UserModel;
import com.vacinas.model.UserPrincipal;
import com.vacinas.service.UserService;
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

    final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel existsUserModel = userService.finByUsernameFetchRoles(username);
        return UserPrincipal.create(existsUserModel);
    }
}
