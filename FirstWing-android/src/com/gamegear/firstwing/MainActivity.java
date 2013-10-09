package com.gamegear.firstwing;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;

public class MainActivity extends AndroidApplication implements
		GameHelperListener, GoogleInterface {

	private GameHelper aHelper;
	private OnLeaderboardScoresLoadedListener theLeaderboardListener;

	public MainActivity() {
		aHelper = new GameHelper(this);
		aHelper.enableDebugLog(true, "Play Services");

		// create a listener for getting raw data back from leaderboard
		theLeaderboardListener = new OnLeaderboardScoresLoadedListener() {

			public void onLeaderboardScoresLoaded(int arg0,
					LeaderboardBuffer arg1, LeaderboardScoreBuffer arg2) {

				System.out.println("In call back");

				for (int i = 0; i < arg2.getCount(); i++) {
					System.out.println(arg2.get(i).getScoreHolderDisplayName()
							+ " : " + arg2.get(i).getDisplayScore());
				}
			}
		};
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useGL20 = false;
		aHelper.setup(this);

		initialize(new FirstWing(this), cfg);
	}

	@Override
	public void onStart() {
		super.onStart();
		aHelper.onStart(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		aHelper.onStop();
	}

	@Override
	public void onActivityResult(int request, int response, Intent data) {
		super.onActivityResult(request, response, data);
		aHelper.onActivityResult(request, response, data);
	}

	public void onSignInFailed() {
		System.out.println("sign in failed");
	}

	public void onSignInSucceeded() {
		System.out.println("sign in succeeded");
	}

	public void Login() {
		try {
			runOnUiThread(new Runnable() {

				// @Override
				public void run() {
					aHelper.beginUserInitiatedSignIn();
				}
			});
		} catch (final Exception ex) {

		}
	}

	public void LogOut() {
		try {
			runOnUiThread(new Runnable() {

				// @Override
				public void run() {
					aHelper.signOut();
				}
			});
		} catch (final Exception ex) {

		}

	}

	public boolean getSignedIn() {
		return aHelper.isSignedIn();
	}

	public void submitScore(long _score) {
		System.out.println("in submit score");
		aHelper.getGamesClient().submitScore(getString(R.string.leaderboard_total),
				_score);
		//startActivityForResult(aHelper.getGamesClient().getLeaderboardIntent(getString(R.string.leaderboard_total)), 105);
	}
	
	@Override
	public void submitScore(String leaderboard, long highScore) {
		aHelper.getGamesClient().submitScore(leaderboard, highScore);
	}

	public void getScores() {
		startActivityForResult(
				aHelper.getGamesClient().getLeaderboardIntent(
						getString(R.string.leaderboard_total)), 105);
	}

	public void getScoresData(String leaderboard) {
		aHelper.getGamesClient().loadPlayerCenteredScores(
				theLeaderboardListener, getString(R.string.leaderboard_total), 1,
				1, 25);
	}
	
	public void unlockAchievement(String achievement) {
		System.out.println("in submit score");
		aHelper.getGamesClient().unlockAchievement(achievement);
	}

	@Override
	public void incrementAchievement(String achievement, int steps) {
		aHelper.getGamesClient().incrementAchievement(achievement, steps);
	}

	@Override
	public void getLeaderboard() {
		//resetLeaderboards();
		startActivityForResult(aHelper.getGamesClient().getLeaderboardIntent(getString(R.string.leaderboard_total)), 105);
	}
	
	@Override
	public void getLeaderboard(String leaderboard) {
		startActivityForResult(aHelper.getGamesClient().getLeaderboardIntent(leaderboard), 105);
	}
	
	
	public void resetLeaderboards()
    {
        if( aHelper.isSignedIn() )
        {
            String accountName = aHelper.getGamesClient().getCurrentAccountName();      
            String scopes = aHelper.getScopes();

            new ResetterTask(this, accountName, scopes).execute((Void) null);
        }
    }

    private class ResetterTask extends AsyncTask<Void, Void, Void>
    {
        public String mAccountName;
        public String mScope;
        public Context mContext;

        public ResetterTask(Context con, String name, String sc)
        {
            mContext = con;
            mAccountName = name;
            mScope = sc;
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            try
            {
                String accesstoken = GoogleAuthUtil.getToken(mContext, mAccountName, mScope);

                HttpClient client = new DefaultHttpClient();                
                //Reset leader board:
                String leaderboardid = "CgkIhpLNkp8BEAIQDQ";
                HttpPost post = new HttpPost
                        (
                            "https://www.googleapis.com"+
                            "/games/v1management"+
                            "/leaderboards/"+
                            leaderboardid+
                            "/scores/reset?access_token="+accesstoken
                        );

                //Reset a single achievement like this:
                /*
                String acheivementid = "acheivementid";
                HttpPost post = new HttpPost
                        (
                            "https://www.googleapis.com"+
                            "/games/v1management"+
                            "/achievements/"+
                            acheivementid+
                            "/reset?access_token="+accesstoken
                        );*/

                //This resets all achievements:
//                HttpPost post = new HttpPost
//                        (
//                            "https://www.googleapis.com"+
//                            "/games/v1management"+
//                            "/achievements"+
//                            "/reset?access_token="+accesstoken
//                        );


                client.execute(post);
                Log.w("Reset", "Reset achievements done.");
            }
            catch(Exception e)
            {
                Log.e("Reset", "Failed to reset: " + e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            //Launch activity to refresh data on client.
            //NOTE: Incremental achievements will look like they are not reset.
            //However, next time you and some steps it will start from 0 and
            //gui will look ok.
            //startActivityForResult(aHelper.getGamesClient().getAchievementsIntent(), 0);
        	startActivityForResult(aHelper.getGamesClient().getLeaderboardIntent(getString(R.string.leaderboard_total)), 105);
        }
    }
	
}