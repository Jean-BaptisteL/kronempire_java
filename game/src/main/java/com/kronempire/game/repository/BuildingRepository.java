package com.kronempire.game.repository;

import com.kronempire.game.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>, CrudRepository<Building, Long> {
}
