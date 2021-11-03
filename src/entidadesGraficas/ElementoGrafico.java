package entidadesGraficas;

import java.awt.Image;

import javax.swing.ImageIcon;

import entidadesLogicas.Posicion;

public class ElementoGrafico extends EntidadGrafica {
	
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon sentidoFijo;
	
	public ElementoGrafico (ImageIcon miRepresentacionGrafica) {
		setBounds(25, 25, 25, 25);
		sentidoFijo = new ImageIcon(miRepresentacionGrafica.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
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
