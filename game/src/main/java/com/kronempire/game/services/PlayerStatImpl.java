package com.kronempire.game.services;

import com.kronempire.game.models.Player;
import com.kronempire.game.models.PlayerStat;
import com.kronempire.game.repository.PlayerRepository;
import com.kronempire.game.repository.PlayerStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PlayerStatImpl implements PlayerStatService{

    @Autowired
    private PlayerStatRepository playerStatRepository;

    @Autowired
    private PlayerRepository playerRepository;


    @Override
    @Transactional
    public PlayerStat getPlayerStatByPlayer(Player player) {
        Optional<PlayerStat> optPlayerStat = Optional.ofNullable(playerStatRepository.findPlayerStatByPlayer(player));
        if (optPlayerStat.isEmpty()) {
            throw new RuntimeException("No statistics found for player :" + player.getPseudo_player());
        }

        System.out.println("PlayerStatImpl log KRON::" + optPlayerStat.get().getKronQuantity_player_stat());

        return optPlayerStat.get();
    }

    @Override
    public PlayerStat savePlayerStat(PlayerStat playerStat) {
        return playerStatRepository.save(playerStat);
    }
}
