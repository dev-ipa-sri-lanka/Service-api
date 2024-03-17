package com.developers.ipasrilankaapi.service.impl;

import com.developers.ipasrilankaapi.auth.ApplicationUser;
import com.developers.ipasrilankaapi.entity.User;
import com.developers.ipasrilankaapi.entity.UserRoleHasUser;
import com.developers.ipasrilankaapi.repo.UserRepo;
import com.developers.ipasrilankaapi.repo.UserRoleHasUserRepo;
import com.developers.ipasrilankaapi.util.mapper.UserRoleHasUserMapper;
import com.developers.ipasrilankaapi.util.mapper.UserRoleMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.developers.ipasrilankaapi.security.ApplicationUserRole.*;

@Service
public class ApplicationUserServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserRoleHasUserRepo userRoleHasUserRepo;
    private final UserRoleHasUserMapper userRoleHasUserMapper;

    private final UserRoleMapper userRoleMapper;

    public ApplicationUserServiceImpl(UserRepo userRepo, UserRoleHasUserRepo userRoleHasUserRepo, UserRoleHasUserMapper userRoleHasUserMapper, UserRoleMapper userRoleMapper) {
        this.userRepo = userRepo;
        this.userRoleHasUserRepo = userRoleHasUserRepo;
        this.userRoleHasUserMapper = userRoleHasUserMapper;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
     throws UsernameNotFoundException {
        User byUsername = userRepo.findByUsername(username);
        if (byUsername == null) {
            throw new UsernameNotFoundException(
                String.format("username %s not found", username));
        }
        List<UserRoleHasUser> userRole = userRoleHasUserRepo.
        findByUserId(byUsername.getUserId());
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        for (UserRoleHasUser user :userRole){
            if (user.getUserRole().getRoleName().equals("USER")){
                grantedAuthorities.addAll(USER.getGrantedAuthorities());
            }
            if (user.getUserRole().getRoleName().equals("ADMIN")){
                grantedAuthorities.addAll(ADMIN.getGrantedAuthorities());
            }
            if (user.getUserRole().getRoleName().equals("STUDENT")){
                grantedAuthorities.addAll(STUDENT.getGrantedAuthorities());
            }
            if (user.getUserRole().getRoleName().equals("MANAGER")){
                grantedAuthorities.addAll(MANAGER.getGrantedAuthorities());
            }
            if (user.getUserRole().getRoleName().equals("LECTURER")){
                grantedAuthorities.addAll(LECTURER.getGrantedAuthorities());
            }
            if (user.getUserRole().getRoleName().equals("COMPANY")){
                grantedAuthorities.addAll(COMPANY.getGrantedAuthorities());
            }
            if (user.getUserRole().getRoleName().equals("DEVELOPER")){
                grantedAuthorities.addAll(DEVELOPER.getGrantedAuthorities());
            }

        }
        ApplicationUser user = new ApplicationUser(
                byUsername.getPassword(),
                byUsername.getUsername(),
                grantedAuthorities,
                byUsername.isAccountNonExpired(),
                byUsername.isAccountNonLocked(),
                byUsername.isCredentialsNonExpired(),
                byUsername.isEnabled()
        );
        return user;
    }
}