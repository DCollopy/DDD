package br.com.gestao_escola.web.config;

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig  {
//    @Bean
//    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http
//                .authorizeExchange(exchanges -> exchanges
//                        .anyExchange().authenticated()
//                )
//                .httpBasic(withDefaults())
//                .formLogin(withDefaults());
//        return http.build();
//    }
//
//
//    @Bean
//    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
//        http
//                .authorizeExchange((authorize) -> authorize
//                        .pathMatchers("/swagger-ui/**", "/javainuse-openapi/**","/resources/**", "/signup", "/about").permitAll()
//                .pathMatchers("/admin/**").hasRole("ADMIN")
//                .anyExchange().authenticated());
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
