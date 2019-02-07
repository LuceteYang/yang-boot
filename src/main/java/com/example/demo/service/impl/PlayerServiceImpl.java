package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PlayerRepository;
import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
    private PlayerRepository repositoryService;
	
	public List<Player> findByteamOrderByIdDesc(int team){
		return repositoryService.findByteamOrderByIdDesc(team);
	};
	
	public List<Player> findByteamOrderByIdAsc(int team){
		return repositoryService.findByteamOrderByIdAsc(team);
	};
	
	public List<Player> findAll(){
		return repositoryService.findAll();
	};
}
