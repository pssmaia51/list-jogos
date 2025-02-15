package com.paulodev.dsjogos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulodev.dsjogos.dto.GameMinDTO;
import com.paulodev.dsjogos.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class Controller {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
		 
	}
	

}
