package com.game.model;

public class Game {

	private int winPlayer1 = 0;

	private int winPlayer2 = 0;

	private int cont = 0;

	private String move1;

	private String move2;

	private String result;

	/**
	 * Constructor
	 */
	public Game() {
		this.cont = 0;
	}

	/**
	 * @return the winPlayer1
	 */
	public int getWinPlayer1() {
		return winPlayer1;
	}

	/**
	 * @param winPlayer1 the winPlayer1 to set
	 */
	public void setWinPlayer1(int winPlayer1) {
		this.winPlayer1 = winPlayer1;
	}

	/**
	 * @return the winPlayer2
	 */
	public int getWinPlayer2() {
		return winPlayer2;
	}

	/**
	 * @param winPlayer2 the winPlayer2 to set
	 */
	public void setWinPlayer2(int winPlayer2) {
		this.winPlayer2 = winPlayer2;
	}

	/**
	 * @return the cont
	 */
	public int getCont() {
		return cont;
	}

	/**
	 * @param cont the cont to set
	 */
	public void setCont(int cont) {
		this.cont = cont;
	}

	/**
	 * @return the move1
	 */
	public String getMove1() {
		return move1;
	}

	/**
	 * @param move1 the move1 to set
	 */
	public void setMove1(String move1) {
		this.move1 = move1;
	}

	/**
	 * @return the move2
	 */
	public String getMove2() {
		return move2;
	}

	/**
	 * @param move2 the move2 to set
	 */
	public void setMove2(String move2) {
		this.move2 = move2;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	
}
