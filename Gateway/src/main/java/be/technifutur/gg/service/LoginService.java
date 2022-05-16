package be.technifutur.gg.service;

import be.technifutur.gg.config.JWTProperties;
import be.technifutur.gg.form.LoginForm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {

    private final AuthenticationManager authManager;
    private final JWTProperties properties;

    public LoginService(AuthenticationManager authManager, JWTProperties properties) {
        this.authManager = authManager;
        this.properties = properties;
    }

    public String login(LoginForm form){
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        authentication = authManager.authenticate(authentication);
        return properties.getPrefix() + JWT.create()
                .withSubject(form.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+properties.getExpires())) //expire dans 1 jour
                .withClaim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .sign((Algorithm.HMAC512(properties.getSecret())));



    }



}
