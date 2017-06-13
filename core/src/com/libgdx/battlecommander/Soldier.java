package com.libgdx.battlecommander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;





public class Soldier extends Actor implements Unit{
	
	//Soldier position, size(pixels) and direction:
	private int sizeX,sizeY;
	
	//Visual:
	private Texture sTex;
	
	//Soldier data:
	public boolean selected;
	public boolean inMotion;
	
	//Action data:
	//private MoveToAction movAct;
	
	public Soldier() {
		
		//Initialize basic variables:
		selected=false;
		inMotion=false;
		sTex = new Texture(Gdx.files.internal("SoldierC/SoldierCd.png"));
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
        batch.draw(sTex,getX(),getY(),sizeX,sizeY);
    }
		
	@Override
	public boolean Move(int coordX, int coordY) {
		if(!inMotion){
			//inMotion=true;
			Db("Moving to: "+coordX+","+coordY);
			MoveToAction movAct = new MoveToAction();
			movAct.setPosition(coordX, coordY);
			//movAct.setPosition(  (coordX/2)-16, ((Gdx.graphics.getHeight()-coordY)/2)-16);
			//double distance = Math.sqrt(  coordX^2 + coordY^2  );
			//movAct.setDuration((float) (distance*10));
			movAct.setDuration(3f);
			
			Soldier.this.addAction(movAct);
		}else{
			Db("Command ignored, soldier is in motion.");
		}
		return true;
	}
	
	@Override
	public void act(float delta) {
	    super.act(delta);
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
