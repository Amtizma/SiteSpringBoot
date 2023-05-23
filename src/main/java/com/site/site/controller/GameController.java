package com.site.site.controller;

import com.site.site.Service.GamesService;
import com.site.site.entity.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@Controller
public class GameController {
    @Autowired
    public GameController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    private final GamesService gamesService;
    @RequestMapping("/game/{name}")
    public String showGame(Model model, @PathVariable("name") String name) throws UnsupportedEncodingException {
        String decodedName = URLDecoder.decode(name, "UTF-8");
        Games game = gamesService.getGameByName(decodedName);
        model.addAttribute("game", game);
        return "game";
    }
}
