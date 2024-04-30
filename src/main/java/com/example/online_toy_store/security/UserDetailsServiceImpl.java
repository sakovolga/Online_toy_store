package com.example.online_toy_store.security;

import com.example.online_toy_store.entity.Role;
import com.example.online_toy_store.entity.UserInfo;
import com.example.online_toy_store.repository.UserInfoRepository;
import com.example.online_toy_store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(username);
        if (userInfo.isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        return User.withUsername(username)
                .username(userInfo.get().getUserName())
                .password(userInfo.get().getPassword())
                .authorities(getAuthorities(userInfo.get().getRoles()))
                .build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            role.getAuthorities().forEach(authority ->
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName())));
        }
        return authorities;
    }

}
