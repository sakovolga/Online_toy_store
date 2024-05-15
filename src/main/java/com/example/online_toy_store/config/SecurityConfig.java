//package com.example.online_toy_store.config;
//
//import com.example.online_toy_store.security.jwt.JwtTokenProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static com.example.online_toy_store.security.securityUtil.AuthorityList.*;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig{
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    private static final String ADMIN_ENDPOINT = "/api/v1/admin/**";
//    private static final String LOGIN_ENDPOINT = "/api/v1/auth/login";
//
//    @Autowired
//    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return authenticationManagerBean();
//    }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors.disable
//                .csrf.disable
//                .authorizeHttpRequests(auth ->
//                        auth
//                                .requestMatchers(CUSTOMER_LIST).hasRole(CUSTOMER)
//                                .requestMatchers(ADMIN_LIST).hasRole(ADMIN)
//                                .requestMatchers(MANAGER_LIST).hasRole(MANAGER)
//                                .requestMatchers(SUPER_MANAGER_LIST).hasRole(SUPER_MANAGER)
//
//                                .anyRequest().authenticated())
//
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//    }
//}
