package com.paulodev.dsjogos.services;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulodev.dsjogos.dto.GameListDTO;
import com.paulodev.dsjogos.entities.GameList;
import com.paulodev.dsjogos.repositories.GameListRepository;



@Service
public class GameListService { 

    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
