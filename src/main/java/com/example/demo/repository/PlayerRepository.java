package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Player;


public interface PlayerRepository extends JpaRepository<Player, Integer>  {

	List<Player> findByteamOrderByIdDesc(int team);
	
	List<Player> findByteamOrderByIdAsc(int team);
	
}
