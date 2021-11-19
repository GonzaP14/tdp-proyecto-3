package entidadesGraficas;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import entidadesLogicas.Posicion;

public class ElementoGrafico extends EntidadGrafica {
	
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<ImageIcon> sentidosEstado;
	
	public ElementoGrafico (String[] imagenes) {
		setBounds(25, 25, 25, 25);
		ImageIcon imagen;
		sentidosEstado = new ArrayList<ImageIcon>();
		for (int i = 0; i < imagenes.length; i++) {
			imagen = new ImageIcon(this.getClass().getResource(imagenes[i]));
			imagen = new ImageIcon(imagen.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
			sentidosEstado.add(imagen);
		}
		
		miPrioridad = 1;
	}
	
	public void aparecer(Posicion miPosicion) {
		this.setLocation((int) miPosicion.getX(), (int) miPosicion.getY());
		representacionActual = sentidosEstado.get(0);
		setIcon(representacionActual);
	}
	
	@Override
	public void actualizar(int sentido) {
		representacionActual = sentidosEstado.get(sentido-1);
		setIcon(representacionActual);
	}

	@Override
	public void desaparecer() {
		this.setVisible(false);
	}
	
}
