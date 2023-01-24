package com.AnnuSharma.LoginAndRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.AnnuSharma.LoginAndRegistration.db.User;
import com.AnnuSharma.LoginAndRegistration.db.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		
		if (user == null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		return new CustomUserDetails(user);
	}

}
