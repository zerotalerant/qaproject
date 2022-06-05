package org.example.security;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Override
    protected void configure ( AuthenticationManagerBuilder auth ) throws Exception
    {
        auth.jdbcAuthentication ()
                .dataSource ( dataSource )
                .usersByUsernameQuery ( "SELECT t.user_name, t.user_password, t.user_email FROM users t WHERE t.user_name = ?" )
                .authoritiesByUsernameQuery (
                        "SELECT u.user_name, ur.name_role" +
                        "FROM user_role ur" +
                        "INNER JOIN users u " +
                        "on ur.user_id = u.id" +
                        "INNER JOIN roles r" +
                        "on ur.role_id = r.id" +
                        "WHERE u.user_name" );
    }

    @Override
    protected void configure ( HttpSecurity httpSecurity ) throws Exception
    {
        httpSecurity
                .sessionManagement ()
                .sessionCreationPolicy ( SessionCreationPolicy.STATELESS )
                .and ()
                .csrf ().disable ()
                .authorizeRequests ()
                .antMatchers ( HttpMethod.POST, "api/user/sign-up" ).permitAll ()
                .antMatchers ( HttpMethod.POST, "api/user/sign-in" ).permitAll ()
                .antMatchers ( HttpMethod.GET, "api/user/get/all-users" ).hasRole ( "USER" )
                .antMatchers ( HttpMethod.GET, "api/user/get/{userId}" ).hasRole ( "USER" )
                .antMatchers ( HttpMethod.GET, "api/currency/get/all-currencies" ).hasRole ( "USER" )
                .antMatchers ( HttpMethod.GET, "api/currency/get/{currencyId}" ).hasRole ( "ADMIN" )
                .antMatchers ( HttpMethod.POST, "api/currency/create" ).hasRole ( "ADMIN" )
                .antMatchers ( HttpMethod.PUT, "api/currency/update" ).hasRole ( "ADMIN" )
                .and ()
                .httpBasic ();
    }

    @Bean
    public PasswordEncoder passwordEncoder ()
    {
        return new BCryptPasswordEncoder ();
    }
}
