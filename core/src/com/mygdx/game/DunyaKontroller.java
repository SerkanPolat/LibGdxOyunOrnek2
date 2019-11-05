package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DunyaKontroller {
	
	long NesneOlusturmaZamani;
	ArrayList<Nesne>Nesneler;
	Texture ArkaPlan;
	Top top;
	int NesneSayisi;
	Random rnd;
	float ArkaPlanX;
	
	public DunyaKontroller(){
		NesneOlusturmaZamani = 0;
		rnd = new Random();
		NesneSayisi = 10;
		Nesneler = new ArrayList<Nesne>();
		top = new Top();
		ArkaPlan = new Texture("back.png");
	}
	
	private void NesnelerOlustur() {
		boolean CakismaVar = false;
			Nesne OlusanNesne = new Nesne(500+top.KordinatX+rnd.nextInt(500),rnd.nextInt(550),rnd.nextInt(4));
			for(int i =0;i<Nesneler.size();i++){
				
				if(OlusanNesne.EtkiAlani.overlaps(Nesneler.get(i).EtkiAlani)){
					CakismaVar = true;
					
					break;
					
				}
			}
			
			
			if(!CakismaVar){
				Nesneler.add(OlusanNesne);
				NesneOlusturmaZamani = System.nanoTime();
			}
			return;
	
	}

	public void Ciz(SpriteBatch batch){

		batch.draw(ArkaPlan, ArkaPlanX, 0);
		for(Nesne nesne : Nesneler){
			nesne.Ciz(batch);
		}
		top.Ciz(batch);
	}
	public void OyunMantigiGuncelle(long SystemTime,float kameraX) {
		
		top.ZiplamaGuncelleme();
		CarpismaKontrolcusu();
		if(SystemTime-NesneOlusturmaZamani>1000000000/2)
			NesnelerOlustur();
		ArkaPlanX = kameraX;
	}
	
	
	private void CarpismaKontrolcusu() {
		
		for(int i = 0;i<Nesneler.size();i++){
			if(top.EtkiAlani.overlaps(Nesneler.get(i).EtkiAlani)){
				
				if(Nesneler.get(i).Zararli<3){
					
					System.out.println("OyunBitti");

					/*
					 * 
					  Nesneler.clear();
					  return;
					 *
					 */
					
					MyGdxGame.Oyun_Durum = MyGdxGame.OYUN_DURDU;
					
				}else{
					MyGdxGame.OyunSkor++;
					Nesneler.remove(Nesneler.get(i));
				}
			}
		}
		
		if(top.KordinatY<-30||top.KordinatY>605){
			MyGdxGame.Oyun_Durum = MyGdxGame.OYUN_DURDU;
		}
		
		System.out.println(top.KordinatY);
		
	}
	public void ZiplamaGerceklestir(){
		top.Zipla();
	}
	
}
