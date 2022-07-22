package com.liza.hsimR_backend.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.repository.FranchiseRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Franchise franchise = franchiseRepository.findByNom(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found : ".concat(username)));

		return new User(franchise.getNom(), franchise.getPassword(), Arrays.asList(new SimpleGrantedAuthority("user")));
	}

}
