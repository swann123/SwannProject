package com.swann.knowyourneighborhood.googlefacebook.login.jwtsecurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.swann.knowyourneighborhood.googlefacebook.login.service.UsersServiceImpl;

//Token Authentication Filter
public class TokenAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Autowired
	private UsersServiceImpl usersService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
			try {
				String jwt = getJwt(request);
				if(org.springframework.util.StringUtils.hasText(jwt) && tokenProvider.validteToken(jwt)) {
						int userId = tokenProvider.getUserIdFromToken(jwt);
						
						UserDetails userDetails = usersService.loadUserById(userId);
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			filterChain.doFilter(request, response);	
	}
	
	//Customized get jwt method for bearer token
	private String getJwt(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if(org.springframework.util.StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
		
	}
}
