package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	OrthographicCamera kamera;
    int KameraGenislik;
    int KameraUzunluk;
	BitmapFont font;
    static int OyunSkor;
    static boolean Oyun_Durum;
    static boolean OYUN_DEVAM = true;
    static boolean OYUN_DURDU = false;
    
    DunyaKontroller dunyaKontrolleri;
    ShapeRenderer shaperenderer;
    @Override
	public void create () {
    	Oyun_Durum = OYUN_DEVAM;
    	Gdx.input.setInputProcessor(this);
    	OyunSkor = 0;
    	batch = new SpriteBatch();
        KameraGenislik = 200*4;
        KameraUzunluk = 200*3;
        kamera = new OrthographicCamera(KameraGenislik,KameraUzunluk);
        kamera.position.set(kamera.viewportWidth/2,kamera.viewportHeight/2,0);
        kamera.update();
        font = new BitmapFont();
		font.getData().setScale(1.5f);
        dunyaKontrolleri = new DunyaKontroller();
    	shaperenderer = new ShapeRenderer();
        
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(kamera.combined);
		kamera.update();
		
		batch.begin();
		if(Oyun_Durum)
			OyunMantigi();
		
		
		OyunGrafikleri();
		
		font.draw(batch,"Oyun Skor: "+OyunSkor,(kamera.position.x-kamera.viewportWidth/2)+30,30);
		
		batch.end();
		
		
	/*	
	 *  shaperenderer.setProjectionMatrix(kamera.combined);
		shaperenderer.begin(ShapeType.Line);
		shaperenderer.rect(dunyaKontrolleri.top.EtkiAlani.x,dunyaKontrolleri.top.EtkiAlani.y,
				dunyaKontrolleri.top.EtkiAlani.height,
				dunyaKontrolleri.top.EtkiAlani.width);
		
		for(Nesne nesne : dunyaKontrolleri.Nesneler){
		shaperenderer.rect(nesne.EtkiAlani.x,nesne.EtkiAlani.y,
				nesne.EtkiAlani.height,
				nesne.EtkiAlani.width);
		}
		shaperenderer.end();
		
		*/
		
		
	}
	
	private void OyunGrafikleri() {
		
		dunyaKontrolleri.Ciz(batch);
	}

	private void OyunMantigi() {
		
		dunyaKontrolleri.OyunMantigiGuncelle(System.nanoTime(),kamera.position.x-kamera.viewportWidth/2);
		kamera.position.x+=1.5f;	
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	Vector3 worldCoordinates;
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		worldCoordinates = kamera.unproject(new Vector3(screenX, screenY, 0));
		
		System.out.println(worldCoordinates.x +"   "+worldCoordinates.y);
		dunyaKontrolleri.ZiplamaGerceklestir();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
