package entidadesLogicas;
import gui.Ventana;

public class Posicion {
	private int x, y, width, height;
	
	/**
	 * Crea una posicion con ancho,alto,x e y
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 */
	public Posicion (int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.width = ancho;
		this.height = alto;
	}
	
	/**
	 * Crea una posicion con x e y
	 * @param x
	 * @param y
	 */
	public Posicion(int x , int y) {
		this(x, y, Ventana.pixelesBloque, Ventana.pixelesBloque);
	}
	
	/**
	 * Seteo la x de la posicion
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Seteo la Y de la posicion
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return la X de la posicion
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return la Y de la posicion
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @param destino posicion a la que quiero ir y que va a ser usada para sacar la distancia
	 * @return el valor de la distancia entre dos posiciones hecho con pitagoras
	 */
	public double distanciaEntrePosicionesPitagoras(Posicion destino) {
		double distanciaX = this.getX() - destino.getX();
		double distanciaY = this.getY() - destino.getY();
		
		return Math.sqrt((Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2)));
	}
	
	/**
	 * @param destino posicion a la que quiero ir y que va a ser usada para sacar la distancia
	 * @return una posicion que es de la distancia entre dos posiciones 
	 */
	public Posicion distanciaEntrePosiciones(Posicion destino) {	
		int distanciaX = this.getX() - destino.getX();
		int distanciaY = this.getY() - destino.getY();
		
		return new Posicion( distanciaX , distanciaY);
	}
	
	/**
	 * Clono una Posicion 
	 */
	public Posicion clone() {
		return new Posicion (x, y);
	}
	
	/**
	 * @return la posicion de la esquina arriba a la izquierda
	 */
	private Posicion posicionEsquinaArribaIzquierda() {
		return new Posicion(x,y);
	}
	
	/**
	 * @return la posicion de la esquina arriba a la derecha
	 */
	private Posicion posicionEsquinaArribaDerecha() {
		return new Posicion(x + width , y);
	}
	
	/**
	 * @return la posicion de la esquina abajo a la derecha
	 */
	private Posicion posicionEsquinaAbajoDerecha() {
		return new Posicion(x + width , y + height);
	}
	
	/**
	 * @return la posicion de la esquina abajo a la izquierda
	 */
	private Posicion posicionEsquinaAbajoIzquierda() {
		return new Posicion(x , y + height);
	}
	
	/**
	 * @return las 4 posibles posiciones a las que puede ir un fantasma 
	 */
	public Posicion [] posiblesPosiciones() {
		Posicion [] direcciones = new Posicion [4];
		
		direcciones [0] = new Posicion (x + Ventana.pixelesBloque, y);
		direcciones [1] = new Posicion (x - Ventana.pixelesBloque, y);
		direcciones [2] = new Posicion (x, y + Ventana.pixelesBloque);
		direcciones [3] = new Posicion (x, y - Ventana.pixelesBloque);
		
		return direcciones;
	}

	public boolean equals(Posicion posicion) {
		return x == posicion.getX() && y == posicion.getY();
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * @param sentidoEntidad el sentido actual que tiene la entidad
	 * @return las 4 esquinas de la entidad dependiendo de su sentido
	 */
	public Posicion[] getPosicionEsquina(int sentidoEntidad) {
		Posicion[] posicionEsquina = new Posicion[2];
		if (sentidoEntidad == Entidad.sentidoIzquierda) {
			posicionEsquina[0] = posicionEsquinaArribaIzquierda();
			posicionEsquina[1] = posicionEsquinaAbajoIzquierda();
		}
		else if (sentidoEntidad == Entidad.sentidoDerecha) {
			posicionEsquina[0] = posicionEsquinaArribaDerecha();
			posicionEsquina[1] = posicionEsquinaAbajoDerecha();
		}
		else if (sentidoEntidad == Entidad.sentidoArriba) {
			posicionEsquina[0] = posicionEsquinaArribaDerecha();
			posicionEsquina[1] = posicionEsquinaArribaIzquierda();
		}
		else if (sentidoEntidad == Entidad.sentidoAbajo) {
			posicionEsquina[0] = posicionEsquinaAbajoDerecha();
			posicionEsquina[1] = posicionEsquinaAbajoIzquierda();
		}

		return posicionEsquina;
	}
	
}
