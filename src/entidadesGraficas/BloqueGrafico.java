package entidadesGraficas;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import entidadesLogicas.Entidad;

public class BloqueGrafico extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected final ImageIcon bloquePasillo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/bloqueNegro.png")));
	protected final ImageIcon paredeslvl1Mario= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/paredLvl1Mario.png")));
	protected final ImageIcon paredeslvl2Mario= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/paredLvl2Mario.png")));
	protected final ImageIcon paredeslvl3Mario= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/paredLvl3Mario.png")));
	protected final ImageIcon puertaMario= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosMarioBros/puertaMario.png")));
	
	protected final ImageIcon paredeslvl1Sonic= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosSonic/paredLvl1Sonic.png")));
	protected final ImageIcon paredeslvl2Sonic= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosSonic/paredLvl2Sonic.png")));
	protected final ImageIcon paredeslvl3Sonic= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosSonic/paredLvl3Sonic.png")));
	protected final ImageIcon puertaSonic= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosSonic/puertaSonic.png")));
	

	public BloqueGrafico() {
		this.setBounds (0,0,25,25);
		ImageIcon negroEscalado = new ImageIcon(bloquePasillo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(negroEscalado);
	}
	
	public void setPared (int nivelActual, int dominio) {
		if (nivelActual == 1) {
			setParedLvl1(dominio);
		} else if (nivelActual == 2) {
			setParedLvl2(dominio);
		} else if (nivelActual == 3) {
			setParedLvl3(dominio);
		}
	}
	
	

	
	public void setParedLvl1(int dominio) {
		if(dominio==0) {
			ImageIcon pared = new ImageIcon(paredeslvl1Mario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		else {
			ImageIcon pared = new ImageIcon(paredeslvl1Sonic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		
	}
	public void setParedLvl2(int dominio) {
		if(dominio==0) {
			ImageIcon pared = new ImageIcon(paredeslvl2Mario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		else {
			ImageIcon pared = new ImageIcon(paredeslvl2Sonic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
	}
	public void setParedLvl3(int dominio) {
		if(dominio==0) {
			ImageIcon pared = new ImageIcon(paredeslvl3Mario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		else {
			ImageIcon pared = new ImageIcon(paredeslvl3Sonic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
	}
	public void setPuerta(int dominio) {
		if(dominio==0) {
			ImageIcon puertas = new ImageIcon(puertaMario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(puertas);
		}
		else {
			ImageIcon puertas = new ImageIcon(puertaSonic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(puertas);
		}
	}
	
	
	
}