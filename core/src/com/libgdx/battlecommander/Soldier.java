package com.libgdx.battlecommander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;





public class Soldier extends Actor implements Unit{
	
	//Soldier position, size(pixels) and direction:
	private int sizeX,sizeY;
	
	//Visual:
	private Texture sTex;
	private Sprite sSprite;
	
	//Soldier data:
	public boolean selected;
	public boolean inMotion;
	public float destX,destY;
	
	//Action data:
	//private MoveToAction movAct;
	
	public Soldier() {
		
		//Initialize basic variables:
		selected=false;
		inMotion=false;
		sTex = new Texture(Gdx.files.internal("SoldierC/SoldierCd.png"));
		sSprite = new Sprite(sTex);
		sizeX=sTex.getWidth();
		sizeY=sTex.getHeight();
		
		//System to check if mouse clicks unit:
		setBounds(getX(),getY(),sizeX,sizeY);
		addListener(
		new InputListener(){
		@Override
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
		((Soldier)event.getTarget()).selected = true;
		((Soldier)event.getTarget()).RecieveFocus();
		return true;}});
		
				
		
		
	}

	@Override 
	public void draw(Batch batch, float alpha){
        batch.draw(sSprite,getX(),getY(),sizeX,sizeY);
    }
		
	@Override
	public boolean Move(int coordX, int coordY) {
		if(!inMotion){
			
			//Prevent simultaneous actions:
			inMotion=true;
			destX=coordX;
			destY=coordY;
			
			//Flip texture if moving left/right:
			if(getX()>coordX)
				sSprite.setFlip(true, false);
			else
				sSprite.setFlip(false, false);
			
			//Movement action:
			Db("Moving to: "+coordX+","+coordY);
			MoveToAction movAct = new MoveToAction();
			movAct.setPosition(coordX, coordY);
			Vector2 i = new Vector2((coordX-getX()),(coordY-getY()));
			movAct.setDuration(i.len()/300);
			Soldier.this.addAction(movAct);
		}else{
			Db("Command ignored, soldier is in motion.");
		}
		
		
		return true;
	}
	
	@Override
	public void act(float delta) {
	    super.act(delta);
	    if(destX==getX() && destY==getY())
	    	inMotion=false;
	}
	
	@Override
	public boolean Attack(int coordX, int coordY, int[] range) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean RecieveFocus() {
		Db("Focus attained!");
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

	public void Db(String message) {
		System.out.println("Soldier.java DEBUGMSG: "+message);
	}
	
	
}
