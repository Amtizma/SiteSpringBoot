package com.site.site.Service;

import com.site.site.entity.Games;
import com.site.site.repository.GamesRepository;
import org.springframework.data.repository.query.Param;
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

    public List<Games> findAllByName(@RequestParam(name = "name", required = false) String name){
        return gamesRepository.findAllByName(name);
    }

    public List<Games> orderByPriceAsc(String platform, String genre){
        return gamesRepository.findAllByPlatformOrderByPriceAsc(platform, genre);
    }
    public List<Games> orderByPriceDesc(String platform, String genre){
        return gamesRepository.findAllByPlatformOrderByPriceDesc(platform, genre);
    }
    public List<Games> orderByNameAsc(String platform, String genre){
        return gamesRepository.findAllByPlatformOrderByNameAsc(platform, genre);
    }
    public List<Games> orderByNameDesc(String platform, String genre){
        return gamesRepository.findAllByPlatformOrderByNameDesc(platform, genre);
    }
    public List<Games> orderByReleaseDateAsc(String platform, String genre){
        return gamesRepository.findAllByPlatformOrderByRelease_DateAsc(platform, genre);
    }
    public List<Games> orderByReleaseDateDesc(String platform, String genre){
        return gamesRepository.findAllByPlatformOrderByRelease_DateDesc(platform, genre);
    }
    public List<Games> orderPlatByPriceAsc(String platform){
        return gamesRepository.findAllByPlatOrderByPriceAsc(platform);
    }
    public List<Games> orderPlatByPriceDesc(String platform){
        return gamesRepository.findAllByPlatOrderByPriceDesc(platform);
    }
    public List<Games> orderPlatByNameAsc(String platform){
        return gamesRepository.findAllByPlatOrderByNameAsc(platform);
    }
    public List<Games> orderPlatByNameDesc(String platform){
        return gamesRepository.findAllByPlatOrderByNameDesc(platform);
    }
    public List<Games> orderPlatByReleaseDateAsc(String platform){
        return gamesRepository.findAllByPlatOrderByRelease_DateAsc(platform);
    }
    public List<Games> orderPlatByReleaseDateDesc(String platform){
        return gamesRepository.findAllByPlatOrderByRelease_DateDesc(platform);
    }
    public Games getGameByName(String name){
        return gamesRepository.findGamesByName(name);
    }
}
