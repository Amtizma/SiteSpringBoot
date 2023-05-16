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
public class XboxGamesController {

    private final GamesService gamesService;

    @Autowired
    public XboxGamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @RequestMapping("/xbox")
    public String xboxGames(Model model, @RequestParam(name = "genre", required = false) String genre){
        List<Games> xboxGames = null;
        if(genre != null && !genre.isEmpty()){
            xboxGames = gamesService.findAllByGenre(genre, "XBOX");
        }
        else xboxGames = gamesService.findAllByPlatform("XBOX");
        model.addAttribute("xboxgames", xboxGames);
        return "xboxgames";
    }
}
