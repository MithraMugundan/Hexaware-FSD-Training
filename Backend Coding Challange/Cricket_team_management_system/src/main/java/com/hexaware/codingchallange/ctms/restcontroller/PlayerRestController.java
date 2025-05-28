package com.hexaware.codingchallange.ctms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.codingchallange.ctms.dto.PlayerContext;
import com.hexaware.codingchallange.ctms.dto.PlayerDTO;
import com.hexaware.codingchallange.ctms.entity.Player;
import com.hexaware.codingchallange.ctms.exception.PlayerNotFoundException;
import com.hexaware.codingchallange.ctms.service.IPlayerService;
import com.hexaware.codingchallange.ctms.service.PlayerServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	
	@Autowired 
	IPlayerService service;
	
	@PostMapping("/addPlayer")
	public Player addPlayer(@RequestBody PlayerDTO playerDTO) {

	    boolean isValid = PlayerServiceImp.validatePlayerData(playerDTO);

	    Player player = null;

	    if (isValid) {
	        player = service.addPlayer(playerDTO);
	    }

	    return player;
	}

	
	
	  @GetMapping("/get/{playerId}")
	    public Player getPlayerById(@PathVariable Long playerId) throws PlayerNotFoundException {
	        Player player = service.getPlayerById(playerId);

	        if (player == null) {
	            throw new PlayerNotFoundException();
	        }

	        return player;
	    }
	  @DeleteMapping("/delete/{playerId}")
	    public String deleteById(@PathVariable Long playerId) {
	        return service.deletePlayerByID(playerId);
	    }
	  
	  @GetMapping("/getall")
	  public List<Player> getAll() {
	      return service.getAllPlayers();
	  }
	  
	  @PutMapping("/update/{playerId}")
	    public Player updatePlayer(@PathVariable Long playerId, @RequestBody @Valid PlayerDTO playerDTO) {
	        return service.updatePlayer(playerId, playerDTO);
	    }
	  
	  @GetMapping("/getall/context")
	    public List<PlayerContext> getAllPlayerContext() {
	        return service.getAllPlayerContext();
	    }

}
