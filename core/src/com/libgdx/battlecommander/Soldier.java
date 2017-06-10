package com.libgdx.battlecommander;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
	private float x,y,nextx,nexty,xdis=0,ydis=0,speed,pitchVar;
	private long stepID;
	private SpriteBatch sb;
	private Sprite sSprite;
	private boolean xMovLock=true,yMovLock=true;
	private Sound step;
	private Random r;
	
	public Soldier(SpriteBatch globalSpriteBatch,float spawnx,float spawny){
		x=spawnx;
		y=spawny;
		nextx=x;
		nexty=y;
		System.out.println("Soldier spawned!");
		sb = globalSpriteBatch;
		sTex = new Texture(Gdx.files.internal("SoldierC/SoldierC.png"));
		sSprite = new Sprite(sTex);
		sSprite.setCenter(16, 16);
		sSprite.setOriginCenter();
		speed=5;
		step = Gdx.audio.newSound(Gdx.files.internal("sound/step.wav"));
		r = new Random();
		pitchVar = 0.1f*r.nextFloat();
		
		//this.Move((int)x,(int)y);
	}
	public void render(){
		if(x!=nextx && xMovLock==false){
			
			step.setPitch(stepID, 1+pitchVar);
			xdis= Math.abs(x-nextx);
			if(xdis<=9){
				xdis=0;
				x=nextx;
				xMovLock=true;}
			else if(x>nextx)
				x-=speed;
			else if(x<nextx)
				x+=speed;
			
		}else if(y!=nexty && yMovLock==false){
			ydis= Math.abs(y-nexty);
			if(ydis<=9){
				ydis=0;
				y=nexty;
				yMovLock=true;
			}
			if(y>nexty)
				y-=speed;
			else if(y<nexty)
				y+=speed;
		
			
		}
		
		if(xMovLock==true && yMovLock==true){
			step.stop();
		}
		
		
		sSprite.setX(x);
		sSprite.setY(y);
		sSprite.draw(sb);
	}
	
	@Override
	public boolean Move(int coordA, int coordB) {
		if(xMovLock==true && yMovLock==true){
			
		
		nextx = Math.round(coordA);
		nexty = Math.round(coordB);
		xMovLock=false;
		yMovLock=false;
		System.out.println("Moving from ("+x+","+y+") to ("+nextx+","+nexty+").");
		try {
			long millis = r.nextInt(100);
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stepID = step.loop();
		return true;}else{return false;}
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
