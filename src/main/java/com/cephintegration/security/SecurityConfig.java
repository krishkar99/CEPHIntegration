//package com.cephintegration.security;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
////@Configuration
////@EnableWebSecurity
////@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/public/v1/users", "/public/v1/login")
//                .permitAll()
//                .requestMatchers("/swagger-ui/**/**", "/v3/**/**")
//                .permitAll().and().build();
////                .and()
////                .authorizeHttpRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().build();
////                .and()
////                .authenticationProvider(authenticationProvider())
////                .build();
//
//        //        http
//        //                .authorizeHttpRequests((auth) -> {
//        //
//        //                            try {
//        //                                http
//        //                                        .authorizeHttpRequests((authz) -> {
//        //                                                    try {
//        //                                                        authz
//        //                                                                .anyRequest().permitAll()
//        //                                                                .and().csrf().disable();
//        //                                                    } catch (Exception e) {
//        //                                                        throw new RuntimeException(e);
//        //                                                    }
//        //                                                }
//        //                                        );
//        //                            } catch (Exception e) {
//        //                                throw new RuntimeException(e);
//        //                            }
//        //
//        //                        }
//        //                );
//        //        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
//            throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
//                .components(
//                        new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()));
//    }
//
//    private SecurityScheme createAPIKeyScheme() {
//        return new SecurityScheme().type(SecurityScheme.Type.HTTP).bearerFormat("JWT").scheme("bearer");
//    }
//}
