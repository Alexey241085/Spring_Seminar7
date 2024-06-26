package ru.gb.example_homework4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @EnableWebSecurity класс будет применен к глобальной WEB безопасности
 * в месте с @Configuration - используются для настройки WEB Security
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class configSecurity {

    @Bean
    public UserDetailsService userDetailsService (PasswordEncoder encoder){
        UserDetails admin = User.builder().username("admin").password(encoder.encode("password")).roles("ADMIN", "USER").build();
        UserDetails user = User.builder().username("user").password(encoder.encode("password")).roles("USER").build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/images/**").permitAll()
                .requestMatchers("users/auth").permitAll()
                .requestMatchers("users/**").authenticated())
                .formLogin(form->form
                        .loginPage("/users/auth")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/users/index", true)
                        .permitAll()).
                logout(l->l.logoutSuccessUrl("/users/auth"))

                .build();


//        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }





}
