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
	protected Posicion arribaDeLaCasa = new Posicion(350, 275);
	protected boolean tieneQueEntrarALaCasa;
	protected boolean tieneQueSalirDeLaCasa;
	
	@Override
	public void afectar() {
		if(indiceEstado == Frightened) {
			miJuego.setCantidadFantasmasComidos(miJuego.getCantidadFantasmasComidos() + 1);
			miJuego.aumentarPuntaje(puntajeOtorgado * miJuego.getCantidadFantasmasComidos());
			miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
			cambiarEstado(Eaten);
		}
		else if(indiceEstado == Scatter || indiceEstado == Chase){
			miJuego.getPrincipal().recibirEfecto(this);
			for(Enemigo e : miJuego.getEnemigos())
				e.setTieneQueSalirDeLaCasa(true);
		}
	}
	@Override
	public void chequearColisionesEntidades() {
	}
	
	/**
	 * Crea todos los posibles estados que va a tener un enemigo
	 */
	protected void crearEstados() {
		estados = new EstadoEnemigo[4];
		estados[Frightened] = crearEstadoFrightened();
		estados[Chase] = crearEstadoChase(crearChaseIA(), this);
		estados[Eaten] = crearEstadoEaten();
		estados[Scatter] = crearEstadoScatter();
	}
	
	/**
	 * Mueve al enemigo calculando su siguiente posicion con su IA
	 */
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
	
	/**
	 * Reaparece a los enemigos cambiando su estado a Chase
	 */
	public void reaparecer() {
		super.reaparecer();
	}
	
	/**
	 * Setea la velocidad predeterminada del enemigo
	 * @param velocidad velocidad predeterminada que va a tener el enemigo
	 */
	public void setVelocidadPredeterminada(int velocidad) {
		velocidadPredeterminada = velocidad;
	}
	
	/**
	 * Setea la velocidad predeterminada del enemigo
	 * @param velocidad velocidad que va a tener el enemigo
	 */
	public void setVelocidadActual(int velocidad) {
		velocidadActual = velocidad;
		miHilo.setVelocidadTickeo(velocidad);
	}
	
	/**
	 * Crea un enemigo basico para cuando se crea el juego con sus parametros correspondientes
	 * @param miJuego El juego asociado que va a tener el enemigo
	 * @param spawn Lugar en el que va a respawnear el enemigo
	 * @param imagenes Path de las imagenes posibles que va a tener un enemigo
	 */
	protected void crearEnemigo(Juego miJuego, Posicion spawn, String[] imagenes) {
		tieneQueEntrarALaCasa = false;
		this.miJuego = miJuego;
		tieneQueSalirDeLaCasa = true;
		miSpawn = spawn;
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.crearGrafica(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		crearEstados();
		indiceEstado = Scatter;
		estadoActual = estados[indiceEstado];
		crearHilo(this);
	}
	
	/**
	 * Modela el efecto que recibe un enemigo al ser afectado por un powerPellet
	 * @param p powerPellet del que va a recibir el efecto
	 */
	public void recibirEfecto(PowerPellet p) {
		setVelocidadActual(velocidadActual - 10);
		cambiarEstado(Frightened);
    }

	/**
	 * Modela el efecto que recibe un enemigo al ser afectado por una pocionBomba
	 * @param p powerPellet del que va a recibir el efecto
	 */
    public void recibirEfecto(PocionBomba p) {
    	miJuego.aumentarPuntaje(p.getPuntajeOtorgado());
    	cambiarEstado(Eaten);
    }
	
    /**
     * Cambia el estado en el que se encuentra el enemigo
     * @param estado que va a pasar a tener
     */
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
	
	/**
	 * Setea el tiene que salir de la casa en caso de que el enemigo tenga que realizar esta accion
	 * @param tieneQueSalirDeLaCasa
	 */
	public void setTieneQueSalirDeLaCasa(boolean tieneQueSalirDeLaCasa) {
		this.tieneQueSalirDeLaCasa = tieneQueSalirDeLaCasa;
	}
	
	/**
	 * Resetea a los enemigos para un posible cambio de nivel
	 */
	public void reset() {
		tieneQueSalirDeLaCasa = true;
		miSpawn = getSpawn();
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miRepresentacion.crearGrafica(miPosicion);
		miRepresentacion.reset();
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		indiceEstado = Scatter;
		estadoActual = estados[indiceEstado];
	}
	
	/**
	 * Seteo si tiene que entrar a la casa el enemigo en el caso de necesitarlo
	 * @param t 
	 */
	public void setTieneQueEntrarALaCasa(boolean t) {
		tieneQueEntrarALaCasa = t;
	}
	
	/**
	 * Crea el hilo para los enemigos 
	 * @param e Enemigo al que se le va a crear el hilo
	 */
	public void crearHilo (Enemigo e) {
		miHilo = new HiloEnemigo(velocidadActual, miJuego, e);
	}
	
	/**
	 * Inicia el hilo del enemigo
	 */
	public void iniciarHilo() {
		miHilo.start();
	}
	
	/**
	 * Modela el comportamiento del enemigo para entrar a la casa
	 */
	public abstract void entrarALaCasa();
	
	/**
	 * Modela el comportamiento del enemigo para salir de la casa
	 */
	public abstract void salirDeLaCasa();
	
	/**
	 * @return el hilo del enemigo
	 */
	public HiloEnemigo getMiHilo() {
		return miHilo;
	}
	
	/**
	 * @return la posicion de scatter del enemigo
	 */
	public abstract Posicion getPosicionScatter();
	
	/**
	 * @return el indiceEstado del enemigo,osea el estado en el que se encuentra 
	 */
	public int getIndiceEstado() {
		return indiceEstado;
	}
	
	/**
	 * @return la velocidad predeterminada del enemigo
	 */
	public int getVelocidadPredeterminada() {
		return velocidadPredeterminada;
	}
	
	/** 
	 * @return si tiene que entrar a la casa 
	 */
	public boolean getTieneQueEntrarALaCasa() {
		return tieneQueEntrarALaCasa;
	}
	
	/**
	 * @return si tiene que salir de la casa
	 */
	public boolean getTieneQueSalirDeLaCasa() {
		return tieneQueSalirDeLaCasa;
	}

	/**
	 * @return la posicion de arriba de la casa del enemigo , osea la posicion que tiene que estar al salir de la casa
	 */
	public Posicion getArribaDeLaCasa() {
		return arribaDeLaCasa;
	}
	
	/**
	 * @return si el enemigo esta en frightened
	 */
	public boolean estaAterrado() {
		return (indiceEstado == Frightened);
	}
	
	/**
	 * @return si el enemigo esta en chase
	 */
	public boolean estaPersiguiendo() {
		return (indiceEstado == Chase);
	}
	
	/** 
	 * @return si el enemigo esta en eaten
	 */
	public boolean estaComido() {
		return (indiceEstado == Eaten);
	}
	
	/**
	 * @return si el enemigo esta en scatter
	 */
	public boolean estaDisperso() {
		return (indiceEstado == Scatter);
	}
	
	/**
	 * crea el estado frightened del enemigo
	 * @return el estado creado
	 */
	protected EstadoEnemigo crearEstadoFrightened() {
		EstadoEnemigo frightened = new Frightened(this , miJuego.getPrincipal());
		return frightened;
	}
	
	/**
	 * crea el estado eaten del enemigo
	 * @return el estado creado
	 */
	protected EstadoEnemigo crearEstadoEaten() {
		EstadoEnemigo eaten = new Eaten(this , getSpawn());	
		return eaten;
	}
	
	/**
	 * crea el estado scatter del enemigo
	 * @return el estado creado
	 */
	protected EstadoEnemigo crearEstadoScatter() {
		EstadoEnemigo scatter = new Scatter(this , this.getPosicionScatter());
		return scatter;
	}
	
	/**
	 * Crea el estado chase del enemigo
	 * @param chaseIA la IA que va a utilizar el enemigo en su estado chase
	 * @param enemigoLigado el enemigo que va a tener este estado
	 * @return el estado creado
	 */
	public EstadoEnemigo crearEstadoChase(ChaseIA chaseIA, Enemigo enemigoLigado) {
		EstadoEnemigo chase = new Chase(chaseIA , enemigoLigado , miJuego.getPrincipal());
		return chase;
	}
	
	/**
	 * Calcula el sentido en el que va a estar el enemigo
	 * @param miPosicion La posicion actual del enemigo
	 * @param destino La posicion de destino del enemigo
	 * @return el sentido calculado
	 */
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
	
	/**
	 * @return Las posibles posiciones a las que puede ir un enemigo
	 */
	public ArrayList <Posicion> posiblesPosiciones() {
		ArrayList<Posicion> toReturn = new ArrayList<Posicion>();
		for (Posicion p: miPosicion.posiblesPosiciones()) { 
			
			if (!sentidosContrarios(sentidoActual, calcularSentido(miPosicion, p)) && miJuego.getGrilla().bloqueVisitable(p.getY() / 25, p.getX() / 25)) {
				toReturn.add(p);
			}
		}
		
		return toReturn;
	}
	
	/**
	 * Calcula si los sentidos pasados por parametro son opuestos/contrarios
	 * @param sentidoActual El sentido actual del enemigo
	 * @param sentidoNuevo El sentido nuevo del enemigo
	 * @return Verdadero si son opuestos, falso en caso contrario
	 */
	private boolean sentidosContrarios(int sentidoActual, int sentidoNuevo) {
		boolean contrarios = false;
		if ((sentidoActual == Entidad.sentidoAbajo && sentidoNuevo == Entidad.sentidoArriba) || (sentidoActual == Entidad.sentidoArriba && sentidoNuevo == Entidad.sentidoAbajo) || (sentidoActual == Entidad.sentidoIzquierda && sentidoNuevo == Entidad.sentidoDerecha) || (sentidoActual == Entidad.sentidoDerecha && sentidoNuevo == Entidad.sentidoIzquierda)) {
			contrarios = true;
		}
		return contrarios;
	}
	
	/**
	 * Crea la IA del chase del enemigo
	 * @return La IA correspondiente
	 */
	public abstract ChaseIA crearChaseIA();
	
}

