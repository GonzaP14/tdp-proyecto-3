package entidadesGraficas;

import java.awt.Image;
import javax.swing.ImageIcon;

import entidadesLogicas.Posicion;

public class PrincipalGrafico extends PersonajeGrafico {
	
	private static final long serialVersionUID = 1L;
	
	public PrincipalGrafico(String[] imagenes) {
		 this.setBounds (100,100,25,25);
		 
		 sentidoArriba = new ImageIcon(this.getClass().getResource(imagenes[0]));
		 sentidoArriba = new ImageIcon(sentidoArriba.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		 
		 sentidoAbajo = new ImageIcon(this.getClass().getResource(imagenes[1]));
		 sentidoAbajo = new ImageIcon(sentidoAbajo.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		 
		 sentidoDerecha = new ImageIcon(this.getClass().getResource(imagenes[2]));
		 sentidoDerecha = new ImageIcon(sentidoDerecha.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		 
		 sentidoIzquierda = new ImageIcon(this.getClass().getResource(imagenes[3]));
		 sentidoIzquierda = new ImageIcon(sentidoIzquierda.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		 
		 muerto = new ImageIcon(this.getClass().getResource(imagenes[4]));
		 muerto = new ImageIcon(muerto.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)); // escalado
		 
	     miPrioridad = 2;
	     representacionActual = sentidoDerecha;
	     this.setIcon(representacionActual);
	}

	@Override
	public void desaparecer() {
		// TODO Auto-generated method stub
		
	}

}
