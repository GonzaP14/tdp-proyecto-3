package personajes;

import elementos.PocionCongelacion;
import elementos.PocionVelocidad;
import elementos.PowerPellet;
import entidadesLogicas.Posicion;

public abstract class Enemigo extends Personaje {
	
	protected EstadoEnemigo estadoActual; 
	protected EstadoEnemigo [] estados;
	protected int indiceEstado;
	protected int tiempoEstado;
	protected int velocidad;
	private static final int puntajeOtorgado = 200;
	
	public static final int Frightened = 0;
	public static final int Chase = 1;
	public static final int Eaten = 2;
	public static final int Scatter = 3;
	
	@Override
	public void afectar() {
		if(indiceEstado == Frightened) {
			miJuego.setCantidadFantasmasComidos(miJuego.getCantidadFantasmasComidos() + 1);
			miJuego.aumentarPuntaje(200 * miJuego.getCantidadFantasmasComidos());
			miRepresentacion.desaparecer();
		}
		else {
			miJuego.getMiPersonajePrincipal().recibirEfecto(this);
		}
	}
	
	@Override
    public void recibirEfecto(PowerPellet p) {

    }

    @Override
    public void recibirEfecto(PocionCongelacion p) {
        // TODO Auto-generated method stub

    }


    @Override
    public void recibirEfecto(PocionVelocidad p) {
        // TODO Auto-generated method stub

    }
	
	public void cambiarEstado (int estado) {
		if (estado == Frightened) {
			indiceEstado = Frightened;
		} else if (estado == Chase) {
			indiceEstado = Chase;
		} else if (estado == Eaten) {
			indiceEstado = Eaten;
		} else if (estado == Scatter) {
			indiceEstado = Scatter;
		}
		
		estadoActual = estados[indiceEstado];
	}
	
	public void recuperarse () {
		
	}
	
	public boolean estaAterrado() {
		return (indiceEstado == Frightened);
	}
	
	public boolean estaPersiguiendo() {
		return (indiceEstado == Chase);
	}
	
	public boolean estaComido() {
		return (indiceEstado == Eaten);
	}
	
	public boolean estaDisperso() {
		return (indiceEstado == Scatter);
	}
	
	public void checkeoColisionesPersonaje() {
		
	}
	
	protected void crearEstados() {
		estados = new EstadoEnemigo[4];
		estados[Frightened] = crearEstadoFrightened();
		estados[Chase] = crearEstadoChase();
		estados[Eaten] = crearEstadoEaten();
		estados[Scatter] = crearEstadoScatter();
	}
	
	protected EstadoEnemigo crearEstadoFrightened() {
		EstadoEnemigo frightened = new Frightened();
		frightened.setPosicionEnemigo(miPosicion);
		frightened.setPosicionObjetivo(miJuego.getMiPersonajePrincipal().getPosicion());
		
		return frightened;
	}
	
	protected abstract EstadoEnemigo crearEstadoChase();
	
	protected EstadoEnemigo crearEstadoEaten() {
		EstadoEnemigo eaten = new Frightened();
		eaten.setPosicionEnemigo(miPosicion);
		eaten.setPosicionObjetivo(miJuego.getMiPersonajePrincipal().getPosicion());
		
		return eaten;
	}
	
	protected EstadoEnemigo crearEstadoScatter() {
		EstadoEnemigo scatter = new Frightened();
		scatter.setPosicionEnemigo(miPosicion);
		scatter.setPosicionObjetivo(miJuego.getMiPersonajePrincipal().getPosicion());
		
		return scatter;
	}
	
	public void mover() {
		Posicion destino = estadoActual.siguientePosicion();
		sentidoActual = calcularSentido(miPosicion, destino);
		super.mover();
	}

	private int calcularSentido(Posicion miPosicion, Posicion destino) {
		int sentidoNuevo = sentidoActual;
		Posicion resta = destino.distanciaEntrePosiciones(miPosicion);
		
		if (resta.getX() > 0) {
			sentidoNuevo = sentidoDerecha;
		}
		else if (resta.getX() < 0) {
			sentidoNuevo = sentidoIzquierda;
		}
		else if (resta.getY() > 0) {
			sentidoNuevo = sentidoArriba;
		}
		else if (resta.getY() < 0) {
			sentidoActual = sentidoAbajo;
		}
		
		return sentidoNuevo;
	}
	
}
