package com.myodoctor.finalproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()

                    .antMatchers("/anonymous*").anonymous()
                    .antMatchers("/").permitAll()
                    .antMatchers("/users/signUp").permitAll()
//                    .antMatchers("/users/createCandidate").permitAll()
//                    .antMatchers("/users/getRegistered").permitAll()
//                    .antMatchers("/users/saveStaff").permitAll()
//                    .antMatchers("/login").permitAll()
//
//                    .antMatchers("/users/viewCandidate").hasRole("Admin")
//                    .antMatchers("/static/*").permitAll()
//
//                    .antMatchers("/roles/addRole/{id}").hasRole("Admin")
//                    .antMatchers("roles/assignRole").hasRole("Admin")
//                    .antMatchers("/users/CreateStaff").hasRole("Admin")
//                    .antMatchers("/users/saveStaff").hasRole("Admin")
//                    .antMatchers("/users/listCandidates").hasRole("Admin")
//                    .antMatchers("/viewAllCandidate").hasRole("Admin")
//                    .antMatchers("/viewAllCandidate").hasRole("Admin")
//                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
//                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .and()
                    .logout()
                    .deleteCookies("JSESSIONID");
            //.logoutSuccessHandler(logoutSuccessHandler());
        }
        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    .antMatchers("/static/**", "/css/**", "/js/**", "/images/**", "/jquery/**");
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
