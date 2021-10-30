package entidadesLogicas;

import entidadesGraficas.EntidadGrafica;

public abstract class Entidad {
	
	// Atributos de instancia
	protected Bloque miBloque;
	protected int sentidoActual;
	protected EntidadGrafica miRepresentacion;
	private Juego miJuego;
	
	// Atributos de clase
	public static int sentidoFijo, sentidoArriba, sentidoAbajo, sentidoIzquierda, sentidoDerecha;
	
	// ------------------------------------------ CONSTRUCTOR --------------------------------------
	public Entidad() {
		
	}
	
	// -------------------------------------------- GETTERS ----------------------------------------
	public Bloque getBloque() {
		return miBloque;	
	}
	
	public Par getPosicion() {
		return null;
	}
	
	public EntidadGrafica getMiRepresentacion() {
		return miRepresentacion;
	}
	
	// -------------------------------------------- ACCIONES ----------------------------------------
	public abstract void afectar();
	
	public void desaparecer() {
		
	}
}
