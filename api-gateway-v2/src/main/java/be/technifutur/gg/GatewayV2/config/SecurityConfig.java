package be.technifutur.gg.GatewayV2.config;


//import be.technifutur.gg.GatewayV2.filter.DummyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
//import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
//import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.config.EnableWebFlux;
//
@Configuration
//@EnableWebFlux
//@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http, DummyFilter filter){
//            http.csrf().disable();
//
//            http.httpBasic();
//
//            http.addFilterBefore(filter, SecurityWebFiltersOrder.AUTHENTICATION);
//
//            http.authorizeExchange().pathMatchers("/actuator/health").permitAll()
//                    .pathMatchers(HttpMethod.POST).authenticated().anyExchange().permitAll();
//
//
//
//            return http.build();
//    }

//    @Bean
//    public ReactiveUserDetailsService userDetailsService(PasswordEncoder encoder){
//        User.UserBuilder builder = User.builder();
//
//        UserDetails user = builder.username("user")
//                .password(encoder.encode("pass"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = builder.username("admin")
//                .password(encoder.encode("pass"))
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new MapReactiveUserDetailsService(user,admin);
//    }
//
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
//
//
}
