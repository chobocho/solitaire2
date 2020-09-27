package com.chobocho.main;

import com.chobocho.solitaire.Solitare;

public class BoardProfile {
    final static int cardCount = 8;
    final static public int BG0 = 0;
    final static public int BG1 = 55;
    final static public int BG2 = 56;
    final static public int BG3 = 57;
    final static public int BG4 = 58;
    final static public int BG5 = 59;
    final static public int BG6 = 60;
    final static public int BG7 = 61;
    final static public int BG8 = 62;

    final static public int CONFIG_BUTTON = 5;

    public static int screenW = 1080;
    public static int screenH = 1820;
    public static int cardW = 120;
    public static int cardH = 180;
    public static int cardG = 10;
    public static int cardGapHeight = 10;
	
    public int bgImage;
    String version ="";

    public BoardProfile(String version, int width, int height) {
        bgImage = BG0;
        this.version = version;
        setScreenSize(width, height);
    }

    public void setScreenSize(int w, int h) {
        this.screenW = w;
        this.screenH = h;

        this.cardW = w/cardCount;
        this.cardH = (int) (this.cardW * 1.5);
        this.cardG = w/(cardCount*cardCount);
        this.cardGapHeight = (int)(this.cardH * 0.3);
    }

    public int screenWidth() {
        return this.screenW;
    }

    public int screenHeight() {
        return this.screenH;
    }

    public String getVersion() {
        return version;
    }	
    public int cardWidth() {
        return this.cardW;
    }

    public int cardHeight() {
        return this.cardH;
    }

    public int cardGap() {
        return this.cardG;
    }

    public int cardGapH() {
        return this.cardGapHeight;
    }

    public void setBG(int newBG) {
        bgImage = newBG;
    }

    public int getBG() {
        return bgImage;
    }

    public static int[] imageName = {
            R.drawable.bg,
            R.drawable.ca,
            R.drawable.c2,
            R.drawable.c3,
            R.drawable.c4,
            R.drawable.c5,
            R.drawable.c6,
            R.drawable.c7,
            R.drawable.c8,
            R.drawable.c9,
            R.drawable.c10,
            R.drawable.cj,
            R.drawable.cq,
            R.drawable.ck,
            R.drawable.da,
            R.drawable.d2,
            R.drawable.d3,
            R.drawable.d4,
            R.drawable.d5,
            R.drawable.d6,
            R.drawable.d7,
            R.drawable.d8,
            R.drawable.d9,
            R.drawable.d10,
            R.drawable.dj,
            R.drawable.dq,
            R.drawable.dk,
            R.drawable.ha,
            R.drawable.h2,
            R.drawable.h3,
            R.drawable.h4,
            R.drawable.h5,
            R.drawable.h6,
            R.drawable.h7,
            R.drawable.h8,
            R.drawable.h9,
            R.drawable.h10,
            R.drawable.hj,
            R.drawable.hq,
            R.drawable.hk,
            R.drawable.sa,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s6,
            R.drawable.s7,
            R.drawable.s8,
            R.drawable.s9,
            R.drawable.s10,
            R.drawable.sj,
            R.drawable.sq,
            R.drawable.sk,
            R.drawable.none,
            R.drawable.abg,
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3,
            R.drawable.bg4,
            R.drawable.bg5,
            R.drawable.bg6,
            R.drawable.bg7,
            R.drawable.bg8,
    };

    public int[] buttonImageName = {
            R.drawable.newgame,
            R.drawable.start,
            R.drawable.resume,
            R.drawable.pause,
            R.drawable.revert,
            R.drawable.config
    };

}
