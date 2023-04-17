package com.cg.config;

import com.cg.repository.UserRepository;
import com.cg.service.User.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan(basePackageClasses = {UserDetailsServiceImpl.class, UserRepository.class})
public class SecurityV2Configuration {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityV2Configuration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/static/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();

        //Pages not require login
        http.authorizeHttpRequests().antMatchers(
                "/web_client_product/**","/shop/**","/shopping-cart/**",
                "/shop/product-details/{id}/**","/shop/shop-brand-{id}/**",
                "/shop/shop-company-{id}/**","/shop/shop-category-{id}/**","/create-user/**"
                ,"/user/create-user/**"
                ,"/login", "/logout"
        ).permitAll();

        // Pages require login with roles: ROLE_USER, ROLE_ADMIN.
        // If not login yet, redirect to /login
        http.authorizeHttpRequests()
                .antMatchers("/", "/shop-watch/admin", "/user/**")
                    .hasAnyRole("USER", "ADMIN");

        // Pages require login with role: ROLE_ADMIN.
        // If not login at admin role yet, redirect to /login
        http.authorizeHttpRequests()
                .antMatchers("/role/**")
                    .hasRole("ADMIN");

        http.authorizeHttpRequests()
                .antMatchers("/admin/products/**")
                    .hasRole("ADMIN");

        // When user login with ROLE_USER, but try to
        // access pages require ROLE_ADMIN, redirect to /error-403
        http.authorizeHttpRequests().and().exceptionHandling()
                .accessDeniedPage("/access-denied");

        // Configure login page (check login by spring security)
        http.authorizeHttpRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginProcessingUrl("/j_spring_security_check")
                    .loginPage("/login")
                    .defaultSuccessUrl("/shop-watch/admin")
                    .failureUrl("/login?error=true")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout=true");

        // Configure remember me (save token in database)
        http.authorizeHttpRequests()
                .and().rememberMe()
                .tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(24 * 60 * 60);//24 hours

        return http.build();
    }

    // Token stored in memory (of web server)
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }
}
