package com.libgdx.battlecommander;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
 * Resources used:
 * https://github.com/libgdx/libgdx/wiki/Orthographic-camera
 * http://www.gamefromscratch.com/post/2014/05/01/LibGDX-Tutorial-11-Tiled-Maps-Part-2-Adding-a-character-sprite.aspx
 * https://github.com/mrdoob/three.js/issues/69
 * */


public class BattleCommander implements ApplicationListener{

	//HelloWorld
	private SpriteBatch sb;
	private BitmapFont text;
	
	
	@Override
	public void create() {
		
		//Floating version text.
		sb = new SpriteBatch();
		text = new BitmapFont();
		text.setColor(Color.WHITE);
		
		
		
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
        text.draw(sb,"Battle Commander ALPHA ver 0.2.0",10,10);
        //text.draw(sb,"Ryan Fleck 2017",50,80);
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
