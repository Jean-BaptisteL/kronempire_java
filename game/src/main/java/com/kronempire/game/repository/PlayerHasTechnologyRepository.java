package com.kronempire.game.repository;

import com.kronempire.game.models.PlayerHasTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerHasTechnologyRepository extends JpaRepository<PlayerHasTechnology, Long>, CrudRepository<PlayerHasTechnology, Long> {
}
