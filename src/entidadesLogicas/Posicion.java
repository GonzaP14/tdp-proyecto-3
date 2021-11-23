package entidadesLogicas;

import java.awt.Rectangle;

import gui.Ventana;

public class Posicion {
	private int x, y, width, height;
	
	public Posicion (int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.width = ancho;
		this.height = alto;
	}
	
	public Posicion(int x , int y) {
		this(x, y, Ventana.pixelesBloque, Ventana.pixelesBloque);
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
	
	public double distanciaEntrePosicionesPitagoras(Posicion destino) {
		double distanciaX = this.getX() - destino.getX();
		double distanciaY = this.getY() - destino.getY();
		
		return Math.sqrt((Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2)));
	}
	
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
	
	private Posicion posicionEsquinaArribaIzquierda() {
		return new Posicion(x,y);
	}
	
	private Posicion posicionEsquinaArribaDerecha() {
		return new Posicion(x + width , y);
	}
	
	private Posicion posicionEsquinaAbajoDerecha() {
		return new Posicion(x + width , y + height);
	}
	
	private Posicion posicionEsquinaAbajoIzquierda() {
		return new Posicion(x , y + height);
	}
	
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
