package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Top {
	
	float DondurmeDerecesi;
	float ZiplamaKatsayisi;
	float KordinatX;
	float KordinatY;
	float YerCekimiIvmesi;
	float IlerlemeKatsayisi;
	Rectangle EtkiAlani;
	Texture texture;
	Sprite sprite;
	
	public Top(){
		DondurmeDerecesi = 3;
		YerCekimiIvmesi = 0.2f;
		KordinatX = 150;
		KordinatY = 300;
		IlerlemeKatsayisi = 1.5f;
		texture = new Texture("logo.png");
		ZiplamaKatsayisi = 3;
		EtkiAlani = new Rectangle(KordinatX+5,KordinatY+5,40,40);
		sprite = new Sprite(texture);
		
		
	}
	void Ciz(SpriteBatch batch){
		
		sprite.draw(batch);
		
		//batch.draw(texture, KordinatX, KordinatY,50,50);
	
		
	}
	
	void Zipla() {
		
		ZiplamaKatsayisi = 5;
		
	}
	void Dondurme(){
		
		sprite.rotate(-DondurmeDerecesi);
		
	}
	
	void ZiplamaGuncelleme(){	
		Dondurme();
		KordinatlariGuncelle();
		KordinatX += IlerlemeKatsayisi;
		ZiplamaKatsayisi -= YerCekimiIvmesi;
		KordinatY += ZiplamaKatsayisi;
		
		
	}
	private void KordinatlariGuncelle() {
		
		sprite.setPosition(KordinatX, KordinatY);
		EtkiAlani.x = KordinatX+5;
		EtkiAlani.y = KordinatY+5;
		
	}
	
}



