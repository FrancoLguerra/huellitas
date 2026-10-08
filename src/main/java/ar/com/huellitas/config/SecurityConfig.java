package ar.com.huellitas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import ar.com.huellitas.controllers.LoginController;
import ar.com.huellitas.enums.Rol;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.exceptionHandling(ex->ex.accessDeniedHandler(accessDeniedHandler()))
				.authorizeHttpRequests(auth -> auth
				.requestMatchers("/css/**","/images/**", "/js/**" ).permitAll()
				.requestMatchers("/usuarios").hasRole(Rol.ADMIN.name())
				.requestMatchers("/").permitAll()
				.requestMatchers("/registracion").permitAll()
				.requestMatchers(LoginController.LOGIN_URL,LoginController.SIGN_IN_URL).permitAll()
				.anyRequest().authenticated())
				.formLogin(page-> page.loginPage(LoginController.SIGN_IN_URL))
				.build();
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return(request, response, accessDeniedException)->{
			response.sendRedirect(LoginController.SIGN_IN_URL);
		};
	}

}
