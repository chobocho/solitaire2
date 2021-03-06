package com.chobocho.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import com.chobocho.command.CommandEngine;
import com.chobocho.solitaire.Solitare;
import com.chobocho.solitaire.SolitareImpl;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";

    Solitare solitare;
    CommandEngine cmdEngine;
    CardgameView gameView;
    BoardProfile boardProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(gameView);
    }

    protected void init() {
        String version = getVersion();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        ((Display) display).getSize(size);
        int width = size.x;
        int height = size.y;

        boardProfile = new BoardProfile(version, width, height);
        solitare = new SolitareImpl(new AndroidLog());
        cmdEngine = new CommandEngine(solitare);
        gameView = new CardgameView(this, boardProfile, solitare, cmdEngine);
        solitare.register(gameView);
    }

    private String getVersion() {
        try {
            PackageInfo pkgInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pkgInfo.versionName;
            Log.i(TAG, "Version Name : "+ version);
            return version;
        } catch(PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.i(TAG, e.toString());
        }
        return "";
    }

    @Override
    public void onPause() {
        super.onPause();
        if (gameView != null) {
            gameView.pauseGame();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (gameView != null) {
            gameView.resumeGame();
        }
    }
}
