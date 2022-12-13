package br.com.gestao_escola.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig  {
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(exchanges -> exchanges
                        .anyExchange().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return http.build();
    }


    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        //http
               // .authorizeExchange((authorize) -> authorize
                   //     .pathMatchers("/resources/**", "/signup", "/about").permitAll()
                //.pathMatchers("/admin/**").hasRole("ADMIN")
                //.pathMatchers("/db/**").access((authentication, context) ->
                //        hasRole("ADMIN").check(authentication, context)
               // )
                //.anyExchange().denyAll()
		//);
        return http.build();
    }
}
