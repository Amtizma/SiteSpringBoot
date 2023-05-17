package com.site.site.controller;

import com.site.site.Service.GamesService;
import com.site.site.entity.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StartController {

    @RequestMapping("/")
    public String welcome(){
        return "home";
    }
    private final GamesService gamesService;

    @Autowired
    public StartController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping("/{id}")
    public Games getGame(@PathVariable("id") Long ID){return gamesService.getGame(ID);}

    @PostMapping
    public Games saveGame(@RequestBody Games game){return gamesService.saveGame(game);}

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable("id") Long ID){ gamesService.deleteGame(ID);}

    @GetMapping("/orderByPrice")
    public List<Games> orderByPrice(@PathVariable("price") Double price){ return gamesService.orderByPrice(price);}
}
