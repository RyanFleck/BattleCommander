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

/*
 * Resources used:
 * https://github.com/libgdx/libgdx/wiki/Orthographic-camera
 * http://www.gamefromscratch.com/post/2014/05/01/LibGDX-Tutorial-11-Tiled-Maps-Part-2-Adding-a-character-sprite.aspx
 * https://github.com/mrdoob/three.js/issues/69
 * */


public class BattleCommander implements ApplicationListener{
	
	
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
		
		//BCOM upper-left logo:
		BCOMLogo = new Texture(Gdx.files.internal("BComLogo.png"));
        BCOMSprite = new Sprite(BCOMLogo);
        float logoX = (Gdx.graphics.getWidth()-BCOMSprite.getWidth());
        float logoY = (Gdx.graphics.getHeight()-BCOMSprite.getHeight());
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
		
		//Set background color:
		
		Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
        
        
        sb.begin();//Use sprite-batch to draw..................................
        
        
        //Draw dynamic texture:
        crosshairSpr.setPosition((Gdx.graphics.getWidth()/2)-64,(Gdx.graphics.getHeight()/2)-64 );
        crosshairSpr.draw(sb);
        
        //Draw logo in upper right corner:
        BCOMSprite.draw(sb);
        
        //Draw version info:
        text.draw(sb,versionString,50,50);
        text.draw(sb,"BATTLE COMMANDER",50,70);
        
        
        sb.end();//End sprite-batch creation...................................
		
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


	
	
}
