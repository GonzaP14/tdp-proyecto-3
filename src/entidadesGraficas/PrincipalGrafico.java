package entidadesGraficas;

import java.awt.Image;
import javax.swing.ImageIcon;
import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public class PrincipalGrafico extends PersonajeGrafico {
	private static final long serialVersionUID = 1L;
	
	public PrincipalGrafico(ImageIcon[] imagenes) {
		 sentidoIzquierda = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioIzquierda.gif"));
	     sentidoDerecha = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioDerecha.gif"));
	     sentidoArriba = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioArriba.gif"));
	     sentidoAbajo = new ImageIcon(this.getClass().getResource("/recursosImagenes/MarioAbajo.gif"));
	     miPrioridad = 2;
	     this.setBounds (100,100,25,25);
	     representacionActual = new ImageIcon(sentidoDerecha.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
	     this.setIcon(representacionActual);
	}
}
