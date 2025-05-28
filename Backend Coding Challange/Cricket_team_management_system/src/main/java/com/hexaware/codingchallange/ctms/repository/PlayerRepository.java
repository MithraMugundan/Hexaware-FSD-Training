package com.hexaware.codingchallange.ctms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.codingchallange.ctms.entity.Player;

public interface PlayerRepository extends JpaRepository <Player,Long> {
	
	

}
