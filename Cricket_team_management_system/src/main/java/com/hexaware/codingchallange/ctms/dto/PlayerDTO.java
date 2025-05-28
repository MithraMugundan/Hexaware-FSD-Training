package com.hexaware.codingchallange.ctms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PlayerDTO {


	@NotNull(message = "Player ID cannot be null")
    @Min(value = 1, message = "Player ID must be greater than 0")
    private Long playerId;

    @NotBlank(message = "Player name cannot be blank")
    private String playerName;

    @NotNull(message = "Jersey number cannot be null")
    @Min(value = 0, message = "Jersey number must be zero or positive")
    private Integer jerseyNumber;

    @NotBlank(message = "Role cannot be blank")
    @Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder", 
             message = "Role must be one of Batsman, Bowler, Keeper, All Rounder")
    private String role;
   
    private Integer totalMatches;

   
    private String teamName;

    private String stateName;

   
    private String description;


	public PlayerDTO(Long playerId, String playerName, Integer jerseyNumber, String role, Integer totalMatches,
			String teamName, String stateName, String description) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.stateName = stateName;
		this.description = description;
	}


	public Long getPlayerId() {
		return playerId;
	}


	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public Integer getJerseyNumber() {
		return jerseyNumber;
	}


	public void setJerseyNumber(Integer jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Integer getTotalMatches() {
		return totalMatches;
	}


	public void setTotalMatches(Integer totalMatches) {
		this.totalMatches = totalMatches;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "PlayerDTO [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
				+ ", role=" + role + "]";
	}


	


	
}
