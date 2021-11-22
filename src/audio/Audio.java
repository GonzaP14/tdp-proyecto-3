package audio;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import dominios.DominioJuego;

public class Audio {
	
	protected Clip miClip;
	protected AudioInputStream miMusica;
	protected AudioInputStream sonidoGameOver;
	protected AudioInputStream sonidoWin;
	protected DominioJuego miDominio;
	
	public Audio(DominioJuego miDominio) {
		this.miDominio = miDominio;
		
		try {
			miMusica= AudioSystem.getAudioInputStream(getClass().getResource(miDominio.getMusica()));
			sonidoGameOver=AudioSystem.getAudioInputStream(getClass().getResource(miDominio.getSonidoGameOver()));
			sonidoWin=AudioSystem.getAudioInputStream(getClass().getResource(miDominio.getSonidoWin()));
			miClip = AudioSystem.getClip();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Utilizado para iniciar la musica del juego
	 */
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
	
	/**
	 * Utilizado para reproducir el sonido cuando el jugador pierda
	 */
	public void sonidoGameOver() {
		 try {
			miClip.close();
			miClip.open(sonidoGameOver);
			miClip.start();	
		} catch (IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Utilizado para reproducir el sonido cuando el jugador gana
	 */
	public void sonidoWin() {
		 try {
			miClip.close();
			miClip.open(sonidoWin);
			miClip.start();	
		} catch (IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Utilizado para mutear el juego
	 */
	public void mutear() {
		if(miClip.isRunning()==true) {
			miClip.stop();
		}
		else {
			miClip.loop(Clip.LOOP_CONTINUOUSLY);
			miClip.start();
		}		
	}
}
