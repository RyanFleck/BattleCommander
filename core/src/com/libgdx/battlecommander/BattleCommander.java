package com.libgdx.battlecommander;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
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
	
	
	
	@Override
	public void create() {
		
		//CHANGE THIS AS IS APPLICABLE:
		versionString = "ALPHA ver 0.2.0";
		
		//Floating version text.
		
		sb = new SpriteBatch();
		text = new BitmapFont();
		text.setColor(Color.WHITE);
		
		//BCOM upper-left logo:
		BCOMLogo = new Texture(Gdx.files.internal("BComLogo.png"));
        BCOMSprite = new Sprite(BCOMLogo);
		
		
		
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
		
        
        //Use sprite-batch to draw.
        sb.begin();
        text.draw(sb,versionString,50,50);
        text.draw(sb,"BATTLE COMMANDER",50,70);
        sb.end();
		
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
		
	}


	
	
}
