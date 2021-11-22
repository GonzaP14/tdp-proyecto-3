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
	public int getSentidoActual() {
		return sentidoActual;
	}

	public Posicion getPosicion() {
		return miPosicion;
	}
	
	public Posicion getSpawn() {
		return miSpawn;
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

	public abstract void reset();
	
}
