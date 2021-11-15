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
	protected AudioInputStream sonido;
	
	protected static final int continuidadMusica = Clip.LOOP_CONTINUOUSLY;
	
	public Audio(int dominio) {
		if(dominio==0) {
			try {
				miMusica= AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/musicaMarioBros.wav"));
				miClip = AudioSystem.getClip();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		else {
			try {
				miMusica= AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/musicaMemoji.wav"));
				miClip = AudioSystem.getClip();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void resetMusica() {
		try {
			miMusica= AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/musicaMarioBros.wav"));
			miClip.open(miMusica);
			FloatControl gainControl = (FloatControl) miClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15.0f); // Reduce el volumen en 15 decibeles.
			miClip.loop(continuidadMusica);
			miClip.start();	
		} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
			e.printStackTrace();
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
	public void apagar() {
		miClip.close();
	}
	
	public void sonidoPerderVida() {
		 try {
			miClip.close();
			sonido=AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/perderVida.wav"));
			miClip.open(sonido);
			miClip.start();	
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sonidoGameOver() {
		 try {
			miClip.close();
			sonido=AudioSystem.getAudioInputStream(getClass().getResource("/recursosAudio/gameOver.wav"));
			miClip.open(sonido);
			miClip.start();	
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void despausar() {
		miClip.loop(Clip.LOOP_CONTINUOUSLY);
		miClip.start();
	}
	
	public void sonidoComerFantasmas() {
		
	}
	public void soindoPowerPelet() {
		
	}
	
}
