//package com.unibanktask.unibank.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                        (authorize) ->
////                                authorize.anyRequest().authenticated()
//                                authorize.requestMatchers(HttpMethod.GET, "/register/api/v1/**").permitAll()
//                                        .anyRequest().authenticated()
//                ).httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
//}