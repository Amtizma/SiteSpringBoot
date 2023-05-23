package com.site.site.controller;

import com.site.site.Service.GamesService;
import com.site.site.entity.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AllGamesController {

    private final GamesService gamesService;

    @Autowired
    public AllGamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @RequestMapping("/allgames")
    public String allgames(Model model, @RequestParam(name = "genre", required = false) String genre, @RequestParam(name = "name", required = false) String name,  @RequestParam(name = "filter", required = false)String filter, @RequestParam(name = "sortOrder", required = false) String sortOrder){
        List<Games> gamesList = null;
        if (genre != null && !genre.isEmpty()) {
            if (filter != null && !filter.isEmpty()) {
                if (sortOrder.equals("ASC")) {
                    switch (filter) {
                        case "price" -> gamesList = gamesService.orderByPriceAsc("", genre);
                        case "name" -> gamesList = gamesService.orderByNameAsc("", genre);
                        case "releaseDate" -> gamesList = gamesService.orderByReleaseDateAsc("", genre);
                    }
                } else {
                    switch (filter) {
                        case "price" -> gamesList = gamesService.orderByPriceDesc("", genre);
                        case "name" -> gamesList = gamesService.orderByNameDesc("", genre);
                        case "releaseDate" -> gamesList = gamesService.orderByReleaseDateDesc("", genre);
                    };
                }
            } else {
                gamesList = gamesService.findAllByGenre(genre, "");
            }
        } else if (filter != null && !filter.isEmpty()) {
            if (sortOrder.equals("ASC")) {
                switch (filter) {
                    case "price" -> gamesList = gamesService.orderPlatByPriceAsc("");
                    case "name" -> gamesList = gamesService.orderPlatByNameAsc("");
                    case "releaseDate" -> gamesList = gamesService.orderPlatByReleaseDateAsc("");
                };
            } else {
                switch (filter) {
                    case "price" -> gamesList = gamesService.orderPlatByPriceDesc("");
                    case "name" -> gamesList = gamesService.orderPlatByNameDesc("");
                    case "releaseDate" -> gamesList =gamesService.orderPlatByReleaseDateDesc("");
                };
            }
        } else if (name != null && !name.isEmpty()) {
            gamesList = gamesService.findAllByName(name);
        } else {
            gamesList = gamesService.getAllGames();
        }

        model.addAttribute("gamesList", gamesList);
        return "allgames";
    }
}
