package com.hexaware.codingchallange.ctms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "players")
public class Player {
	    @Id
	    @NotNull(message = "Player ID cannot be null")
	    private Long playerId;

	   
	    private String playerName;

	   
	    private Integer jerseyNumber;

	   
	    private String role; //  Batsman, Bowler, Keeper, All Rounder

	   
	    private Integer totalMatches;

	   
	    private String teamName;

	    private String stateName;

	   
	    private String description;

	
	    public Player() {}


	    
		public Player(@NotNull(message = "Player ID cannot be null") Long playerId, String playerName,
				Integer jerseyNumber, String role, Integer totalMatches, String teamName, String stateName,
				String description) {
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
	    
	    
	
}
