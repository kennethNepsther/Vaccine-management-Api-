package com.vacinas.config.security;

import com.vacinas.exception.DataIntegrityViolationException;
import com.vacinas.model.User;
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

        User existsUser = userRepository.finByUsernameFetchRoles(username);

        //User existsUser = userRepository.findByUsername(username);
        if (existsUser == null) {
            throw new DataIntegrityViolationException("Não existe este utilizador");
        }
        return UserPrincipal.create(existsUser);
    }
}
