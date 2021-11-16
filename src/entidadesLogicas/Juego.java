package entidadesLogicas;

import java.util.ArrayList;
import java.util.Properties;
import audio.Audio;
import elementos.Elemento;
import elementos.Fruta;
import elementos.PacDot;
import elementos.PocionCongelacion;
import elementos.PocionVelocidad;
import elementos.PowerPellet;
import gui.Ventana;
import personajes.Enemigo;
import personajes.Personaje;
import personajes.Principal;
import productos.FabricaEntidades;
import productos.FabricaGeneral;

public class Juego {
	
	// Atributos de instancia 
	private boolean gameOver, estaPausado;
	private int minuto, segundos, vidasActuales;
	private Object objetoPausa;
	private FabricaEntidades miFabricaEntidades;
	private Reloj miReloj;
	private Player miPlayer;
	private Leaderboard miLeaderboard;
	private Audio miAudio;
	private Ventana miVentana;
	private Grilla miGrilla;
	private ArrayList<Enemigo>  misEnemigos;
	private Principal miPersonajePrincipal;
	private BuilderNivel miBuilder;
	private Nivel miNivel;
	private ArrayList<Elemento> misPociones;
	private Elemento miFruta;
	public static Properties configuration;
	private int cantidadPacDotsRestantes , cantidadFantasmasComidos;
	private DominioJuego miDominio;
	
	// ---------------------------------------- CONSTRUCTOR ------------------------------------
	public Juego(DominioJuego dominio) {
		this.miDominio = dominio;
		miFabricaEntidades = new FabricaGeneral(this, miDominio);
		miPlayer=new Player();
		gameOver = false;
		miGrilla = new Grilla();
		miAudio= new Audio(miDominio);
		cantidadPacDotsRestantes = 0;
		misEnemigos = new ArrayList<Enemigo>();
		cantidadFantasmasComidos = 0;
		vidasActuales = 3;
		misPociones = new ArrayList<Elemento>();
	}
	
	// ----------------------------------------      GETTERS     ------------------------------------
	public Principal getMiPersonajePrincipal() {
		return miPersonajePrincipal;
	}
	
	public DominioJuego getDominio() {
		return miDominio;
	}

	public Object getObjetoPausa() {
		return objetoPausa;
	}

	public boolean estaPausado() {
		return estaPausado;
	}
	
	public Grilla getGrilla() {
		return miGrilla;
	}

	public Nivel getNivel() {
		return miNivel;
	}

	public boolean isGameOver() {
		return gameOver;
	}
	
	public Player getPlayer() {
		return miPlayer;
	}
	
	public int getCantidadPacDotsRestantes() {
		return cantidadPacDotsRestantes;
	}

	public int getCantidadFantasmasComidos() {
		return cantidadFantasmasComidos;
	}

	public int getVidasActuales() {
		return vidasActuales;
	}

	
	public ArrayList<Enemigo> getMisEnemigos() {
		return misEnemigos;
	}
	
	public Reloj getMiReloj() {
		return miReloj;
	}

	// ----------------------------------------       SETTERS      -----------------------------------
	public void setMiVentana(Ventana miVentana) {
		this.miVentana = miVentana;
	}
	
	public void setBuilder(BuilderNivel builder) {
		this.miBuilder = builder;
		this.miNivel = miBuilder.getProduct();
	}
	
	public void setCantidadFantasmasComidos(int cantidadFantasmasComidos) {
		this.cantidadFantasmasComidos = cantidadFantasmasComidos;
	}

	// ---------------------------------------- ESTADOS DEL JUEGO ------------------------------------
	public void pausar_despausar() {
		
	}
	
	public void congratulations() {
		
	}
	
	public void gameOver() {
		miAudio.sonidoGameOver();
		miVentana.gameOver();
		gameOver=true;
	}
	
	// -------------------------------------- SIMPLES DE ATRIBUTOS ------------------------------------
	public void aumentarPuntaje(int puntaje) {
		miPlayer.setScore(puntaje);
		miVentana.actualizarPuntaje();
	}
	
	public void aumentarTiempo() {
		
	}
	
	public void perderVida() {
		vidasActuales--;
		miVentana.actualizarVidasActuales(vidasActuales);
		if(vidasActuales == 0)
			gameOver();
	}
	private void iniciarMusica() {
        miAudio.iniciarMusica();
    }
	
	public void decrementarCantidadPacDots() {
        cantidadPacDotsRestantes--;
    }
	
	//
	
	// ---------------------------------------- MOVIMIENTO ------------------------------------
	
