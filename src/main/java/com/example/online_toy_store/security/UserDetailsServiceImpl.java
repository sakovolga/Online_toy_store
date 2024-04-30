package com.example.online_toy_store.security;

import com.example.online_toy_store.entity.Role;
import com.example.online_toy_store.entity.UserInfo;
import com.example.online_toy_store.repository.UserInfoRepository;
<<<<<<< HEAD
import com.example.online_toy_store.repository.UserRepository;
=======
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
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
<<<<<<< HEAD
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(username);
        if (userInfo.isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        return User.withUsername(username)
=======


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(userName);
        if (!userInfo.isPresent()) {
            throw new UsernameNotFoundException(userName);
        }

        return User.withUsername(userName)
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
                .username(userInfo.get().getUserName())
                .password(userInfo.get().getPassword())
                .authorities(getAuthorities(userInfo.get().getRoles()))
                .build();
    }

<<<<<<< HEAD
    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
=======
    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));

>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
            role.getAuthorities().forEach(authority ->
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName())));
        }
        return authorities;
    }
<<<<<<< HEAD

}
=======
}
>>>>>>> 459537334812a2c5c9a905745dfbd9786b18ead5
