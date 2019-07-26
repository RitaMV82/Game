package com.game.service.interfaces;

import com.game.model.Game;
import com.game.model.TotalScore;
import com.game.service.ServiceException;

public interface GameService {
	
	Game initGame() throws ServiceException;
	
	Game playGame(Game game) throws ServiceException;
	
	void addScore(Game game) throws ServiceException;
	
	TotalScore getScore() throws ServiceException;
	
}
