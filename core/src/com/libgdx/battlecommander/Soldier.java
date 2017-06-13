package com.libgdx.battlecommander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.*;





public class Soldier extends Actor implements Unit{
	
	//Soldier position and direction:
	private int sx,sy;
	
	//Visual:
	private Texture sTex;
	
	//Soldier data:
	public boolean selected;
	
	public Soldier() {
		selected=false;
		sTex = new Texture(Gdx.files.internal("SoldierC/SoldierCd.png"));
		//System to check if mouse clicks unit:
		setBounds(sx,sy,32,32);
		addListener(
		new InputListener(){
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
		((Soldier)event.getTarget()).selected = true;
		((Soldier)event.getTarget()).RecieveFocus();
		return true;}});
	}

	@Override 
	public void draw(Batch batch, float alpha){
        batch.draw(sTex,sx,sy);
    }
	@Override
    public void act(float delta){
        if(selected){
            sx+=5;
        }
    }
	
	@Override
	public boolean Move(int coordX, int coordY) {
		MoveToAction movAct = new MoveToAction();
		
		return false;
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
