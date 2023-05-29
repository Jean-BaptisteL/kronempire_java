package com.kronempire.game.repository;

import com.kronempire.game.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, CrudRepository<Player, Long> {
    Player findPlayerByEmail(String email);

}
