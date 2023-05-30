package com.kronempire.game.repository;

import com.kronempire.game.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long>, CrudRepository<Technology, Long> {
}
