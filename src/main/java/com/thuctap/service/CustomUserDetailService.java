package com.thuctap.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thuctap.models.CustomUserDetails;
import com.thuctap.models.UserRole;
import com.thuctap.models.Users;


@Service
public class CustomUserDetailService  implements UserDetailsService {
	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user =userService.findByUserName(username);
		if(user ==null) {
			throw new UsernameNotFoundException("SAI");
		}
		if (!user.getEnabled()) {
			throw new DisabledException("Tài khoản của bạn đã bị vô hiệu hóa.");
        }
		Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
		Set<UserRole> roles = user.getUserRoles();
	        for (UserRole userRole : roles) {
	        	grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
			}     
		return new CustomUserDetails(user,grantedAuthoritySet);
	}
}
