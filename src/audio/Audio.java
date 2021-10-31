package audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

public class Audio {
	
	protected Clip miClip;
	protected AudioInputStream miMusica;
	protected AudioInputStream sonido;
	
	protected static final int continuidadMusica = Clip.LOOP_CONTINUOUSLY;
	
	public Audio() {
		
	}
	
	public void iniciarMusica() {
		
	}
	
	public boolean estaPausado() {
		return false;
	}
	
	public void pausar() {
		
	}
	
	public void sonidoMuerte() {
		
	}
	
	public void sonidoComer() {
		
	}
	
}
