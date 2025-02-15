package com.paulodev.dsjogos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulodev.dsjogos.dto.GameMinDTO;
import com.paulodev.dsjogos.entities.Game;
import com.paulodev.dsjogos.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result .stream().map(x -> new GameMinDTO(x)).toList();	
	
	}
	

}
