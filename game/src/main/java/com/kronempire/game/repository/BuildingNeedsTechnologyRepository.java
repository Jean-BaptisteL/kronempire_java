package com.kronempire.game.repository;

import com.kronempire.game.models.Building;
import com.kronempire.game.models.BuildingNeedsTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildingNeedsTechnologyRepository extends JpaRepository<BuildingNeedsTechnology, Integer>, CrudRepository<BuildingNeedsTechnology, Integer> {

    List<BuildingNeedsTechnology> findAllByBuilding(Building building);
}
