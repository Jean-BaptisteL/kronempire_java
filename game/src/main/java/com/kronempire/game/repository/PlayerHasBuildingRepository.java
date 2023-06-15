package com.kronempire.game.repository;

import com.kronempire.game.models.PlayerHasBuilding;
import com.kronempire.game.models.PlayerStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerHasBuildingRepository extends JpaRepository<PlayerHasBuilding, Long>, CrudRepository<PlayerHasBuilding, Long> {

    List<PlayerHasBuilding> findPlayerHasBuildingByPlayerStat(PlayerStat playerStat);
}
