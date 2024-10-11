package com.frozeneye.ecommerce.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.frozeneye.ecommerce.model.Users;
import com.frozeneye.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Users users = userRepository.findByEmail(username);//.orElseThrow(() -> newUsernameNotFoundException("User details not found for the user: " + username));
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new
                        SimpleGrantedAuthority(users.getRole()));
        return new User(users.getEmail(), users.getPassword(), authorities);
        
    }

}
