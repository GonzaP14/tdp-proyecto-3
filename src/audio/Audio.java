package audio;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import entidadesLogicas.DominioJuego;

public class Audio {
	
	protected Clip miClip;
	protected AudioInputStream miMusica;
	protected AudioInputStream sonidoGameOver;
	protected DominioJuego miDominio;
	
	public Audio(DominioJuego miDominio) {
		this.miDominio = miDominio;
		
		try {
			miMusica= AudioSystem.getAudioInputStream(getClass().getResource(miDominio.getMusica()));
			sonidoGameOver=AudioSystem.getAudioInputStream(getClass().getResource(miDominio.getSonidoGameOver()));
			miClip = AudioSystem.getClip();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}	
	}
		
	public void iniciarMusica() {
		try {
			miClip.open(miMusica);
			FloatControl gainControl = (FloatControl) miClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15.0f); // Reduce el volumen en 15 decibeles.
			miClip.loop(Clip.LOOP_CONTINUOUSLY);
			miClip.start();	
		} catch (IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public boolean estaPausado() {
		return false;
	}
	
	public void pausar() {
		miClip.stop();
	}

	public void sonidoGameOver() {
		 try {
			miClip.close();
			miClip.open(sonidoGameOver);
			miClip.start();	
		} catch (IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void despausar() {
		miClip.loop(Clip.LOOP_CONTINUOUSLY);
		miClip.start();
	}
}
