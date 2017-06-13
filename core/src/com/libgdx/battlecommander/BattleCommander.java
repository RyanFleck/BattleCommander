package com.libgdx.battlecommander;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

/*
 * Resources used:
 * https://github.com/libgdx/libgdx/wiki/Orthographic-camera
 * http://www.gamefromscratch.com/post/2014/05/01/LibGDX-Tutorial-11-Tiled-Maps-Part-2-Adding-a-character-sprite.aspx
 * https://github.com/mrdoob/three.js/issues/69
 * 
 * Things to learn about:
 * -Texture atlas and sprite-packers, for simple animation. 
 * */


public class BattleCommander implements ApplicationListener{
	
	
	//Window parameters:
	private int winX,winY;
	
	//Frame monitoring:
	private long frames;
	private int fps=1;
	private long time=0;
	private String fString="",fpsString="";
	
	//HelloWorld objects:
	private SpriteBatch sb;
	private BitmapFont text;
	private String versionString;
	
	//Simple texture test:
	private Texture BCOMLogo;
	private Sprite BCOMSprite;
	
	//Dynamic texture test:
	private Pixmap pixmap;
	private Texture crosshairTex;
	private Sprite crosshairSpr;
	
	
	
	
	@Override
	public void create() {
		
		//Code to create version readout.
		// TODO Modify version number as needed:
		versionString = "ALPHA ver 0.2.0";
		sb = new SpriteBatch();
		text = new BitmapFont();
		text.setColor(Color.CYAN);
		winX=Gdx.graphics.getWidth();
		winY=Gdx.graphics.getHeight();
		
		//BCOM upper-left logo:
		BCOMLogo = new Texture(Gdx.files.internal("BComLogo.png"));
        BCOMSprite = new Sprite(BCOMLogo);
        float logoX = (winX-BCOMSprite.getWidth());
        float logoY = (winY-BCOMSprite.getHeight());
        BCOMSprite.setPosition(logoX,logoY);
		
        //Dynamic texture test:
		pixmap = new Pixmap(128,128, Pixmap.Format.RGBA8888);
		pixmap.setColor(Color.CYAN);
		pixmap.drawLine(0, 0, pixmap.getWidth(), pixmap.getHeight());
        pixmap.drawLine(0, pixmap.getHeight(), pixmap.getWidth(), 0);
        pixmap.drawCircle(pixmap.getWidth()/2, pixmap.getHeight()/2, pixmap.getHeight()/2 - 1);
        pixmap.drawCircle(pixmap.getWidth()/2, pixmap.getHeight()/2, pixmap.getHeight()/3 - 1);
        crosshairTex= new Texture(pixmap);
        crosshairSpr= new Sprite(crosshairTex);
        pixmap.dispose();
        
        
		
	}

	@Override
	public void resize(int width, int height){
		System.out.println("BCM: Resized window to "+width+" by "+height);
		//cam.setToOrtho(false, width/scale, height/scale);
		
	}

	@Override
	public void render() {
		queryInput();//Checks keyboard and mouse for input.
		adjustVars();//Accounts for input and performs respective actions.
		//Set background color:
		Gdx.gl.glClearColor(0.15f,0.15f,0.15f,1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
        //Potentially needed for when resizable window is implemented.
        //winX=Gdx.graphics.getWidth();
		//winY=Gdx.graphics.getHeight();
        
        sb.begin();//Use sprite-batch to draw..................................
        
        
        
        
        
        
        
        
        
        
        
        //Draw dynamic texture:
        crosshairSpr.setPosition((winX-150),10);
        crosshairSpr.draw(sb);
        
        //Draw logo in upper right corner:
        BCOMSprite.draw(sb);
        
        //Draw version info:
        monitorFrames();
        text.draw(sb,fString,10,winY-8);
        text.draw(sb,fpsString,10,winY-22);
        text.draw(sb,versionString,50,50);
        text.draw(sb,"2017 Ryan Fleck",50,70);
        
        
        sb.end();//End sprite-batch creation...................................
		
	}

	private void adjustVars() {
		// TODO Auto-generated method stub
		
	}

	private void queryInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
	
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void dispose() {
		sb.dispose();
		text.dispose();
		BCOMLogo.dispose();
		
	}

	public void monitorFrames() {
		frames++;
		
		fString=("Frame "+frames);
		
		if (TimeUtils.timeSinceNanos(time) > 1000000000) {
			 time = TimeUtils.nanoTime();
			 fpsString=("FPS: "+fps);
			 fps=0;
		}else{fps++;}
	}

	
	
}
