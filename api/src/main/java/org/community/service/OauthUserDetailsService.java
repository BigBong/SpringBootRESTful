package org.community.service;

import lombok.extern.slf4j.Slf4j;
import org.community.domain.User;
import org.community.domain.UserPrivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frodoking on 2017/1/16.
 */
@Service
@Slf4j
public class OauthUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserPrivilegeService userPrivilegeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername >> " + username);
        final User user = userService.getByName(username);
        if (user == null)
            throw new UsernameNotFoundException(username);

        List<UserPrivilege> privileges = userPrivilegeService.getPrivilegesById(user.getId());
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<>(privileges.size());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        for (UserPrivilege privilege : privileges) {
            log.info("loadUserByUsername >> " + username + ", privilege >> " + privilege.getPrivilege());
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + privilege.getPrivilege()));
        }

        return  new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
