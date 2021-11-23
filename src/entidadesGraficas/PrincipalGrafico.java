package entidadesGraficas;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class PrincipalGrafico extends PersonajeGrafico {
	
	private static final long serialVersionUID = 1L;
	protected ArrayList<ImageIcon> sentidosDefault, sentidosPocionBomba, sentidosPocionVelocidad;
	
	public PrincipalGrafico(String[] imagenes) {
		 setBounds (100,100,25,25);
		 ImageIcon scalingAuxImage;
		 sentidosEstado = new ArrayList<ImageIcon>();
		 sentidosDefault = new ArrayList<ImageIcon>();
		 sentidosPocionBomba = new ArrayList<ImageIcon>();
		 sentidosPocionVelocidad = new ArrayList<ImageIcon>();
		 
		 for (int imagenesIndice = 0; imagenesIndice < 4; imagenesIndice++) {
			scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[imagenesIndice]));
			scalingAuxImage = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
			sentidosDefault.add(scalingAuxImage); 
		 }
		 
		 scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[4]));
		 muerto = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		 
		 
		 for (int imagenesIndice = 5; imagenesIndice < 9; imagenesIndice++) {
				scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[imagenesIndice]));
				scalingAuxImage = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
				sentidosPocionBomba.add(scalingAuxImage); 
		 }
		 
		 for (int imagenesIndice = 9; imagenesIndice < 13; imagenesIndice++) {
				scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[imagenesIndice]));
				scalingAuxImage = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
				sentidosPocionVelocidad.add(scalingAuxImage); 
		 }
		 
		 sentidosEstado = sentidosDefault;
	     miPrioridad = 2;
	     this.setIcon(representacionActual);
	}
	
	public void efectoPocionBomba(int sentidoActual) {
		sentidosEstado = sentidosPocionBomba;
		this.actualizar(sentidoActual);
	}
	
	public void efectoPocionVelocidad(int sentidoActual) {
		sentidosEstado = sentidosPocionVelocidad;
		this.actualizar(sentidoActual);
	}
	
	public void finEfectoPocion(int sentidoActual) {
		sentidosEstado = sentidosDefault;
		this.actualizar(sentidoActual);
	}

}
