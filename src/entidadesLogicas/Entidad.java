package entidadesLogicas;

import entidadesGraficas.EntidadGrafica;

public abstract class Entidad {
	
	// Atributos de instancia
	protected int sentidoActual;
	protected EntidadGrafica miRepresentacion;
	protected Juego miJuego;
	protected Posicion miPosicion;
	protected Posicion miSpawn;
	
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
	
	// -------------------------------------------- SETTERS ----------------------------------------
		
	public void setSentidoActual(int sentido) {
		sentidoActual = sentido;
	}
	
	// -------------------------------------------- ACCIONES ----------------------------------------
	public abstract void afectar();
	
	public void desaparecer() {
		
	}
}
