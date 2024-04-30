package com.example.online_toy_store.configuration;

import com.example.online_toy_store.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
=======
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
=======
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

<<<<<<< HEAD
import static com.example.online_toy_store.security.securityUtil.AuthorityList.*;
=======
import static com.example.online_toy_store.security.secutiry_util.RoleAuthList.*;
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
<<<<<<< HEAD
    public PasswordEncoder passwordEncoder(){
=======
    public PasswordEncoder passwordEncoder() {
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
        return new BCryptPasswordEncoder();
    }

    @Bean
<<<<<<< HEAD
    public AuthenticationProvider getAuthenticationProvider(){
=======
    public AuthenticationProvider getAuthProvider() {
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
<<<<<<< HEAD
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
=======
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
        return http
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(CUSTOMER_LIST).hasRole(CUSTOMER)
                                .requestMatchers(ADMIN_LIST).hasRole(ADMIN))
                .formLogin(Customizer.withDefaults())
                .build();
<<<<<<< HEAD

    }
}
=======
    }
}
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
