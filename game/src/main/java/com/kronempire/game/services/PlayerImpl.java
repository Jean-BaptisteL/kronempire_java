package com.kronempire.game.services;

import com.kronempire.game.models.Player;
import com.kronempire.game.models.PlayerStat;
import com.kronempire.game.repository.PlayerRepository;
import com.kronempire.game.repository.PlayerStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerImpl implements PlayerService{

    @Autowired
    private PlayerStatRepository playerStatRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerStat getStatByPlayerEmail(String email) {
        Optional<Player> optPlayer = Optional.ofNullable(playerRepository.findPlayerByEmail(email));
        if (optPlayer.isEmpty()) {
            throw new RuntimeException("No statistics found for player :" + email);
        }

        Object[] objects = optPlayer.get().getStats().toArray();

        PlayerStat playerStat = (PlayerStat) objects[0];

        System.out.println("PlayerImpl player stat log KRON::" + playerStat.getKronQuantity_player_stat());
        System.out.println("PlayerImpl player stat log MANA::" + playerStat.getManaQuantity_player_stat());
        System.out.println("PlayerImpl player stat log METAL::" + playerStat.getMetalQuantity_player_stat());
        System.out.println("PlayerImpl player stat log WOOD::" + playerStat.getWoodQuantity_player_stat());
        System.out.println("PlayerImpl player stat log MORAL::" + playerStat.getMoral_player_stat());
        System.out.println("PlayerImpl player stat log DEVOTION::" + playerStat.getDevotion_player_stat());
        System.out.println("PlayerImpl player stat log POP::" + playerStat.getPopQuantity_player_stat());

        return playerStat; // for now players has only one game
//         System.out.println("PlayerImpl player stat log KRON::" + stats.get(0).getKronQuantity_player_stat());
//        System.out.println("PlayerImpl player stat log MANA::" + stats.get(0).getManaQuantity_player_stat());
//        System.out.println("PlayerImpl player stat log METAL::" + stats.get(0).getMetalQuantity_player_stat());
//        System.out.println("PlayerImpl player stat log WOOD::" + stats.get(0).getWoodQuantity_player_stat());
//        System.out.println("PlayerImpl player stat log MORAL::" + stats.get(0).getMoral_player_stat());
//        System.out.println("PlayerImpl player stat log DEVOTION::" + stats.get(0).getDevotion_player_stat());
//        System.out.println("PlayerImpl player stat log POP::" + stats.get(0).getPopQuantity_player_stat());
//
//        return stats.get(0); // for now players has only one game
    }
}
