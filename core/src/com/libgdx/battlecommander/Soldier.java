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
	
<<<<<<< HEAD
<<<<<<< HEAD
	public Soldier(SpriteBatch globalSpriteBatch,float spawnx,float spawny){
		x=spawnx;
		y=spawny;
		nextx=x;
		nexty=y;
=======
=======
>>>>>>> parent of c30ff48... Re-implemented soldier with unique class and sprite.
	public Soldier(SpriteBatch globalSpriteBatch){
		System.out.println("Soldier spawned!");
>>>>>>> parent of c30ff48... Re-implemented soldier with unique class and sprite.
		sb = globalSpriteBatch;
		sTex = new Texture(Gdx.files.internal("SoldierC.png"));
		sSprite = new Sprite(sTex);
		sSprite.setCenter(16, 16);
		sSprite.setOriginCenter();
		sSprite.setX(x);
		sSprite.setY(y);
<<<<<<< HEAD
<<<<<<< HEAD
		speed=5;
		System.out.println("Soldier spawned!");
=======
>>>>>>> parent of c30ff48... Re-implemented soldier with unique class and sprite.
=======
>>>>>>> parent of c30ff48... Re-implemented soldier with unique class and sprite.
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
<<<<<<< HEAD
<<<<<<< HEAD
		nextx = Math.round(coordA);
		nexty = Math.round(coordB);
		xMovLock=false;
		yMovLock=false;
		System.out.println("Moving from ("+x+","+y+") to ("+nextx+","+nexty+").");
		
		return true;
=======
=======
>>>>>>> parent of c30ff48... Re-implemented soldier with unique class and sprite.
		nextx = coordA;
		nexty = coordB;
		x=nextx;
		y=nexty;
		
		sSprite.setX(x-16);
		sSprite.setY(y-16);
		return false;
<<<<<<< HEAD
>>>>>>> parent of c30ff48... Re-implemented soldier with unique class and sprite.
=======
>>>>>>> parent of c30ff48... Re-implemented soldier with unique class and sprite.
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
