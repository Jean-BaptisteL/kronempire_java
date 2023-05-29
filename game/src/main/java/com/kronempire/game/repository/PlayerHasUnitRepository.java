package com.kronempire.game.repository;

import com.kronempire.game.models.PlayerHasUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerHasUnitRepository extends JpaRepository<PlayerHasUnit,Long>, CrudRepository<PlayerHasUnit, Long> {
}
