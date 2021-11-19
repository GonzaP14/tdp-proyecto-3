package entidadesLogicas;

import elementos.PocionBomba;
import entidadesGraficas.EntidadGrafica;

public abstract class Entidad {
	
	// Atributos de instancia
	protected int sentidoActual, sentidoSiguiente;
	protected EntidadGrafica miRepresentacion;
	protected Juego miJuego;
	protected Posicion miPosicion;
	
	// Atributos de clase
	public static final int sentidoFijo = 0;
	public static final int sentidoArriba = 1;
	public static final int sentidoAbajo = 2;
	public static final int sentidoIzquierda = 3;
	public static final int sentidoDerecha = 4;
	
	
	// -------------------------------------------- GETTERS ----------------------------------------
	public int getSentidoActual() {
		return sentidoActual;
	}

	public Posicion getPosicion() {
		return miPosicion;
	}
	
	
	public EntidadGrafica getMiRepresentacion() {
		return miRepresentacion;
	}
	
	public int getSentidoSiguiente() {
		return sentidoSiguiente;
	}

	public void setSentidoSiguiente(int sentidoSiguiente) {
		this.sentidoSiguiente = sentidoSiguiente;
	}
	
	
	
	// -------------------------------------------- SETTERS ----------------------------------------
	public void setSentidoActual(int sentido) {
		sentidoActual = sentido;
		miRepresentacion.actualizar(sentido);
	}
	
	
	
	public void setMiRepresentacion(EntidadGrafica miRepresentacion) {
		this.miRepresentacion = miRepresentacion;
	}
	
	public void setPosicion(Posicion p) {
		miPosicion = p;
	}
	

	// -------------------------------------------- ACCIONES ----------------------------------------
	public abstract void afectar();
	
	public void recibirEfecto(PocionBomba p) {
		
	}
	
}
