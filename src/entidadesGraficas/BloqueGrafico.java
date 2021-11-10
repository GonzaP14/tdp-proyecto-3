package entidadesGraficas;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import entidadesLogicas.Entidad;

public class BloqueGrafico extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected final ImageIcon bloqueNegro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/bloqueNegro.png")));
	protected final ImageIcon paredeslvl1Mario= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl1Mario.png")));
	protected final ImageIcon paredeslvl2Mario= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl2Mario.png")));
	protected final ImageIcon paredeslvl3Mario= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl3Mario.png")));
	protected final ImageIcon puertaMario= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/puertaMario.png")));
	
	protected final ImageIcon paredeslvl1Memoji= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl1Memoji.png")));
	protected final ImageIcon paredeslvl2Memoji= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl2Memoji.png")));
	protected final ImageIcon paredeslvl3Memoji= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl3Memoji.png")));
	protected final ImageIcon puertaMemoji= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/puertaMemoji.png")));
	
	public BloqueGrafico( ArrayList<Entidad> listaEntidades) {
		this.setBounds (250,250,25,25);
		ImageIcon negroEscalado = new ImageIcon(bloqueNegro.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(negroEscalado);
	}
	public BloqueGrafico() {
		this.setBounds (0,0,25,25);
		ImageIcon negroEscalado = new ImageIcon(bloqueNegro.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(negroEscalado);
	}
	
	
	/*
	public void actualizar(ArrayList<Entidad> listaEntidades ) {
		for(Entidad entidad : listaEntidades ) {
			if(entidad.getMiRepresentacion().getMiPrioridad() > miEntidadGrafica.getMiPrioridad() ) {
				//Ver si deberiamos usar clone aca
				miEntidadGrafica = entidad.getMiRepresentacion();
			}
		}
	}
	*/
	
	
	public void setBloqueParedLvl1(int dominio) {
		if(dominio==0) {
			ImageIcon pared = new ImageIcon(paredeslvl1Mario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		else {
			ImageIcon pared = new ImageIcon(paredeslvl1Memoji.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		
	}
	public void setBloqueParedLvl2(int dominio) {
		if(dominio==0) {
			ImageIcon pared = new ImageIcon(paredeslvl2Mario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		else {
			ImageIcon pared = new ImageIcon(paredeslvl2Memoji.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
	}
	public void setBloqueParedLvl3(int dominio) {
		if(dominio==0) {
			ImageIcon pared = new ImageIcon(paredeslvl3Mario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
		else {
			ImageIcon pared = new ImageIcon(paredeslvl3Memoji.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(pared);
		}
	}
	public void setPuerta(int dominio) {
		if(dominio==0) {
			ImageIcon puertas = new ImageIcon(puertaMario.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(puertas);
		}
		else {
			ImageIcon puertas = new ImageIcon(puertaMemoji.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			this.setIcon(puertas);
		}
	}
	
	
	
}
