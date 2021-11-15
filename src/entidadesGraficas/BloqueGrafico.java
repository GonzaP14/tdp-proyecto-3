package entidadesGraficas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

import entidadesLogicas.DominioJuego;
import entidadesLogicas.Juego;

public class BloqueGrafico extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected final ImageIcon bloquePasillo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/bloqueNegro.png")));
	
	protected final ImageIcon paredMarioNivel1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl1Mario.png")));
	protected final ImageIcon paredMarioNivel2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl2Mario.png")));
	protected final ImageIcon paredMarioNivel3 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl3Mario.png")));
	protected final ImageIcon puertaMario = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/puertaMario.png")));
	
	protected final ImageIcon paredMemojiNivel1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl1Memoji.png")));
	protected final ImageIcon paredMemojiNivel2= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl2Memoji.png")));
	protected final ImageIcon paredMemojiNivel3= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl3Memoji.png")));
	protected final ImageIcon puertaMemoji= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/puertaMemoji.png")));
	
	public BloqueGrafico() {
		this.setBounds (0,0,25,25);
		ImageIcon negroEscalado = new ImageIcon(bloquePasillo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(negroEscalado);
	}
	
	public void setPared (int nivelActual, int dominio) {
		if (nivelActual == 1) {
			setParedNivel1(dominio);
		} else if (nivelActual == 2) {
			setParedNivel2(dominio);
		} else if (nivelActual == 3) {
			setParedNivel3(dominio);
		}
	}
	
	public void setParedNivel1(int dominio) {
		if(dominio == DominioJuego.dominioMarioBros) {
			ImageIcon pared = new ImageIcon(paredMarioNivel1 .getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		else if (dominio == DominioJuego.dominioMemoji) {
			ImageIcon pared = new ImageIcon(paredMemojiNivel1 .getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		
	}
	
	public void setParedNivel2(int dominio) {
		if (dominio == DominioJuego.dominioMarioBros) {
			ImageIcon pared = new ImageIcon(paredMarioNivel2 .getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		else if (dominio == DominioJuego.dominioMemoji) {
			ImageIcon pared = new ImageIcon(paredMemojiNivel2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
	}
	
	public void setParedNivel3(int dominio) {
		if (dominio == DominioJuego.dominioMarioBros) {
			ImageIcon pared = new ImageIcon(paredMarioNivel3 .getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		} else if (dominio == DominioJuego.dominioMemoji) {
			ImageIcon pared = new ImageIcon(paredMemojiNivel3.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
	}
	
	public void setPuerta(int dominio) {
		if (dominio == DominioJuego.dominioMarioBros) {
			ImageIcon puertas = new ImageIcon(puertaMario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(puertas);
		}
		else if (dominio == DominioJuego.dominioMemoji) {
			ImageIcon puertas = new ImageIcon(puertaMemoji.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(puertas);
		}
	}
	
}
