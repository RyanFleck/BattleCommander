package com.libgdx.battlecommander;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

/*
 * Resources used:
 * https://github.com/libgdx/libgdx/wiki/Orthographic-camera
 * http://www.gamefromscratch.com/post/2014/05/01/LibGDX-Tutorial-11-Tiled-Maps-Part-2-Adding-a-character-sprite.aspx
 * https://github.com/mrdoob/three.js/issues/69
 * */


public class BattleCommander extends ApplicationAdapter implements InputProcessor {
	
	//Map and camera:
	private TiledMap map;
	private OrthographicCamera cam;
	private TiledMapRenderer mapRenderer;
	private float scale = 2;
	
	//Sprites:
	private SpriteBatch sb;
	private Texture soldierTexture;
	private Sprite soldier;
	
	
	
	@Override
	public void create () {
		
		//BATTLE MAP INITIALIZATION:
		//Query width and height of window.
		float w = Gdx.graphics.getWidth()/scale;
		float h = Gdx.graphics.getHeight()/scale;
		
		//Initialize camera.
		cam = new OrthographicCamera();
		cam.setToOrtho(false,w,h);
		cam.update();
		
		//Initialize map.
		map = new TmxMapLoader().load("VirtMap1.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		Gdx.input.setInputProcessor(this);
		
		//SPRITE AND CHARACTER INITIALIZAITON:
		//SpriteBatch
		sb = new SpriteBatch();
		
		//Soldier:
		soldierTexture = new Texture(Gdx.files.internal("SoldierC.png"));
		soldier = new Sprite(soldierTexture);
		//soldier.setScale(scale);
		
	}

	@Override
	public void render () {
		adjustVariables();
		drawGraphics();
	}
	
	@Override
	public void dispose () {
		sb.dispose();
		

	}
	
	@Override
	public void resize(int width, int height){
		//cam.setToOrtho(false, width/scale, height/scale);
		
	}
	
	public void adjustVariables(){
		
		
	}
	
	public void drawGraphics(){
		
		//Map and background:
		Gdx.gl.glClearColor(0, 0, 0, 0);
	    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    cam.update();
	    mapRenderer.setView(cam);
	    mapRenderer.render();
	    
	    
	    //Sprites:
	    sb.setProjectionMatrix(cam.combined);
	    sb.begin();
	   
	    soldier.draw(sb);
	    sb.end();
	}
	
	@Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.LEFT)
            cam.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            cam.translate(32,0);
        if(keycode == Input.Keys.UP)
            cam.translate(0,32);
        if(keycode == Input.Keys.DOWN)
            cam.translate(0,-32);
        if(keycode == Input.Keys.NUM_1)
            map.getLayers().get(0).setVisible(!map.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            map.getLayers().get(1).setVisible(!map.getLayers().get(1).isVisible());
        return false;
    }

    @Override
    public boolean keyTyped(char character) {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	//Vector3 i = new Vector3(screenX,screenY,0);
    	//Vector3 j = cam.unproject(i); //.scl(scale);
    	//soldier.setPosition(j.x,j.y);
        //return true;
    	return false;
       
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    	Vector3 i = new Vector3(screenX,screenY,0);
    	Vector3 j = cam.unproject(i); //.scl(scale);
    	soldier.setPosition(j.x,j.y);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
	
	
}
