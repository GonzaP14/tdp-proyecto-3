package entidadesLogicas;

public class Posicion {
	int x, y, width, height;
	
	public Posicion (int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.width = ancho;
		this.height = alto;
	}
	
	public Posicion(int x , int y) {
		this(x, y, 25 , 25);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int distanciaEntrePosicionesPitagoras(Posicion PosicionActual , Posicion PosicionAlQueQuieroIr ) {
		double distanciaX = PosicionActual.getX() - PosicionAlQueQuieroIr.getX();
		double distanciaY = PosicionActual.getY() - PosicionAlQueQuieroIr.getY();
		double cuadrado = 2;
		int distanciaPitagoras = (int) (Math.pow(distanciaX, cuadrado) + Math.pow(distanciaY, cuadrado));
		
		return distanciaPitagoras;
	}
	
	public Posicion distanciaEntrePosiciones(Posicion PosicionActual , Posicion PosicionAlQueQuieroIr) {
		Posicion PosicionARetornar; 		
		double distanciaX = PosicionActual.getX() - PosicionAlQueQuieroIr.getX();
		double distanciaY = PosicionActual.getY() - PosicionAlQueQuieroIr.getY();
		
		// estos casteos no se si van los agregue para que compile
		PosicionARetornar = new Posicion((int) distanciaX , (int) distanciaY);
		return PosicionARetornar;
	}
	
	/**
	 * Clono una Posicion 
	 */
	public Posicion clone() {
		return new Posicion (x, y);
	}
	
	public Posicion posicionEsquinaArribaIzquierda() {
		return new Posicion(x,y);
	}
	
	public Posicion posicionEsquinaArribaDerecha() {
		return new Posicion(x + width , y);
	}
	
	public Posicion posicionEsquinaAbajoDerecha() {
		return new Posicion(x + width , y + height);
	}
	
	public Posicion posicionEsquinaAbajoIzquierda() {
		return new Posicion(x , y + height);
	}
}
