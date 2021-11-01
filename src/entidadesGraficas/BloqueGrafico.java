package entidadesGraficas;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;
import entidadesLogicas.Entidad;

public class BloqueGrafico extends JPanel{
	
	protected final ImageIcon bloqueNegro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	protected final ImageIcon paredVertical = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	protected final ImageIcon paredHorizontal = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	protected final ImageIcon esquinaArribaDerecha = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	protected final ImageIcon esquinaArribaIzquierda = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	protected final ImageIcon esquinaAbajoDerecha = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	protected final ImageIcon esquinaAbajoIzquierda = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));

	
	private EntidadGrafica miEntidadGrafica;
	private JLabel fondoBloque;
	private boolean puedeVisitarse;
	
	public BloqueGrafico( ArrayList<Entidad> listaEntidades) {
		fondoBloque = bloqueNegro;
		puedeVisitarse=true;
		actualizar(listaEntidades);	
	}
	
	public BloqueGrafico( ) {
		fondoBloque = bloqueNegro;
		puedeVisitarse=true;
		miEntidadGrafica = null;
	}
	
	
	public void actualizar(ArrayList<Entidad> listaEntidades ) {
		for(Entidad entidad : listaEntidades ) {
			if(entidad.getMiRepresentacion().getMiPrioridad() > miEntidadGrafica.getMiPrioridad() ) {
				//Ver si deberiamos usar clone aca
				miEntidadGrafica = entidad.getMiRepresentacion();
			}
		}
	}
	public void setBloqueParedVertical() {
		fondoBloque.setIcon(paredVertical);
		puedeVisitarse=false;
	}
	public void setBloqueParedHorizontal() {
		fondoBloque.setIcon(paredHorizontal);
		puedeVisitarse=false;
	}
	public void setBloqueEsquinaArribaDerecha() {
		fondoBloque.setIcon(esquinaArribaDerecha);
		puedeVisitarse=false;
	}
	public void setBloqueEsquinaArribaIzquierda() {
		fondoBloque.setIcon(esquinaArribaIzquierda);
		puedeVisitarse=false;
	}
	public void setBloqueEsquinaAbajoDerecha() {
		fondoBloque.setIcon(esquinaAbajoDerecha);
		puedeVisitarse=false;
	}
	public void setBloqueEsquinaAbajoIzquierda() {
		fondoBloque.setIcon(esquinaAbajoIzquierda);
		puedeVisitarse=false;
	}
	
}
