package com.site.site.controller;

import com.site.site.Service.GamesService;
import com.site.site.entity.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlaystationController {
    private final GamesService gamesService;

    @Autowired
    public PlaystationController(GamesService gamesService) {
        this.gamesService = gamesService;
    }
    @RequestMapping("/ps")
    public String playstationGames(Model model, @RequestParam(name = "genre", required = false) String genre, @RequestParam(name = "filter", required = false)String filter, @RequestParam(name = "sortOrder", required = false) String sortOrder){
        List<Games> playstationGames = null;
        if(genre !=null && !genre.isEmpty()){
            if(filter!=null && !filter.isEmpty()) {
                if(sortOrder.equals("ASC")) {
                    switch (filter) {
                        case("price") -> playstationGames = gamesService.orderByPriceAsc("PLAYSTATION", genre);
                        case("name") -> playstationGames = gamesService.orderByNameAsc("PLAYSTATION", genre);
                        case("releaseDate") -> playstationGames = gamesService.orderByReleaseDateAsc("PLAYSTATION", genre);
                    }
                }
                else {
                    switch (filter) {
                        case("price") -> playstationGames = gamesService.orderByPriceDesc("PLAYSTATION", genre);
                        case("name") -> playstationGames = gamesService.orderByNameDesc("PLAYSTATION", genre);
                        case("releaseDate") -> playstationGames = gamesService.orderByReleaseDateDesc("PLAYSTATION", genre);
                    }
                }
            }
            else playstationGames = gamesService.findAllByGenre(genre, "PLAYSTATION");
        } else if (filter != null && !filter.isEmpty()) {
            if (sortOrder.equals("ASC")) {
                switch (filter) {
                    case "price" -> playstationGames = gamesService.orderPlatByPriceAsc("PLAYSTATION");
                    case "name" -> playstationGames = gamesService.orderPlatByNameAsc("PLAYSTATION");
                    case "releaseDate" -> playstationGames = gamesService.orderPlatByReleaseDateAsc("PLAYSTATION");
                };
            } else {
                switch (filter) {
                    case "price" -> playstationGames = gamesService.orderPlatByPriceDesc("PLAYSTATION");
                    case "name" -> playstationGames = gamesService.orderPlatByNameDesc("PLAYSTATION");
                    case "releaseDate" -> playstationGames = gamesService.orderPlatByReleaseDateDesc("PLAYSTATION");
                };
            }
        }
        else playstationGames = gamesService.findAllByPlatform("PLAYSTATION");
        model.addAttribute("playstationgames", playstationGames);
        return "playstationgames";
    }
}
