package svetlov.services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("user@gmail.com")
                .password("$2a$10$NYyrmBS/6OMpzkdpaffGOe/9D4s0Dmunzh5zcQ2H0dbUHvv2p6Gq6")
                .roles("USER")
                .build();
        UserDetails user2 = User
                .withUsername("admin")
                .password("$2a$10$NYyrmBS/6OMpzkdpaffGOe/9D4s0Dmunzh5zcQ2H0dbUHvv2p6Gq6")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/", "/index", "/login*").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .usernameParameter("email")
                        .passwordParameter("pass")
                        .defaultSuccessUrl("/helloUser")
                        .permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                );
        return http.build();
    }
}