	/**
     * Mueve un personaje, en un sentido
     * @param personaje El personaje que se movera
     */
    public synchronized void operar(Personaje p) {
    	if (!gameOver && !estaPausado) {
	    	p.mover();
    	}
    }
    public void cambiarSentidoActualPrincipal( int sentidoMovimiento) {
    	if (!gameOver && !estaPausado) {
    		if (miPersonajePrincipal.getSentidoActual() == Entidad.sentidoFijo) {
    			miPersonajePrincipal.setSentidoActual(sentidoMovimiento);
    		}
    		else {
    			miPersonajePrincipal.setSentidoSiguiente(sentidoMovimiento);
    		}
    	}
    	
    }
	
	// ---------------------------------------- SPAWNING ------------------------------------
	private void spawnearFantasmas() {
		misEnemigos.add(miFabricaEntidades.getBlinky());
		misEnemigos.add(miFabricaEntidades.getInky());
		misEnemigos.add(miFabricaEntidades.getPinky());
		misEnemigos.add(miFabricaEntidades.getClyde());
		for(Entidad fantasmas: misEnemigos) {
			miVentana.aparecerEntidad(fantasmas.getMiRepresentacion());
		}
		
		misEnemigos.get(0).iniciarHilo();
		
	}
	
	public void spawnearPocionCongelacion() {
		Elemento aux;
		aux = miFabricaEntidades.getPocionCongelacion();
		misPociones.add(0, aux);
		miVentana.aparecerEntidad(aux.getMiRepresentacion());
	}
	
	public void spawnearPocionVelocidad() {
		Elemento aux;
		aux = miFabricaEntidades.getPocionVelocidad();
		misPociones.add(1, aux);
		miVentana.aparecerEntidad(aux.getMiRepresentacion());
	}
	
	private void spawnearPrincipal() {
		miPersonajePrincipal = miFabricaEntidades.getPrincipal();
		miVentana.aparecerEntidad(miPersonajePrincipal.getMiRepresentacion());
	}
	
	public void spawnearFruta() {
		Elemento aux;
		aux = miFabricaEntidades.getFruta();
		miFruta = aux;
		miVentana.aparecerEntidad(aux.getMiRepresentacion());// aparece el recien agregado 
		// falta modelar todo lo relacionado al hilo de la fruta y aplicarle el nivel de estrategiaNivel
	}
	
	public void spawnearPacDots() {
		Elemento aux;
		for (Posicion spawn : PacDot.getMisSpawns()) {
			cantidadPacDotsRestantes++;
			aux = miFabricaEntidades.getPacDot(spawn);
			aux.getMiRepresentacion().aparecer(spawn);
			miVentana.aparecerEntidad(aux.getMiRepresentacion()); // aparece el recien agregado
		}
	}
	
	public void spawnearPowerPellets() {
		Elemento aux;
		for (Posicion spawn : PowerPellet.getMisSpawns()) {
			aux = miFabricaEntidades.getPowerPellet(spawn);
			aux.getMiRepresentacion().aparecer(spawn);
			miVentana.aparecerEntidad(aux.getMiRepresentacion()); // aparece el recien agregado
		}
	}
	
	public void despawnearFruta() {
		Bloque bloqueFruta = miGrilla.getBloque(Fruta.getMispawn().getY() / 25, Fruta.getMispawn().getX() / 25);
		miFruta.despawnear();
		bloqueFruta.getListaEntidades().removeAll(bloqueFruta.getListaRemovidos());
		bloqueFruta.limpiarListaRemovidos();
	}
	
	public void despawnearPocionCongelacion() {
		Bloque bloquePocion = miGrilla.getBloque(PocionCongelacion.getMispawn().getY() / 25, PocionCongelacion.getMispawn().getX() / 25);
		misPociones.get(0).despawnear();
		bloquePocion.getListaEntidades().removeAll(bloquePocion.getListaRemovidos());
		bloquePocion.limpiarListaRemovidos();
	}
	
	public void despawnearPocionVelocidad() {
		Bloque bloquePocion = miGrilla.getBloque(PocionVelocidad.getMispawn().getY() / 25, PocionVelocidad.getMispawn().getX() / 25);
		misPociones.get(1).despawnear();
		bloquePocion.getListaEntidades().removeAll(bloquePocion.getListaRemovidos());
		bloquePocion.limpiarListaRemovidos();
	}
 	
	// ---------------------------------------- INICIO & RESET ------------------------------------
	public void iniciarJuego() {
		spawnearPrincipal();
		spawnearPacDots();
		spawnearPowerPellets();
		spawnearFantasmas();
		iniciarMusica();
		iniciarReloj();
	}
	
	private void iniciarReloj() {
		miReloj = new Reloj(miPersonajePrincipal.getVelocidadActual(), this);
		miReloj.start();
	}
	
	public void resetear() {
	
	}
	
	// ---------------------------------------- PLAYER->NOMBRE ------------------------------------
	private String getNombrePlayer() {
		return null;
	}
	
	// ---------------------------------------- CONFIGURATION ------------------------------------
	private static void loadConfiguration() {
		
	}
}
