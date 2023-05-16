package com.site.site.Service;

import com.site.site.entity.Games;
import com.site.site.repository.GamesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GamesService {
    private final GamesRepository gamesRepository;

    public GamesService(GamesRepository gamesRepository) {this.gamesRepository = gamesRepository;}

    public List<Games> getAllGames(){return gamesRepository.findAll();}

    public Games getGame(Long ID) {return gamesRepository.findById(ID).orElse(null);}

    public Games saveGame(Games game){return gamesRepository.save(game);}

    public void deleteGame(Long ID){gamesRepository.deleteById(ID);}

    public List<Games> orderByPrice(Double price){
        return gamesRepository.findAllOrderByPrice(price);
    }
   public List<Games> findAllByPlatform(String platform){
        return gamesRepository.findAllByPlatform(platform);
   }
   public List<Games> findAllByGenre(@RequestParam(name = "genre", required = false) String genre, String platform){
        return gamesRepository.getAllByGenreAndPlatform(genre, platform);
    }
}
