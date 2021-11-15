package personajes;

import java.util.ArrayList;

import elementos.PocionCongelacion;
import elementos.PowerPellet;
import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public abstract class Enemigo extends Personaje {
	
	protected HiloEnemigo miHilo;
	protected EstadoEnemigo estadoActual; 
	protected EstadoEnemigo [] estados;
	protected int indiceEstado;
	protected int tiempoEstado;
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
		}
		else {
			miJuego.getMiPersonajePrincipal().recibirEfecto(this);
		}
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
		reaparecer();
	}


	public void recibirEfecto(PowerPellet p) {
		cambiarEstado(Frightened);
    }


    public void recibirEfecto(PocionCongelacion p) {
    	velocidadActual = p.getVelocidadOtorgada();
    	miHilo.setVelocidadTickeo(velocidadActual);
    }
	
	public void cambiarEstado (int estado) {
		if (estado == Frightened) {
			indiceEstado = Frightened;
			miRepresentacion.asustarse();
		} else if (estado == Chase) {
			indiceEstado = Chase;
			miRepresentacion.perseguir();
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
		frightened.setEnemigo(this);
		frightened.setPosicionObjetivo(miJuego.getMiPersonajePrincipal().getPosicion());
		
		return frightened;
	}
	
	protected abstract EstadoEnemigo crearEstadoChase();
	
	protected EstadoEnemigo crearEstadoEaten() {
		EstadoEnemigo eaten = new Frightened();
		eaten.setEnemigo(this);
		eaten.setPosicionObjetivo(miJuego.getMiPersonajePrincipal().getPosicion());
		
		return eaten;
	}
	
	protected EstadoEnemigo crearEstadoScatter() {
		EstadoEnemigo scatter = new Frightened();
		scatter.setEnemigo(this);
		scatter.setPosicionObjetivo(miJuego.getMiPersonajePrincipal().getPosicion());
		
		return scatter;
	}
	
	public void mover() {
		Posicion destino = estadoActual.siguientePosicion();
		int sentidoDestino = calcularSentido(miPosicion, destino);
		
    	if (this.getSentidoActual() == Entidad.sentidoFijo) {
    		this.setSentidoActual(sentidoDestino);
    	}
    	else {
    		this.setSentidoSiguiente(sentidoDestino);
    	}
		
		super.mover();
	}

	private int calcularSentido(Posicion miPosicion, Posicion destino) {
		int sentidoNuevo = sentidoActual;
		Posicion resta = destino.distanciaEntrePosiciones(miPosicion);
		
		// Destino = B - A
		// B - A (x) < 0
		
		if (resta.getX() > 0) {
			sentidoNuevo = sentidoDerecha;
		}
		else if (resta.getX() < 0) {
			sentidoNuevo = sentidoIzquierda;
		}
		else if (resta.getY() > 0) {
			sentidoNuevo = sentidoAbajo;
		}
		else if (resta.getY() < 0) {
			sentidoNuevo = sentidoArriba;
		}
		
		return sentidoNuevo;
	}
	
	protected void crearHilo (Enemigo e) {
		miHilo = new HiloEnemigo(velocidadActual, miJuego, e);
	}

	public void iniciarHilo() {
		miHilo.start();
	}

	public ArrayList <Posicion> posicionesDestino() {
		ArrayList<Posicion> toReturn = new ArrayList<Posicion>();

		//System.out.println("Posicion actual = " + miPosicion);
		//System.out.println("Bloque " + miPosicion.getY() / 25 + " " + miPosicion.getX() / 25);
		
		for (Posicion p: miPosicion.posicionesDestino()) { 
			//System.out.println("Posicion destino = " + p);
			// !p.equals(miPosicion) && -> No es necesario
			
			if (!sentidosContrarios(sentidoActual, calcularSentido(miPosicion, p)) && miJuego.getGrilla().bloqueVisitable(p.getY() / 25, p.getX() / 25)) {
				toReturn.add(p);
				//System.out.println("Posicion destino (Vistable) = " + p);
			}
		}
		
		return toReturn;
	}
	
	private boolean sentidosContrarios(int sentidoActual, int sentidoNuevo) {
		boolean contrarios = false;
		if ((sentidoActual == Entidad.sentidoAbajo && sentidoNuevo == Entidad.sentidoArriba) || (sentidoActual == Entidad.sentidoArriba && sentidoNuevo == Entidad.sentidoAbajo) || (sentidoActual == Entidad.sentidoIzquierda && sentidoNuevo == Entidad.sentidoDerecha) || (sentidoActual == Entidad.sentidoDerecha && sentidoNuevo == Entidad.sentidoIzquierda)) {
			contrarios = true;
		}
		return contrarios;
	}
	
	protected abstract void reaparecer();
	
}
