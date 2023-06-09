package com.kronempire.game.security.service;

import com.kronempire.game.models.Player;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerSpring implements UserDetails {

    private Player player;

    public PlayerSpring (Player player) {
        this.player = player;
    }
    public Player getPlayer () {
        return player ;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList <SimpleGrantedAuthority> listeAuthority = new ArrayList<>();
        if(this.player.getStatus_player() == 1) {
            listeAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return listeAuthority ;
    }

    @Override
    public String getPassword() {
        return player.getPassword_player();
    }

    @Override
    public String getUsername() {
        return player.getEmail();
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
