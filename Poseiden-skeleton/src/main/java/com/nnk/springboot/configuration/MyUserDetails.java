package com.nnk.springboot.configuration;


import com.nnk.springboot.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class MyUserDetails implements UserDetails {


    private String userName;
    private String password;

    private List<GrantedAuthority> authorities;

       private boolean isAccountNonExpired;

       private boolean isAccountNonLocked;

       private boolean isCredentialsNonExpired;

       private boolean isEnabled;


    public MyUserDetails(User account) {

        this.userName = account.getUsername();
        this.password = account.getPassword();
        this.authorities = Arrays.asList(new SimpleGrantedAuthority(account.getRole()));
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
