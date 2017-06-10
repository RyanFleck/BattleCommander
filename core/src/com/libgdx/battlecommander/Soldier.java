package com.libgdx.battlecommander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author rflec028
 *
 */
public class Soldier extends Actor implements Unit{

	private Texture sTex;
	private float x,y,nextx,nexty;
	private SpriteBatch sb;
	private Sprite sSprite;
	
	public Soldier(SpriteBatch globalSpriteBatch){
		System.out.println("Soldier spawned!");
		sb = globalSpriteBatch;
		sTex = new Texture(Gdx.files.internal("SoldierC.png"));
		sSprite = new Sprite(sTex);
		sSprite.setOriginCenter();
		sSprite.setX(x);
		sSprite.setY(y);
	}
	public void render(){
		sSprite.draw(sb);
	}
	
	@Override
	public void spawn(int coordX, int coordY) {
		x=coordX;
		y=coordY;
	}
	
	@Override
	public boolean Move(int coordA, int coordB) {
		nextx = coordA;
		nexty = coordB;
		x=nextx;
		y=nexty;
		
		sSprite.setX(x);
		sSprite.setY(y);
		return false;
	}

	@Override
	public boolean Attack(int coordA, int coordB, int[] range) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean RecieveFocus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean LoseFocus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String Info() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void PrintDebugInfo() {
		// TODO Auto-generated method stub
		
	}

	
	
}
