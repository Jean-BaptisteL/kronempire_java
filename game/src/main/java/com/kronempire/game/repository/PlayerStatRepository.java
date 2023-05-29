package com.kronempire.game.repository;

import com.kronempire.game.models.Player;
import com.kronempire.game.models.PlayerStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatRepository extends JpaRepository<PlayerStat, Long>, CrudRepository<PlayerStat, Long> {

    @Query("SELECT COUNT(s) FROM PlayerStat s")
    Integer countAllPlayerStats();

    PlayerStat findPlayerStatByPlayer(Player player);
}
