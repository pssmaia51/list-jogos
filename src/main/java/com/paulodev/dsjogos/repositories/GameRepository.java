package com.paulodev.dsjogos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulodev.dsjogos.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	

}
