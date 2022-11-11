package com.kgisl.auth.config;

//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthSecurityConfig {
	@Autowired
	UserDetailsService userDetailsService;

	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}
	
	@Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    HttpBasicConfigurer<HttpSecurity> l = http
	         .csrf().disable()
	         .authorizeRequests().anyRequest().authenticated()
	         .and()
	         .httpBasic();
        System.out.println(l);
	    return http.build();
	  }
//	@Bean
//	public ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry configure(HttpSecurity http) throws Exception {
//		http.cors().disable();
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//		
//		return http.authorizeRequests().antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "MANAGER").antMatchers(HttpMethod.PUT)
//				.hasAnyRole("ADMIN", "MANAGER").antMatchers(HttpMethod.DELETE).hasAnyRole("MANAGER")
//				.antMatchers(HttpMethod.GET, "/cars").hasAnyRole("ADMIN", "MANAGER", "USER")
//				.antMatchers(HttpMethod.GET, "/users").hasAnyRole("ADMIN", "MANAGER")
//				.antMatchers(HttpMethod.GET, "/users/{id}")
//				.access("@userSecurity.hasId(auth,#id)");
//		}
}
