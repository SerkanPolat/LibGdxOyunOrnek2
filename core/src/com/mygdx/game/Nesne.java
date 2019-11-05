package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Nesne {

	float KordinatX;
	float KordinatY;
	float Genislik;
	float Yukseklik;
	int Zararli;
	Rectangle EtkiAlani;
	Texture texture;
	Random rnd;
	public Nesne(float x,float y,int Zararli){
		rnd = new Random();
		Genislik = 45;
		Yukseklik = 45;
		KordinatX = x;
		KordinatY = y;
		this.Zararli = Zararli;
		EtkiAlani = new Rectangle(x+5,y+5,Genislik-10,Yukseklik-10);
		
		if(Zararli<3){
			ZararliNesneOlusumu();
		}else{
			ZararsizNesneOlusumu();
		}
		
	}
	private void ZararsizNesneOlusumu() {
		
		texture = new Texture("s"+(rnd.nextInt(5)+1)+".png");
		
	}
	private void ZararliNesneOlusumu() {
		

		texture  = new Texture("diken.png");
		
		
	}
	public void Ciz(SpriteBatch batch){
		
		batch.draw(texture,KordinatX,KordinatY,Genislik,Yukseklik);
		
	}
	
}
