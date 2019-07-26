package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.game.model.Game;
import com.game.model.TotalScore;
import com.game.service.GameServiceImpl;
import com.game.service.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
public class GamerServiceTest {
	
	@InjectMocks
	GameServiceImpl gameService;
	
	Game game;
	
	TotalScore score = new TotalScore();
	
	@Test
	public void testInitGame() throws ServiceException {
		game = gameService.initGame();
		
		assertNotNull(game);
        assertEquals(game.getCont(), 0);
	}	
	
	@Test
	public void testDraw() throws ServiceException {
		
		int result = gameService.compareMoves("S", "S");		
		assertEquals(result, 0);
		assertNotEquals(result, 1);
		assertNotEquals(result, -1);
		
		result = gameService.compareMoves("P", "P");		
		assertEquals(result, 0);
		assertNotEquals(result, 1);
		assertNotEquals(result, -1);
		
		result = gameService.compareMoves("P", "P");		
		assertEquals(result, 0);
		assertNotEquals(result, 1);
		assertNotEquals(result, -1);
		
	}
	
	@Test
	public void testWinPlayer1() throws ServiceException {
		
		int result = gameService.compareMoves("R", "S");		
		assertEquals(result, 1);
		assertNotEquals(result, 0);
		assertNotEquals(result, -1);
		
		result = gameService.compareMoves("P", "R");		
		assertEquals(result, 1);
		assertNotEquals(result, 0);
		assertNotEquals(result, -1);
		
		result = gameService.compareMoves("S", "P");		
		assertEquals(result, 1);
		assertNotEquals(result, 0);
		assertNotEquals(result, -1);
		
	}
	
	@Test
	public void testWinPlayer2() throws ServiceException {
		
		int result = gameService.compareMoves("S", "R");		
		assertEquals(result, -1);
		assertNotEquals(result, 0);
		assertNotEquals(result, 1);
		
		result = gameService.compareMoves("P", "S");		
		assertEquals(result, -1);
		assertNotEquals(result, 0);
		assertNotEquals(result, 1);
		
		result = gameService.compareMoves("R", "P");		
		assertEquals(result, -1);
		assertNotEquals(result, 0);
		assertNotEquals(result, 0);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testMovesAreNull() {
		gameService.compareMoves(null, null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testMove1IsNull() {
		gameService.compareMoves(null, "R");
	}
	
	@Test(expected = NullPointerException.class)
	public void testMove2IsNull() {
		gameService.compareMoves("R", null);
	}
	
	@Test
	public void testGetScore() throws ServiceException{
		score = gameService.getScore();
		assertNotNull(score);
		assertEquals(score.getTotalDraw(), 0);
		assertEquals(score.getTotalWinPlayer1(), 0);
		assertEquals(score.getTotalWinPlayer2(), 0);
		assertEquals(score.getTotalRounds(), 0);
		
	}
	
	@Test
	public void testAddScoreDraw()  throws ServiceException {
		
		Game g1 = new Game();
		g1.setResult("Draw");
		
		gameService.addScore(g1);		
		score = gameService.getScore();
		
		assertEquals(score.getTotalDraw(), 1);
		assertEquals(score.getTotalWinPlayer1(), 0);
		assertEquals(score.getTotalWinPlayer2(), 0);
		assertEquals(score.getTotalRounds(), g1.getCont()+1);
		
	}
	
	@Test
	public void testAddScoreWinPlayer1()  throws ServiceException {
		
		Game g1 = new Game();
		g1.setResult("Win Player1");
		
		gameService.addScore(g1);		
		score = gameService.getScore();
		
		assertEquals(score.getTotalDraw(), 0);
		assertEquals(score.getTotalWinPlayer1(), 1);
		assertEquals(score.getTotalWinPlayer2(), 0);
		assertEquals(score.getTotalRounds(), g1.getCont()+1);		
	}
	
	@Test
	public void testAddScoreWinPlayer2()  throws ServiceException {
		
		Game g1 = new Game();
		g1.setResult("Win Player2");
		
		gameService.addScore(g1);		
		score = gameService.getScore();
		
		assertEquals(score.getTotalDraw(), 0);
		assertEquals(score.getTotalWinPlayer1(), 0);
		assertEquals(score.getTotalWinPlayer2(), 1);
		assertEquals(score.getTotalRounds(), g1.getCont()+1);		
	}
	
	
	
}
