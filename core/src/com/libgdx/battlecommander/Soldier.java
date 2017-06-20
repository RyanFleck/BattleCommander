package com.libgdx.battlecommander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;





@SuppressWarnings("unused")
public class Soldier extends Actor implements Unit{
	
	//Soldier position, size(pixels) and direction:
	private int sizeX,sizeY;
	
	//Visual:
	private Texture sTex;
	private Sprite sSprite;
	private Texture sTexR; //Running.
	private Sprite sSpriteR;
	//private SequenceAction tintBlueCycle;
	
	//Overhead info:
	//private BitmapFont text;
	//private FrameBuffer textGen;
	
	//Soldier data:
	private boolean selected;
	private boolean inMotion;
	private float destX,destY;
	private String sName;
	private BattleCommander bcom;
	
	//Action data:
	//private MoveToAction movAct;
	
	public Soldier(String name,BattleCommander bcommand) {
		
		//Initialize basic variables:
		sName		= name;
		bcom		= bcommand;
		selected	= true;
		inMotion	= false;
		sTex 		= new Texture(Gdx.files.internal("SoldierC/SoldierCd.png"));
		sSprite 	= new Sprite(sTex);
		sTexR 		= new Texture(Gdx.files.internal("SoldierC/SoldierCd.run.png"));
		sSpriteR 	= new Sprite(sTexR);
		sizeX		= sTex.getWidth();
		sizeY		= sTex.getHeight();
		
		//Statistic display instantiation:
		//text = new BitmapFont();
		//text.setColor(Color.CYAN);
		//textGen = new FrameBuffer(null, 32,32, true);
		
		//System to check if mouse clicks unit:
		setBounds(getX(),getY(),sizeX,sizeY);
		addListener(
		new InputListener(){
		@Override
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
		
		//Change system focus.
		bcom.getFocusedUnit().LoseFocus();
		((Soldier)event.getTarget()).RecieveFocus();
		bcom.setFocusedUnit(((Soldier)event.getTarget()));
		return true;}});
		
		/*
		//Set tint action:
		ColorAction tintToBlue = new ColorAction();
		tintToBlue.setColor(Color.CYAN);
		tintToBlue.setDuration(0.5f);
		ColorAction tintFromBlue = new ColorAction();
		tintFromBlue = tintToBlue;
		tintFromBlue.setReverse(true);
		tintBlueCycle = new SequenceAction(tintToBlue,tintFromBlue);
		*/
				
		
		
	}


	@Override 
	public void draw(Batch batch, float alpha){
		if(inMotion){
			batch.draw(sSpriteR,getX(),getY(),sizeX,sizeY);
			
		}else{
			batch.draw(sSprite,getX(),getY(),sizeX,sizeY);
    }}
		
	@Override
	public boolean Move(int coordX, int coordY) {
		if(!inMotion && selected){
			
			//Prevent simultaneous actions:
			inMotion=true;
			selected=false;
			destX=coordX;
			destY=coordY;
			
			//Flip texture if moving left/right:
			if(getX()>coordX){
				sSprite.setFlip(true, false);
				sSpriteR.setFlip(true, false);
			}else{
				sSprite.setFlip(false, false);
				sSpriteR.setFlip(false, false);
			}
			//Snap coordinates to squares:
			destX=destX-(destX%32);
			destY=destY-(destY%32)+3;
			
			
			//Movement action:
			Db("Moving to: "+destX+","+destY);
			MoveToAction movAct = new MoveToAction();
			movAct.setPosition(destX, destY);
			Vector2 i = new Vector2((destX-getX()),(destY-getY()));
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
		selected=true;
		/*	FAILED EXPERIMENTS. REATTEMPTING SOON.
		this.sSprite.setAlpha(0.2f);
		this.sSprite.setColor(Color.CYAN);
		this.sSpriteR.setColor(Color.CYAN);
		this.addAction(tintBlueCycle);
		this.addAction(Actions.color(Color.BLACK, 0.5f));
		this.addAction(Actions.fadeOut(0.5f));
		*/
		return false;
	}

	@Override
	public boolean LoseFocus() {
		Db("Focus lost!");
		selected=false;
		//this.sSprite.setColor(Color.WHITE);
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
		System.out.println(sName+" DEBUGMSG: "+message);
	}
	
	
}
