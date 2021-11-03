package entidadesGraficas;

import java.awt.Image;
import javax.swing.ImageIcon;
import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public class PrincipalGrafico extends PersonajeGrafico {
	private static final long serialVersionUID = 1L;
	
	public PrincipalGrafico(ImageIcon[] imagenes) {
		this.setBounds(25, 25, 25, 25);
		sentidoArriba = new ImageIcon(imagenes[0].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoAbajo = new ImageIcon(imagenes[1].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoIzquierda = new ImageIcon(imagenes[2].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		sentidoDerecha = new ImageIcon(imagenes[3].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		muerto = new ImageIcon(imagenes[4].getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		
		miPrioridad = 2;
	}
}
