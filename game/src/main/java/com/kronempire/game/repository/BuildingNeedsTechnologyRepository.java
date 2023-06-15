package com.kronempire.game.repository;

import com.kronempire.game.models.BuildingNeedsTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BuildingNeedsTechnologyRepository extends JpaRepository<BuildingNeedsTechnology, Integer>, CrudRepository<BuildingNeedsTechnology, Integer> {
}
