package audio;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	
	protected Clip miClip;
	protected AudioInputStream miMusica;
	protected AudioInputStream sonidoGameOver;
	
	protected static final int continuidadMusica = Clip.LOOP_CONTINUOUSLY;
	
	public Audio(int dominio) {
		if(dominio==0) {
			try {
				miMusica= AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/musicaMarioBros.wav"));
				sonidoGameOver=AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/gameOverMarioBros.wav"));
				miClip = AudioSystem.getClip();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		else {
			try {
				miMusica= AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/musicaSonic.wav"));
				sonidoGameOver=AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/gameOverSonic.wav"));
				miClip = AudioSystem.getClip();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
	public void iniciarMusica() {
		try {
			miClip.open(miMusica);
			FloatControl gainControl = (FloatControl) miClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15.0f); // Reduce el volumen en 15 decibeles.
			miClip.loop(continuidadMusica);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void despausar() {
		miClip.loop(Clip.LOOP_CONTINUOUSLY);
		miClip.start();
	}
}
