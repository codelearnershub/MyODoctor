package com.myodoctor.finalproject.security;

import com.myodoctor.finalproject.models.LoggedInUser.ActiveUserStore;
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
                .antMatchers("/index").permitAll()
                .antMatchers("/users/signUp").permitAll()
                .antMatchers("/PatientView/allPatientPage").permitAll()
                .antMatchers("/PatientView/createPatient").permitAll()
                .antMatchers("/patient/create").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/patients/create").permitAll()
                .antMatchers("/patients/allPatients").permitAll()
                .antMatchers("/role/createRole").permitAll()
                .antMatchers("/roles/saveRole").permitAll()
                .antMatchers("role/allRoles").permitAll()
//                    .antMatchers("/users/saveStaff").hasRole("Admin")
//                    .antMatchers("/users/listCandidates").hasRole("Admin")
//                    .antMatchers("/viewAllCandidate").hasRole("Admin")
//                    .antMatchers("/viewAllCandidate").hasRole("Admin")
//                    .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
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

    @Bean
    public ActiveUserStore activeUserStore(){
        return new ActiveUserStore();
    }

}
