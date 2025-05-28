package com.hexaware.codingchallange.ctms.service;

import java.util.List;

import com.hexaware.codingchallange.ctms.dto.PlayerContext;
import com.hexaware.codingchallange.ctms.dto.PlayerDTO;
import com.hexaware.codingchallange.ctms.entity.Player;

public interface IPlayerService {
	
	 public Player addPlayer(PlayerDTO playerDTO);

	    public Player updatePlayer(Long playerId, PlayerDTO playerDTO);

	    public List<Player> getAllPlayers();

	    public Player getPlayerById(Long playerId);

	    public String deletePlayerByID(Long playerId);
	    
	    List<PlayerContext> getAllPlayerContext();
	    
	    List<Player> findByTeamName(String teamName);

}
