package com.kronempire.game.repository;

import com.kronempire.game.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long>, CrudRepository<Unit, Long> {
}
