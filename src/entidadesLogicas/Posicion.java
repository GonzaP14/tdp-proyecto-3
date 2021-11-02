package entidadesLogicas;

public class Posicion {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	public Posicion(int x , int y ) {
		this.x = x;
		this.y = y;
		this.ancho = 25;
		this.alto = 25;
	}
	
	/**
	 * Obtengo la coordenada x de un Posicion
	 * @return coordenada x
	 */
	public int getX() {
		return x;
	}
	/**
	 * Modifico la coordenada x de un Posicion
	 * @Posicionam x coordenada x que voy a darle al Posicion
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Obtengo la coordenada Y de un Posicion
	 * @return coordenada Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Modifico la coordenada y de un Posicion
	 * @Posicionam y coordenada y que voy a darle al Posicion
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Clono un Posicion 
	 */
	public Posicion clone() {
		return new Posicion (x, y);
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
		int distanciaX = PosicionActual.getX() - PosicionAlQueQuieroIr.getX();
		int distanciaY = PosicionActual.getY() - PosicionAlQueQuieroIr.getY();
		
		PosicionARetornar = new Posicion(distanciaX , distanciaY);
		
		return PosicionARetornar;
	}
	
	public Posicion posicionEsquinaArribaIzquierda() {
		return new Posicion(x,y);
	}
	
	public Posicion posicionEsquinaArribaDerecha() {
		return new Posicion(x + ancho , y);
	}
	
	public Posicion posicionEsquinaAbajoDerecha() {
		return new Posicion(x + ancho , y + alto);
	}
	
	public Posicion posicionEsquinaAbajoIzquierda() {
		return new Posicion(x , y + alto);
	}
}
