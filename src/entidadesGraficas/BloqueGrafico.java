package entidadesGraficas;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import entidadesLogicas.Entidad;

public class BloqueGrafico extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected final ImageIcon bloqueNegro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/bloqueNegro.png")));
	protected final ImageIcon paredeslvl1= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl1.png")));
	protected final ImageIcon paredeslvl2= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl2.png")));
	protected final ImageIcon paredeslvl3= new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/paredLvl3.png")));

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
	
	
	public void setBloqueParedLvl1() {
		ImageIcon pared = new ImageIcon(paredeslvl1.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(pared);
	}
	public void setBloqueParedLvl2() {
		ImageIcon pared = new ImageIcon(paredeslvl2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(pared);
	}
	public void setBloqueParedLvl3() {
		ImageIcon pared = new ImageIcon(paredeslvl3.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		this.setIcon(pared);
	}

	
	
	
}
