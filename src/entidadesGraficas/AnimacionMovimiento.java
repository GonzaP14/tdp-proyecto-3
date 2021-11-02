package entidadesGraficas;

public class AnimacionMovimiento {
	protected int sentidoAnimacion;
	protected boolean animationFinished;
	protected int xInicial, yInicial;
	
	public AnimacionMovimiento(int sentidoAnimacion, int xInicial, int yInicial) {
		this.sentidoAnimacion = sentidoAnimacion;
		animationFinished = false;
		this.xInicial = xInicial;
		this.yInicial = yInicial;
		
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
				juancito.label2.setLocation(juancito.label2.getBounds().x, juancito.label2.getBounds().y - 10);
		        if (juancito.label2.getBounds().y % 100 == 0) {
		        	animationFinished = true;
		        }
			break;
			case 2: // abajo
				juancito.label2.setLocation(juancito.label2.getBounds().x, juancito.label2.getBounds().y + 10);
		        if (juancito.label2.getBounds().y % 100 == 0) {
		        	animationFinished = true;
		        }
			break;
			case 3: // izquierda
				juancito.label2.setLocation(juancito.label2.getBounds().x - 10, juancito.label2.getBounds().y);
		        if (juancito.label2.getBounds().x % 100 == 0) {
		        	animationFinished = true;
		        }
			break;
			case 4: // derecha
				juancito.label2.setLocation(juancito.label2.getBounds().x + 10, juancito.label2.getBounds().y);
		        if (juancito.label2.getBounds().x % 100 == 0) {
		        	
		        	animationFinished = true;
		        }
			break;
		}
    }
     
}
