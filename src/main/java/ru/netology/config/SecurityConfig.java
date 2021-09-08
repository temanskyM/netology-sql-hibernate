package ru.netology.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final String ADMIN_ROLE = "ADMIN";
    private final String USER_ROLE = "USER";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles(ADMIN_ROLE)
                .and()
                .withUser("user").password("{noop}user").roles(USER_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/hello").anonymous()
                .antMatchers("/api/secret").hasRole(ADMIN_ROLE)
                .antMatchers("/api/**").authenticated()
                .and()
                .formLogin();
    }
}
