package entidadesGraficas;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class PrincipalGrafico extends PersonajeGrafico {
	
	private static final long serialVersionUID = 1L;
	
	public PrincipalGrafico(String[] imagenes) {
		 this.setBounds (100,100,25,25);
		 sentidosEstado = new ArrayList<ImageIcon>();
		 
		 ImageIcon scalingAuxImage;
		 for (int imagenesIndice = 0; imagenesIndice < 4; imagenesIndice++) {
			scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[imagenesIndice]));
			scalingAuxImage = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
			sentidosEstado.add(scalingAuxImage); 
		 }
		 
		 scalingAuxImage = new ImageIcon(this.getClass().getResource(imagenes[4]));
		 muerto = new ImageIcon(scalingAuxImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		 
	     miPrioridad = 2;
	     this.setIcon(representacionActual);
	}
}
