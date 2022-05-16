package be.technifutur.gg.config;

import be.technifutur.gg.security.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(
        jsr250Enabled = true,
        securedEnabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;
    private final JWTProperties jwtProperties;

    public SecurityConfig(PasswordEncoder encoder, JWTProperties jwtProperties) {
        this.encoder = encoder;
        this.jwtProperties = jwtProperties;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("pass")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("pass")).roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Desactivation du Cross site Request Forgery
        http.csrf()
                .disable();

        // Définition de sécurité pour le point d'entrée
        http.authorizeRequests()
                .anyRequest().permitAll();

        //Gestion des filtres
        http.addFilterBefore(new JWTAuthenticationFilter(jwtProperties), UsernamePasswordAuthenticationFilter.class);

        // Assurer l'aspect STATELESS
            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // H2
        http.headers()
                .frameOptions().disable();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
