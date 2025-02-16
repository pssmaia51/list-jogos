package com.paulodev.dsjogos.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulodev.dsjogos.dto.GameDTO;
import com.paulodev.dsjogos.dto.GameMinDTO;
import com.paulodev.dsjogos.entities.Game;
import com.paulodev.dsjogos.excecoes.ResourceNotFoundException;
import com.paulodev.dsjogos.projections.GameMinProjection;
import com.paulodev.dsjogos.repositories.GameRepository;



@Service
public class GameService { 

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogo com ID " + id + " não encontrado"));
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).collect(Collectors.toList());

        //return result.stream().map(GameMinDTO::new).toList();
    }
}
