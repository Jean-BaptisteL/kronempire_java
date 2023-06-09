package com.kronempire.game.security.service;

import com.kronempire.game.models.Player;
import com.kronempire.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlayerSpringService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerSpring loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findPlayerByEmail(username);
        return  new PlayerSpring(player);
    }
}
