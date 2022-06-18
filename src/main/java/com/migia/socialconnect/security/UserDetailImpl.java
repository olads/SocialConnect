package com.migia.socialconnect.security;

import com.migia.socialconnect.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor
@Getter
@Setter
public class UserDetailImpl implements UserDetails {

    private User user ;
    private boolean isNotLocked = true;
    private boolean isNotCredentialLocked = true;
    private boolean isEnabled = true;

    public UserDetailImpl (User user){
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));
    }



    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isNotLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isNotCredentialLocked;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
