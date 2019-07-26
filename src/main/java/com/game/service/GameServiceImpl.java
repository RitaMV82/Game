package com.game.service;

import org.springframework.stereotype.Component;

import com.game.model.Game;
import com.game.model.Machine;
import com.game.model.TotalScore;
import com.game.service.interfaces.GameService;

@Component
public class GameServiceImpl implements GameService {
	
	TotalScore score = new TotalScore();
	
	/**
	 * Init a game
	 */
	public Game initGame() throws ServiceException {
		return new Game();
	}
	
	/**
	 * Play a game
	 * @param game
	 * @return game with new moves
	 */
	public synchronized Game playGame(Game game) throws ServiceException {
		Machine machine = new Machine();			
		game.setMove1(machine.getMachineMove());
		game.setMove2("R");
		
		int compareMoves = compareMoves(game.getMove1(),game.getMove2());
		switch (compareMoves) {
		case 0: 
		    game.setResult("Draw");
		    break;
		case 1: 		  
			 game.setResult("Win Player1");
			 game.setWinPlayer1(game.getWinPlayer1()+1);		   
		    break;
		case -1: 
			game.setResult("Win Player2");		    
			game.setWinPlayer2(game.getWinPlayer2()+1);
		    break;
		}		
		game.setCont(game.getCont()+1);		
		addScore(game);
		
		return game;
	}
	
	
	/***
	 * Compare move
	 * @param move1
	 * @param move2
	 * @return 0 Draw, 1 win move1, -1 win move2
	 */
	public int compareMoves(String move1, String move2) {
		
        if (move1.equals(move2))
            return 0;
        
        if(move1.equals("R")) {
        	 return (move2.equals("S") ? 1 : -1);
        } else if(move1.equals("P")) {
        	 return (move2.equals("R") ? 1 : -1);
        } else if (move1.equals("S")) {
        	 return (move2.equals("P") ? 1 : -1);
        } else {
        	return 0;
        }

	}

	/**
	 * Add a new score 
	 * @param game
	 */
	public synchronized void addScore(Game game) throws ServiceException {	
		
		score.setTotalRounds(score.getTotalRounds()+1);
		
		if(game.getResult().equals("Win Player1")) {
			score.setTotalWinPlayer1(score.getTotalWinPlayer1()+1);
		}
		
		if(game.getResult().equals("Win Player2")) {
			score.setTotalWinPlayer2(score.getTotalWinPlayer2()+1);
		}
		
		score.setTotalDraw(score.getTotalRounds() - (score.getTotalWinPlayer1() + score.getTotalWinPlayer2()));
		
	}
	
	/**
	 * Get score of game
	 * return score
	 */
	public TotalScore getScore() throws ServiceException {
		return score;
	}
}
