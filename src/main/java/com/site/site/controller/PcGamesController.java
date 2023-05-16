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
    public String pcGames(Model model, @RequestParam(name = "genre", required = false) String genre){
        List<Games> pcGames = null;
        if(genre != null && !genre.isEmpty()){
            pcGames = gamesService.findAllByGenre(genre, "PC");
        }
        else pcGames = gamesService.findAllByPlatform("PC");
        model.addAttribute("pcgames", pcGames);
        return "pcgames";
    }

}
