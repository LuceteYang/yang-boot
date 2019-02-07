package com.example.demo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Player;
import com.example.demo.service.impl.PlayerServiceImpl;

@RestController
public class PlayerController {
	@Autowired
	PlayerServiceImpl companyService;

	@GetMapping("/players")
    public List<Player> players() {
		
        return companyService.findAll();
    }
	
	@GetMapping("/players/{team}/desc")
    public List<Player> teamPlayersDESC(@PathVariable int team) {

        return companyService.findByteamOrderByIdDesc(team);
    }
	@GetMapping("/players/{team}/asc")
    public List<Player> teamPlayersASC(@PathVariable int team) {

        return companyService.findByteamOrderByIdAsc(team);
    }

}