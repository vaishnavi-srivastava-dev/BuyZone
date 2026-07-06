package com.buyzone.user_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    //A new blank SecurityFilterChain Object is created.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                //Cross Site Request Forgery disabling
                //method chaining
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(

                        auth -> auth
                                //for "/test" endpoint, no auth required.
                                // .requestMatchers("/test").permitAll()
                                .requestMatchers(HttpMethod.GET, "/").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                                //.requestMatchers(HttpMethod.GET, "/**").permitAll()
                                //for all other http requests auth is required
                                .anyRequest().authenticated()
                )
                //httpBasic enables Basic Auth in your program
                .httpBasic(Customizer.withDefaults());

        //build returns a DefaultSecurityFilterChain
        return httpSecurity.build();
    }
}