package personajes;

import java.util.ArrayList;

import elementos.PocionBomba;
import elementos.PowerPellet;
import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

public abstract class Enemigo extends Personaje {
	
	protected HiloEnemigo miHilo;
	protected EstadoEnemigo estadoActual; 
	protected EstadoEnemigo [] estados;
	protected int indiceEstado;
	protected int tiempoEstado;
	protected int velocidadPredeterminada;
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
			miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
			cambiarEstado(Eaten);
		}
		else if(indiceEstado == Scatter || indiceEstado == Chase){
			miJuego.getMiPersonajePrincipal().recibirEfecto(this);
		}
	}

	protected void crearEnemigo(Juego miJuego, Posicion spawn, String[] imagenes) {
		this.miJuego = miJuego;
		miSpawn = spawn;
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		crearEstados();
		indiceEstado = Scatter;
		estadoActual = estados[indiceEstado];
		crearHilo(this);
	}

	public void recibirEfecto(PowerPellet p) {
		setVelocidadActual(velocidadActual - 10);
		cambiarEstado(Frightened);
    }


    public void recibirEfecto(PocionBomba p) {
    	miJuego.aumentarPuntaje(p.getPuntajeOtorgado());
		reaparecer();
    }
	
	public void cambiarEstado (int estado) {
		if (estado == Frightened) {
			indiceEstado = Frightened;
			miRepresentacion.asustarse(sentidoActual);
		} else if (estado == Chase) {
			if(indiceEstado == Eaten) {
				setVelocidadActual(velocidadPredeterminada);
			}
			indiceEstado = Chase;
			miRepresentacion.perseguir(sentidoActual);
		} else if (estado == Eaten) {
			setVelocidadActual(200);
			indiceEstado = Eaten;
			miRepresentacion.morir();
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
		estados[Chase] = crearEstadoChase(crearChaseIA(), this);
		estados[Eaten] = crearEstadoEaten();
		estados[Scatter] = crearEstadoScatter();
	}
	
	protected EstadoEnemigo crearEstadoFrightened() {
		EstadoEnemigo frightened = new Frightened(this , miJuego.getMiPersonajePrincipal());
		return frightened;
	}
	
	protected EstadoEnemigo crearEstadoEaten() {
		EstadoEnemigo eaten = new Eaten(this , getSpawn());	
		return eaten;
	}
	
	protected EstadoEnemigo crearEstadoScatter() {
		EstadoEnemigo scatter = new Scatter(this , this.getPosicionScatter());
		return scatter;
	}
	
	public EstadoEnemigo crearEstadoChase(ChaseIA chaseIA, Enemigo enemigoLigado) {
		EstadoEnemigo chase = new Chase(chaseIA , enemigoLigado , miJuego.getMiPersonajePrincipal());
		return chase;
	}
	
	public abstract ChaseIA crearChaseIA();
	
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
		for (Posicion p: miPosicion.posicionesDestino()) { 
			
			if (!sentidosContrarios(sentidoActual, calcularSentido(miPosicion, p)) && miJuego.getGrilla().bloqueVisitable(p.getY() / 25, p.getX() / 25)) {
				toReturn.add(p);
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

	public HiloEnemigo getMiHilo() {
		return miHilo;
	}

	
	public abstract Posicion getPosicionScatter();

	public void reaparecer() {
		super.reaparecer();
		cambiarEstado(Chase);
	}
	
	public void setVelocidadActual(int velocidad) {
		velocidadActual = velocidad;
		miHilo.setVelocidadTickeo(velocidad);
	}

	public int getIndiceEstado() {
		return indiceEstado;
	}
	
	public int getVelocidadPredeterminada() {
		return velocidadPredeterminada;
	}
	
}
