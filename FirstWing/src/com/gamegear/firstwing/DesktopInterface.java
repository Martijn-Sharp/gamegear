package com.gamegear.firstwing;

public class DesktopInterface implements GoogleInterface {

	@Override
	public void Login() {
		System.out.println("Desktop: would of logged in here");
	}

	@Override
	public void LogOut() {
		System.out.println("Desktop: would of logged out here");
	}

	@Override
	public boolean getSignedIn() {
		System.out.println("Desktop: getSignIn()");
		return false;
	}

	public void submitScore(long score) {
		System.out.println("Desktop: submitScore: " + score);
	}

	@Override
	public void getScores() {
		System.out.println("Desktop: getScores()");
	}

	@Override
	public void getScoresData(String leaderboard) {
		System.out.println("Desktop: getScoresData()");
	}

	@Override
	public void unlockAchievement(String achievement) {
		System.out.println("Desktop: Should have unlocked achievement id: " + achievement);
		
	}

	@Override
	public void incrementAchievement(String achievement, int steps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submitScore(String leaderboard, long highScore) {
		System.out.println("Desktop: submitScore: " + highScore);
	}
}
