package com.hexaware.codingchallange.ctms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.codingchallange.ctms.dto.PlayerContext;
import com.hexaware.codingchallange.ctms.dto.PlayerDTO;
import com.hexaware.codingchallange.ctms.entity.Player;
import com.hexaware.codingchallange.ctms.exception.PlayerNotFoundException;
import com.hexaware.codingchallange.ctms.repository.PlayerRepository;


@Service
public class PlayerServiceImp implements IPlayerService {
	
	@Autowired
	PlayerRepository repo;

	@Override
	public Player addPlayer(PlayerDTO playerDTO) {

		Player player = new Player();
			player.setPlayerId(playerDTO.getPlayerId());
			player.setPlayerName(playerDTO.getPlayerName());
			player.setJerseyNumber(playerDTO.getJerseyNumber());
	        player.setRole(playerDTO.getRole());
	        player.setTotalMatches(playerDTO.getTotalMatches());
	        player.setTeamName(playerDTO.getTeamName());
	        player.setStateName(playerDTO.getStateName());
	        player.setDescription(playerDTO.getDescription());
	        return repo.save(player);
		

	}

	@Override
	public Player updatePlayer(Long playerId, PlayerDTO playerDTO) {
		 Optional<Player> optionalPlayer = repo.findById(playerId);
		    
		    if (optionalPlayer.isPresent()) {
		        Player player = optionalPlayer.get();

		        // 2. Update player fields from playerDTO
		        player.setPlayerName(playerDTO.getPlayerName());
		        player.setJerseyNumber(playerDTO.getJerseyNumber());
		        player.setRole(playerDTO.getRole());
		        player.setTotalMatches(playerDTO.getTotalMatches());
		        player.setTeamName(playerDTO.getTeamName());
		        player.setStateName(playerDTO.getStateName());
		        player.setDescription(playerDTO.getDescription());

		        // 3. Save updated player back to DB
		        return repo.save(player);
		    } else {
		        // Player not found, return null or throw custom exception
		        return null;
		    }
		
	}

	

	@Override
	public Player getPlayerById(Long playerId) {
		return repo.findById(playerId).orElse(null);
	}

	@Override
	public String deletePlayerByID(Long playerId) {
		repo.deleteById(playerId);
        return "Player deleted";
	}

	public static boolean validatePlayerData(PlayerDTO playerDTO) {
	    boolean flag = false;

	    if (playerDTO.getPlayerId() != null && playerDTO.getPlayerId() > 0 &&
	        playerDTO.getPlayerName() != null && !playerDTO.getPlayerName().trim().isEmpty() &&
	        playerDTO.getJerseyNumber() != null && playerDTO.getJerseyNumber() >= 0 &&
	        playerDTO.getRole() != null && List.of("Batsman", "Bowler", "Keeper", "All Rounder").contains(playerDTO.getRole()) &&
	        playerDTO.getTotalMatches() != null && playerDTO.getTotalMatches() >= 0 &&
	        playerDTO.getTeamName() != null && !playerDTO.getTeamName().trim().isEmpty() &&
	        playerDTO.getStateName() != null && !playerDTO.getStateName().trim().isEmpty()) {
	        
	        flag = true;
	    }

	    return flag;
	}

	@Override
	public List<PlayerContext> getAllPlayerContext() {
	    List<Player> players = repo.findAll();
	    List<PlayerContext> summaries = new ArrayList<>();

	    for (Player p : players) {
	        PlayerContext pc = new PlayerContext();
	        pc.setPlayerId(p.getPlayerId());
	        pc.setPlayerName(p.getPlayerName());
	        pc.setJerseyNumber(p.getJerseyNumber());
	        pc.setRole(p.getRole());

	        summaries.add(pc);
	    }

	    return summaries;

	}

	@Override
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}

	
	
	
	

}
