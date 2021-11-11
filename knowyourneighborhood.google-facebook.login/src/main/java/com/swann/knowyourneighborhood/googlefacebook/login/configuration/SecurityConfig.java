package com.swann.knowyourneighborhood.googlefacebook.login.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.swann.knowyourneighborhood.googlefacebook.login.jwtsecurity.TokenAuthenticationFilter;
import com.swann.knowyourneighborhood.googlefacebook.login.oauth2security.AuthorizationFailureHandler;
import com.swann.knowyourneighborhood.googlefacebook.login.oauth2security.AuthorizationSuccessHandler;
import com.swann.knowyourneighborhood.googlefacebook.login.oauth2security.HttpCookieAuthorizationRequestRepo;
import com.swann.knowyourneighborhood.googlefacebook.login.service.OAuthUsersServiceImpl;
import com.swann.knowyourneighborhood.googlefacebook.login.service.UsersServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsersServiceImpl usersServiceImpl;
	
	@Bean
	public TokenAuthenticationFilter tokenAuthenticationFilter() {
		return new TokenAuthenticationFilter();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder
				.userDetailsService(usersServiceImpl)
				.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	//OAuth2 Login
    @Autowired
    private OAuthUsersServiceImpl oAuthUsersServiceImpl;
    
    @Autowired
    private AuthorizationSuccessHandler authorizationSuccessHandler;
    
    @Autowired
    private AuthorizationFailureHandler authorizationFailureHandler;
    
    @Bean
    public HttpCookieAuthorizationRequestRepo cookieAuthorizationRequestRepo() {
    	return new HttpCookieAuthorizationRequestRepo();
    }
	
    //configure cors, sessionManagement, add rules
    //permit or restrict
    //permit static like images, script and so on
    //permit register API, login API to everyone
    //restrict profile API, view API and search API
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.cors()
					.and()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
				.csrf()
				.disable()
				.formLogin()
				.disable()
				.httpBasic()
				.disable()
				.authorizeRequests()
					.antMatchers("/",
							"/error",
							   "/favicon.ico",
		                        "/**/*.png",
		                        "/**/*.gif",
		                        "/**/*.svg",
		                        "/**/*.jpg",
		                        "/**/*.html",
		                        "/**/*.css",
		                        "/**/*.js")
								.permitAll()
							.antMatchers("/knowyourneighborhood/**", "/oauth2/**")
								.permitAll()
								.anyRequest()
									.authenticated()
									.and()
					                .oauth2Login()
					                    .authorizationEndpoint()
					                        .baseUri("/oauth2/authorize")
					                        .authorizationRequestRepository(cookieAuthorizationRequestRepo())
					                        .and()
					                    .redirectionEndpoint()
					                        .baseUri("/oauth2/callback/*")
					                        .and()
					                    .userInfoEndpoint()
					                        .userService(oAuthUsersServiceImpl)
					                        .and()
					                    .successHandler(authorizationSuccessHandler)
					                    .failureHandler(authorizationFailureHandler);
		
		// Add our custom Token based authentication filter
		http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}


