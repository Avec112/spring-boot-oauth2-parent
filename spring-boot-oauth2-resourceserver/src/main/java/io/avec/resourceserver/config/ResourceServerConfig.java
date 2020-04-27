package io.avec.resourceserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .mvcMatcher("/**")
                .authorizeRequests() // scope authorization. Will give 403 if scope not specified in Token
//                .mvcMatchers("/**").access("hasAuthority('SCOPE_message.read')")
                .mvcMatchers("/**").authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
    }
}
