package br.com.almeida.louvor_manager_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.almeida.louvor_manager_api.services.security.AuthorizationService;
import br.com.almeida.louvor_manager_api.services.security.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private SecurityFilter securityFilter;
    
	@Autowired
    private AuthorizationService authorizationService;
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Desabilita proteção contra ataques que não ocorrem em APIs REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // API sem estado
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/v1/auth/login").permitAll() // Login é aberto
                        .requestMatchers(HttpMethod.POST, "/v1/users").permitAll()      // Cadastro de usuário é aberto
                        .requestMatchers(HttpMethod.POST, "/v1/events").hasRole("ADMIN") // Só ADMIN cria evento
                        .requestMatchers(HttpMethod.GET, "/v1/users").hasRole("ADMIN")
                        .anyRequest().authenticated() // Todo o resto precisa de token
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // Coloca filtro antes do padrão do Spring
                .build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        
        authenticationManagerBuilder
            .userDetailsService(authorizationService)
            .passwordEncoder(passwordEncoder());
            
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
