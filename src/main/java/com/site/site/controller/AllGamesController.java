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
    public String allgames(Model model, @RequestParam(name = "genre", required = false) String genre){
        List<Games> gamesList = null;
        if(genre !=null && !genre.isEmpty()){
            gamesList = gamesService.findAllByGenre(genre, "");
        }
        else{
            gamesList = gamesService.getAllGames();
        }
        model.addAttribute("gamesList", gamesList);
        return "allgames";
    }
}
