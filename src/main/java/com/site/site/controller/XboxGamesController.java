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
    public String xboxGames(Model model, @RequestParam(name = "genre", required = false) String genre, @RequestParam(name = "filter", required = false)String filter, @RequestParam(name = "sortOrder", required = false) String sortOrder){
        List<Games> xboxGames = null;
        if(genre !=null && !genre.isEmpty()){
            if(filter!=null && !filter.isEmpty()) {
                if(sortOrder.equals("ASC")) {
                    switch (filter) {
                        case("price") -> xboxGames = gamesService.orderByPriceAsc("XBOX", genre);
                        case("name") -> xboxGames = gamesService.orderByNameAsc("XBOX", genre);
                        case("releaseDate") -> xboxGames = gamesService.orderByReleaseDateAsc("XBOX", genre);
                    }
                }
                else {
                    switch (filter) {
                        case("price") -> xboxGames = gamesService.orderByPriceDesc("XBOX", genre);
                        case("name") -> xboxGames = gamesService.orderByNameDesc("XBOX", genre);
                        case("releaseDate") -> xboxGames = gamesService.orderByReleaseDateDesc("XBOX", genre);
                    }
                }
            }
            else xboxGames = gamesService.findAllByGenre(genre, "XBOX");
        } else if (filter != null && !filter.isEmpty()) {
            if (sortOrder.equals("ASC")) {
                switch (filter) {
                    case "price" -> xboxGames = gamesService.orderPlatByPriceAsc("XBOX");
                    case "name" -> xboxGames = gamesService.orderPlatByNameAsc("XBOX");
                    case "releaseDate" -> xboxGames = gamesService.orderPlatByReleaseDateAsc("XBOX");
                };
            } else {
                switch (filter) {
                    case "price" -> xboxGames = gamesService.orderPlatByPriceDesc("XBOX");
                    case "name" -> xboxGames = gamesService.orderPlatByNameDesc("XBOX");
                    case "releaseDate" -> xboxGames = gamesService.orderPlatByReleaseDateDesc("XBOX");
                };
            }
        }
        else xboxGames = gamesService.findAllByPlatform("XBOX");
        model.addAttribute("xboxgames", xboxGames);
        return "xboxgames";
    }
}
