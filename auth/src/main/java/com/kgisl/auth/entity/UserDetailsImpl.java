package com.kgisl.auth.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;

	private User user;
	
	public UserDetailsImpl(User user) {
	     System.out.println(user);
		//super();
		this.user=user;		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
		System.out.println(grantedAuthorities.stream().collect(Collectors.toList()));
		grantedAuthorities.add(new SimpleGrantedAuthority(this.user.getRole().toUpperCase()));
    	System.out.println("inside details impl "+grantedAuthorities.get(0).getAuthority());
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		System.out.println(this.user.getPassword());
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println(this.user.getName());
		return this.user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
}
