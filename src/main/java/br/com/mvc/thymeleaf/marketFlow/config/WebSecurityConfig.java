package br.com.mvc.thymeleaf.marketFlow.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest()
					.authenticated()
				.and()
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/home", true)
						.permitAll())
						.logout(logout -> logout.logoutUrl("/logout"));
				
		return http.build();
    }
    
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .build();
    }

    
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.jdbcAuthentication()
        .withDefaultSchema()
        .dataSource(dataSource());
    }
}

