package com.indeas.auth.controller;

import java.util.HashMap;
import java.util.Map;

import com.indeas.auth.data.vo.UserVO;
import com.indeas.auth.jwt.JwtTokenProvider;
import com.indeas.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/testeSecurity")
    public String teste() {
        return "Autenticado";
    }

    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
            "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<?> login(@RequestBody UserVO userVO) {
        try {
            var username = userVO.getUserName();
            var password = userVO.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            var user = userRepository.findByUserName(username);

            var token = "";

            if (user != null) {
                token = jwtTokenProvider.createToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("User name not found");
            }

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ResponseEntity.ok(model);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Ivalid username/password");
        }
    }

}
