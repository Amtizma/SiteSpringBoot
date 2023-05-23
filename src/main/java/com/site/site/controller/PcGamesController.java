package com.site.site.controller;

import com.site.site.Service.GamesService;
import com.site.site.entity.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PcGamesController {

    @Autowired
    public PcGamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    private final GamesService gamesService;

    @RequestMapping("/pc")
    public String pcGames(Model model, @RequestParam(name = "genre", required = false) String genre, @RequestParam(name = "filter", required = false)String filter, @RequestParam(name = "sortOrder", required = false) String sortOrder){
        List<Games> pcGames = null;
        if(genre !=null && !genre.isEmpty()){
            if(filter!=null && !filter.isEmpty()) {
                if(sortOrder.equals("ASC")) {
                    switch (filter) {
                        case("price") -> pcGames = gamesService.orderByPriceAsc("PC", genre);
                        case("name") -> pcGames = gamesService.orderByNameAsc("PC", genre);
                        case("releaseDate") -> pcGames = gamesService.orderByReleaseDateAsc("PC", genre);
                    }
                }
                else {
                    switch (filter) {
                        case("price") -> pcGames = gamesService.orderByPriceDesc("PC", genre);
                        case("name") -> pcGames = gamesService.orderByNameDesc("PC", genre);
                        case("releaseDate") -> pcGames = gamesService.orderByReleaseDateDesc("PC", genre);
                    }
                }
            }
            else pcGames = gamesService.findAllByGenre(genre, "PC");
        } else if (filter != null && !filter.isEmpty()) {
            if (sortOrder.equals("ASC")) {
                switch (filter) {
                    case "price" -> pcGames = gamesService.orderPlatByPriceAsc("PC");
                    case "name" -> pcGames = gamesService.orderPlatByNameAsc("PC");
                    case "releaseDate" -> pcGames = gamesService.orderPlatByReleaseDateAsc("PC");
                };
            } else {
                switch (filter) {
                    case "price" -> pcGames = gamesService.orderPlatByPriceDesc("PC");
                    case "name" -> pcGames = gamesService.orderPlatByNameDesc("PC");
                    case "releaseDate" -> pcGames = gamesService.orderPlatByReleaseDateDesc("PC");
                };
            }
        }
        else pcGames = gamesService.findAllByPlatform("PC");
        model.addAttribute("pcgames", pcGames);
        return "pcgames";
    }

}
