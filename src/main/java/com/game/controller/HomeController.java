package com.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.model.Game;
import com.game.model.TotalScore;
import com.game.service.ServiceException;
import com.game.service.interfaces.GameService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	GameService gameService;

	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/next")
	public String next() {
		return "next";
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", path = "/init")
	public ResponseEntity<Game> init() {
		HttpHeaders httpHeaders = new HttpHeaders();
		try {
			Game game = gameService.initGame();			
			return new ResponseEntity<Game>(game, httpHeaders, HttpStatus.CREATED);
			
		} catch (ServiceException e) {
			return new ResponseEntity<Game>(null, httpHeaders, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", path = "/play")
	public ResponseEntity<Game> play(@RequestBody Game game) {
		HttpHeaders httpHeaders = new HttpHeaders();
		try {
			game = gameService.playGame(game);			
			return new ResponseEntity<Game>(game, httpHeaders, HttpStatus.OK);			
		} catch (ServiceException e) {
			return new ResponseEntity<Game>(null, httpHeaders, HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Return a list of total score
	 * @return a list
	 */	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", path = "/score")	
	public ResponseEntity<TotalScore> getAllScore() {
		HttpHeaders httpHeaders = new HttpHeaders();
		try {
			TotalScore score = gameService.getScore();
			
			return new ResponseEntity<TotalScore>(score, httpHeaders, HttpStatus.OK);
			
		} catch (ServiceException e) {			
			return new ResponseEntity<TotalScore>(null, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}

}