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
    public String playstationGames(Model model, @RequestParam(name = "genre", required = false) String genre){
        List<Games> playstationGames = null;
        if (genre != null && !genre.isEmpty()) {
            playstationGames = gamesService.findAllByGenre(genre, "PLAYSTATION");
        }
        else playstationGames = gamesService.findAllByPlatform("PLAYSTATION");
        model.addAttribute("playstationgames", playstationGames);
        return "playstationgames";
    }
}
