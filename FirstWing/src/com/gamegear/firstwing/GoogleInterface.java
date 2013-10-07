package com.gamegear.firstwing;

public interface GoogleInterface {

	public void Login();
	public void LogOut();

	//get if client is signed in to Google+
	public boolean getSignedIn();

	//submit a score to a leaderboard
	public void submitScore(long score);
	public void submitScore(String leaderboard, long highScore);

	//gets the scores and displays them threw googles default widget
	public void getScores();

	//gets the score and gives access to the raw score data
	public void getScoresData(String leaderboard);
	
	public void unlockAchievement(String achievement);
	public void incrementAchievement(String achievement, int steps);
	
	public void getLeaderboard();
}
