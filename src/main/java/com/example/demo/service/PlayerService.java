package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Player;

public interface PlayerService {
	List<Player> findByteamOrderByIdDesc(int team);
	
	List<Player> findByteamOrderByIdAsc(int team);
	
	List<Player> findAll();
}
