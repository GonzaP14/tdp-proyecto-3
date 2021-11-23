package entidadesLogicas;

import elementos.PocionBomba;
import entidadesGraficas.EntidadGrafica;
import gui.Ventana;

public abstract class Entidad {
	
	// Atributos de instancia
	protected int sentidoActual, sentidoSiguiente;
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
	/**
	 * Devuelvo el sentido actual de la entidad 
	 * @return sentido actual
	 */
	public int getSentidoActual() {
		return sentidoActual;
	}
	/**
	 * Devuelvo la posicion de la entidad
	 * @return la posicion de la entidad
	 */
	public Posicion getPosicion() {
		return miPosicion;
	}
	/**
	 * Devuelvo el spawn de la entidad
	 * @return el spawn de la entidad
	 */
	public Posicion getSpawn() {
		return miSpawn;
	}
	/**
	 * Devuelvo la entidad grafica que corresponde a la entidad
	 * @return la entidad grafica
	 */
	public EntidadGrafica getMiRepresentacion() {
		return miRepresentacion;
	}
	/**
	 * Devuelvo el proximo sentido que va a tener la entidad
	 * @return el sentido siguiente
	 */
	public int getSentidoSiguiente() {
		return sentidoSiguiente;
	}
	
	// -------------------------------------------- SETTERS ----------------------------------------

	/**
	 * Seteo el sentido actual de la entidad y muestro este cambio graficamente
	 * @param sentido que va a tener la entidad
	 */
	public void setSentidoActual(int sentido) {
		sentidoActual = sentido;
		miRepresentacion.actualizar(sentido);
	}
	
	/**
	 * Seteo la representacion grafica que va a tener la entidad
	 * @param miRepresentacion representacion grafica que va a tener la entidad
	 */
	public void setMiRepresentacion(EntidadGrafica miRepresentacion) {
		this.miRepresentacion = miRepresentacion;
	}
	
	/**
	 * Seteo la posicion que va a tener la entidad
	 * @param p posicion que va a tener la entidad
	 */
	public void setPosicion(Posicion p) {
		miPosicion = p;
	}
	/**
	 * Seteo el proximo sentido que va a tener la entidad
	 * @param sentidoSiguiente que va a tener la entidad
	 */
	public void setSentidoSiguiente(int sentidoSiguiente) {
		this.sentidoSiguiente = sentidoSiguiente;
	}
	

	// -------------------------------------------- ACCIONES ----------------------------------------
	/**
	 * Define de la manera que la entidad va a afectar al personaje principal
	 */
	public abstract void afectar();
	/**
	 * Hace que la entidad reciba el efecto de la pocion bomba si le corresponde
	 * @param p pocion por la que va a ser afectado
	 */
	public void recibirEfecto(PocionBomba p) {
		
	}
	/**
	 * Reaparece a una entidad en la grilla
	 */
	public void reaparecer() {
		Bloque bloqueAnterior, bloqueRespawn, bloquePrincipal;
		bloqueAnterior = miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque);
		miPosicion.setX(miSpawn.getX());
		miPosicion.setY(miSpawn.getY());
		this.miRepresentacion.crearGrafica(miPosicion);
		bloqueRespawn = miJuego.getGrilla().getBloque(miSpawn.getY() / Ventana.pixelesBloque , miSpawn.getX() / Ventana.pixelesBloque);
		
		if (bloqueAnterior != bloqueRespawn) {
			// si el fantasma no esta en el bloque del principal, borrarlo directamente, sino, agregar a lista de removidos
			
			bloquePrincipal = miJuego.getGrilla().getBloque(miJuego.getPrincipal().getPosicion().getY() / Ventana.pixelesBloque , miJuego.getPrincipal().getPosicion().getX() / Ventana.pixelesBloque);
			if (bloqueAnterior != bloquePrincipal) {
				bloqueAnterior.borrarDeListaDeEntidades(this);
			}
			else {
				bloqueAnterior.agregarAListaRemovidos(this);
			}
			bloqueRespawn.agregarAListaEntidades(this);
		}
		
	}
	/**
	 * Resetea la entidad para un cambio de nivel
	 */
	public abstract void reset();
	
}
