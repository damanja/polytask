package com.polytask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*        Pour tester , on peut faire */
//        auth.inMemoryAuthentication().withUser("admin").password("password");
        /*Mais on n'utilise jamais ca en developpement*/

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .anyRequest().authenticated()
                //     .mvcMatchers("/admin/*").hasRole("admin")
                //       .mvcMatchers("/about","help").permitAll()
                //    .mvcMatchers("/").permitAll()
//                .and()
                //               .formLogin().loginPage("/login.html").permitAll()
                .and()
                .csrf().disable()
        ;

        super.configure(http);
    }


}