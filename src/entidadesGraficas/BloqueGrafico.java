package entidadesGraficas;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import entidadesLogicas.Entidad;

public class BloqueGrafico extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected final ImageIcon bloqueNegro = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/recursosImagenes/bloqueNegro.png")));
	//protected final ImageIcon paredVertical = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
    //	protected final ImageIcon paredHorizontal = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	//protected final ImageIcon esquinaArribaDerecha = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	//protected final ImageIcon esquinaArribaIzquierda = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	//protected final ImageIcon esquinaAbajoDerecha = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));
	//protected final ImageIcon esquinaAbajoIzquierda = new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource()));

	
	// private EntidadGrafica miEntidadGrafica;
	// private JLabel fondoBloque;
	private boolean puedeVisitarse;
	
	public BloqueGrafico( ArrayList<Entidad> listaEntidades) {
		
		/*
		JLabel negro = new JLabel();
		negro.setBounds(0, 0, 30, 30);				
		negro.setBorder(new LineBorder(Color.gray));
		ImageIcon imagenNegra = bloqueNegro;
		ImageIcon img = new ImageIcon(imagenNegra.getImage().getScaledInstance(negro.getWidth(), negro.getHeight(), Image.SCALE_SMOOTH));
		negro.setIcon(img);	
		*/
		
		//miEntidadGrafica = null;
		//fondoBloque = negro;
		
		puedeVisitarse=true;
		//actualizar(listaEntidades);	
	}
	
	public BloqueGrafico() {
		/*
		JLabel negro = new JLabel();
		negro.setBounds(0, 0, 30, 30);				
		negro.setBorder(new LineBorder(Color.gray));
		ImageIcon imagenNegra = bloqueNegro;
		ImageIcon img = new ImageIcon(imagenNegra.getImage().getScaledInstance(negro.getWidth(), negro.getHeight(), Image.SCALE_SMOOTH));
		negro.setIcon(img);	
		
		
		fondoBloque = negro;
		puedeVisitarse=true;
		miEntidadGrafica = null;
		*/
	
		puedeVisitarse = true;
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
	
	/*
	public JLabel getFondoBLoque() {
		return fondoBloque;
	}
	*/
	
	/*public void setBloqueParedVertical() {
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
	
	*/
}
