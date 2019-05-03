package com.utad.curso.desarrollo.seguro.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService; // será la clase CustomUserDetailServices

	@Autowired
	private PasswordEncoder passwordEncoder; // será CustomPasswordEncoder

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Login and Logout.
		http.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/")
				.failureUrl("/login?failure=true").and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

		// Authentication Provider.
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService); // como hacer para probar las credenciales
		authProvider.setPasswordEncoder(passwordEncoder);
		http.authenticationProvider(authProvider);

		// Authorization.
		http.authorizeRequests()

				// Allow Base URLs
				.and().authorizeRequests().antMatchers("/login").permitAll() // se permite a todo el mundo
				.and().authorizeRequests().antMatchers("/logout").permitAll()// se permite a todo el mundo

				// Require Authentication for any other URL
				.and().authorizeRequests().anyRequest().fullyAuthenticated(); // para acceder al resto se debe estar
																				// autenticado

		// CSRF.
		http.csrf().disable();

	}

}
