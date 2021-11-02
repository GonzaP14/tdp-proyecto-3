package entidadesGraficas;

import javax.swing.ImageIcon;

public class ElementoGrafico extends EntidadGrafica {
	
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon sentidoFijo;
	
	public ElementoGrafico (ImageIcon miRepresentacionGrafica) {
		sentidoFijo = miRepresentacionGrafica;
	}
	
	@SuppressWarnings("unused")
	private void aparecer() {
		setBounds(miPosicionLogica.getX(), miPosicionLogica.getY(), 25, 25);
		representacionActual = sentidoFijo;
		setIcon(representacionActual);
	}
	
	@Override
	public void actualizar(int sentido) {
		// TODO Auto-generated method stub
		
	}
	
}
