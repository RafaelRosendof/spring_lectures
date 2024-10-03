/* 
package com.SistemLoja.SistemaLoja.Security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    /* 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /* 
        http.authorizeRequests()
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("GERENTE")
            .antMatchers("/funcionario/**").hasAnyRole("GERENTE", "FUNCIONARIO")
            .and()
            .formLogin()
            .and()
            .logout()
            .permitAll();

        return http.build();
        */
/* 
        http.authorizeRequests(configurer -> 
            configurer 
                .requestMatchers("/").hasRole("FUNCIONARIO")
                .requestMatchers("/admin/**").hasRole("GERENTE")
                .requestMatchers("/funcionario/**").hasAnyRole("GERENTE", "FUNCIONARIO")
                .anyRequest().authenticated()
        )
        .formLogin( form -> 
            form.loginPage("/login")
            .loginProcessingUrl("/loginProcess")
            .permitAll()
        )
        .logout(logout -> logout.permitAll()
        )
        .exceptionHandling(configurer -> 
            configurer.accessDeniedPage("/acesso-negado")
        );

        return http.build();
    }

     

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configuração de usuários em memória para testes iniciais
        auth.inMemoryAuthentication()
            .withUser("admin").password(passwordEncoder().encode("admin")).roles("GERENTE")
            .and()
            .withUser("funcionario").password(passwordEncoder().encode("funcionario")).roles("FUNCIONARIO");
    }
}

*/
package com.SistemLoja.SistemaLoja.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desabilita a proteção CSRF
            .authorizeRequests()
            .anyRequest().permitAll(); // Permite todas as requisições
        return http.build();
    }
}

