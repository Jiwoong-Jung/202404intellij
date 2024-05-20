package com.sky._sb0520_2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky._sb0520_2.member.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.PrintWriter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MyUserDetailsService myUserDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrfConfig) ->
                        csrfConfig.disable()
                ) // 1번
                .headers((headerConfig) ->
                        headerConfig.frameOptions(frameOptionsConfig ->
                                frameOptionsConfig.disable()
                        )
                )// 2번
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
//                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers("/", "/login/**", "/error/**").permitAll()
                                .requestMatchers("/posts/**", "/api/v1/posts/**").hasRole(Role.USER.name())
                                .requestMatchers("/admins/**", "/api/v1/admins/**").hasRole(Role.ADMIN.name())
                                .anyRequest().authenticated()
                )// 3번
                .exceptionHandling((exceptionConfig) ->
                        exceptionConfig.authenticationEntryPoint(unauthorizedEntryPoint).accessDeniedHandler(accessDeniedHandler)
                ) // 401 403 관련 예외처리
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/login/login") // 1번
                                .usernameParameter("username") // 2번
                                .passwordParameter("password") // 3번
                                .loginProcessingUrl("/login/login-proc") // 4번
                                .defaultSuccessUrl("/", true) // 5번
                )
                .logout((logoutConfig) ->
                        logoutConfig.logoutSuccessUrl("/") // 6번
                )
                .userDetailsService(myUserDetailsService); // 7번

        return http.build();
    }

    public final AuthenticationEntryPoint unauthorizedEntryPoint =
    (request, response, authException) -> {
        response.sendRedirect("/error/unauthorized.html");
    };
        //     (request, response, authException) -> {
        //         ErrorResponse fail = new ErrorResponse(HttpStatus.UNAUTHORIZED, "Spring security unauthorized...");
        //         response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //         String json = new ObjectMapper().writeValueAsString(fail);
        //         response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //         PrintWriter writer = response.getWriter();
        //         writer.write(json);
        //         writer.flush();
        //     };

    public  final AccessDeniedHandler accessDeniedHandler =
    (request, response, accessDeniedException) -> {
        response.sendRedirect("/error/accessDenied.html");
    };
        //     (request, response, accessDeniedException) -> {
        //         ErrorResponse fail = new ErrorResponse(HttpStatus.FORBIDDEN, "Spring security forbidden...");
        //         response.setStatus(HttpStatus.FORBIDDEN.value());
        //         String json = new ObjectMapper().writeValueAsString(fail);
        //         response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //         PrintWriter writer = response.getWriter();
        //         writer.write(json);
        //         writer.flush();
        //     };

    @Getter
    @RequiredArgsConstructor
    public class ErrorResponse {

        private final HttpStatus status;
        private final String message;
    }
}
