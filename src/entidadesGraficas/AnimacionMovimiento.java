package entidadesGraficas;

import javax.swing.JLabel;

public class AnimacionMovimiento {
	protected int sentidoAnimacion;
	protected boolean animationFinished;
	protected int xInicial, yInicial;
	protected JLabel entidad;
	
	public AnimacionMovimiento(int sentidoAnimacion, int xInicial, int yInicial, JLabel entidad) {
		this.sentidoAnimacion = sentidoAnimacion;
		animationFinished = false;
		this.xInicial = xInicial;
		this.yInicial = yInicial;
		this.entidad = entidad;
	}
	
	public boolean isAnimationFinished() {
		return animationFinished;
	}
	
	public void setSentidoAnimacion(int sentidoAnimacion) {
		this.sentidoAnimacion = sentidoAnimacion;
	}

	public void animate() throws Exception {
		if (animationFinished) {
			throw new Exception(); // terminar el scheduler
        }
		switch (sentidoAnimacion) {
			case 1: // arriba
				entidad.setLocation(entidad.getBounds().x, entidad.getBounds().y - 10);
		        if (entidad.getBounds().y % 100 == 0) {
		        	animationFinished = true;
		        }
			break;
			case 2: // abajo
				entidad.setLocation(entidad.getBounds().x, entidad.getBounds().y + 10);
		        if (entidad.getBounds().y % 100 == 0) {
		        	animationFinished = true;
		        }
			break;
			case 3: // izquierda
				entidad.setLocation(entidad.getBounds().x - 10, entidad.getBounds().y);
		        if (entidad.getBounds().x % 100 == 0) {
		        	animationFinished = true;
		        }
			break;
			case 4: // derecha
				entidad.setLocation(entidad.getBounds().x + 10, entidad.getBounds().y);
		        if (entidad.getBounds().x % 100 == 0) {
		        	
		        	animationFinished = true;
		        }
			break;
		}
    }
     
}
