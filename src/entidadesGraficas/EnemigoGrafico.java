package entidadesGraficas;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class EnemigoGrafico extends PersonajeGrafico{
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<ImageIcon> sentidosChase, sentidosFrightened;
	
	public EnemigoGrafico(String[] imagenes) {
		setBounds(25, 25, 25, 25);
		ImageIcon scalingAuxImage;
		sentidosEstado = new ArrayList<ImageIcon>();
		sentidosChase = new ArrayList<ImageIcon>();
		sentidosFrightened = new ArrayList<ImageIcon>();
		
		for (int imagenesIndice = 0; imagenesIndice < 4; imagenesIndice++) {
			scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[imagenesIndice]));
			scalingAuxImage = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
			sentidosChase.add(scalingAuxImage); 
		}
		
		scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[4]));
		muerto = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		
		for (int imagenesIndice = 5; imagenesIndice < 9; imagenesIndice++) {
			scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[imagenesIndice]));
			scalingAuxImage = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
			sentidosFrightened.add(scalingAuxImage); 
		}
		
		sentidosEstado = sentidosChase;
		miPrioridad = 2;
		representacionActual = sentidosEstado.get(2);
		this.setIcon(representacionActual);
	}

	public void asustarse() {
		sentidosEstado = sentidosFrightened;
	}
	
	public void perseguir() {
		sentidosEstado = sentidosChase;
	}
}
