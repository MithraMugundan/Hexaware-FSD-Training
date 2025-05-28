package com.hexaware.codingchallange.ctms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Player Not Found for given playerId", code = HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends Exception {

	

}
