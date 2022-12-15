package com.spring.qlda.SpringbootReact.config;

import com.spring.qlda.SpringbootReact.model.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {
    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/users")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
        http.csrf().disable();
    }
}
//}
//    @Autowired
//    private DataSource dataSource;

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailsService();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().antMatchers("/", "/home", "/about", "/css/*", "/js/*", "/admin/**","/liststudent").permitAll();
////        http.authenticationProvider(authenticationProvider());
//            http.authorizeRequests()
//            .antMatchers( "/list_users").authenticated()
//            .anyRequest().permitAll()
//            .and()
//            .formLogin()
//                .usernameParameter("email")
//                .defaultSuccessUrl("/list_users")
//                .permitAll()
//            .and()
//            .logout().logoutSuccessUrl("/").permitAll();
//            return http.build();
//    }

//     @Bean
//     public WebSecurityCustomizer webSecurityCustomizer() {
//         return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//     }

