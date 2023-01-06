package com.vacinas.controller;

import com.vacinas.config.security.jwt.JwtUtil;
import com.vacinas.exception.CredentialInvalidException;
import com.vacinas.exception.UserDisabledException;
import com.vacinas.model.dto.request.AuthenticationRequest;
import com.vacinas.model.dto.response.AuthenticationResponse;
import com.vacinas.service.impl.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    final CustomUserDetailsService userDetailsService;

    final AuthenticationManager authenticationManager;

    final JwtUtil jwtUtil;

    @RequestMapping(value ="/auth" , method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (DisabledException e) {
            throw new UserDisabledException("Utilizador Inativo", e);
        } catch (BadCredentialsException e) {
            throw new CredentialInvalidException("Credenciais inválidas", e);
        }
         UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
         String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

}
