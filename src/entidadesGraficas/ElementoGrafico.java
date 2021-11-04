package entidadesGraficas;

import java.awt.Image;

import javax.swing.ImageIcon;

import entidadesLogicas.Posicion;

public class ElementoGrafico extends EntidadGrafica {
	
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon sentidoFijo;
	
	public ElementoGrafico (String imagen) {
		setBounds(25, 25, 25, 25);
		sentidoFijo = new ImageIcon(this.getClass().getResource(imagen));
		sentidoFijo = new ImageIcon(sentidoFijo.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		
		miPrioridad = 1;
		representacionActual = sentidoFijo;
		this.setIcon(representacionActual);
	}
	
	public void aparecer(Posicion miPosicion) {
		this.setBounds(miPosicion.getX(), miPosicion.getY(), 25, 25);
		representacionActual = sentidoFijo;
		setIcon(representacionActual);
		
	}
	
	@Override
	public void actualizar(int sentido) {
		// TODO Auto-generated method stub
		
	}
	
}
