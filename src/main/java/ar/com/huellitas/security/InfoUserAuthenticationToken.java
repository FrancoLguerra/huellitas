package ar.com.huellitas.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class InfoUserAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private String userName;

	public InfoUserAuthenticationToken(Long id, String mail,
			Collection<? extends GrantedAuthority> authorities) {
		super(id, mail, authorities);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Long getPrincipal() {
		return (Long) super.getPrincipal();
	}
	
	public Long getId() {
		return getPrincipal();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
