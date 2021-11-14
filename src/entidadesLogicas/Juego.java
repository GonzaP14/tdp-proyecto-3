package entidadesLogicas;

import java.util.ArrayList;
import java.util.Properties;
import audio.Audio;
import elementos.Elemento;
import elementos.PacDot;
import elementos.PowerPellet;
import gui.Ventana;
import personajes.Principal;
import productos.FabricaEntidades;
import productos.FabricaMarioBros;
import productos.FabricaMemoji;


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
	private ArrayList<Entidad>  misEnemigos;
	private Principal miPersonajePrincipal;
	private BuilderNivel nivelActual;
	public static Properties configuration;
	private int cantidadPacDotsRestantes;
	private int dominio;
	
	// Atributos de clase
	public static int DominioMarioBros=0;
	public static int DominioMemoji=1;
	
	// ---------------------------------------- CONSTRUCTOR ------------------------------------
	public Juego(BuilderNivel nivelActual, int dominio) {
		this.dominio=dominio;
		if(dominio == DominioMarioBros) {
			miFabricaEntidades = new FabricaMarioBros(this);
		}
		else if(dominio == DominioMemoji) {
			miFabricaEntidades = new FabricaMemoji(this);
		}
	
		this.nivelActual = nivelActual;
		miPlayer=new Player();
		gameOver = false;
		miGrilla = new Grilla();
		miAudio=new Audio(dominio);
		cantidadPacDotsRestantes = 0;
		misEnemigos = new ArrayList<Entidad>();
	}
	
	// ----------------------------------------      GETTERS     ------------------------------------
	public Principal getMiPersonajePrincipal() {
		return miPersonajePrincipal;
	}
	
	public int getDominio() {
		return dominio;
	}

	public Object getObjetoPausa() {
		return objetoPausa;
	}

	public boolean estaPausado() {
		return estaPausado;
	}
	
	public Grilla getMiGrilla() {
		return miGrilla;
	}

	public BuilderNivel getNivelActual() {
		return nivelActual;
	}

	public boolean isGameOver() {
		return gameOver;
	}
	
	public Player getMiPlayer() {
		return miPlayer;
	}
	
	// ----------------------------------------       SETTERS      -----------------------------------
	public void setMiVentana(Ventana miVentana) {
		this.miVentana = miVentana;
	}

	// ---------------------------------------- ESTADOS DEL JUEGO ------------------------------------
	public void pausar_despausar() {
		
	}
	
	public void congratulations() {
		
	}
	
	public void gameOver() {
		
	}
	
	// -------------------------------------- SIMPLES DE ATRIBUTOS ------------------------------------
	public void aumentarPuntaje(int puntaje) {
		miPlayer.setScore(puntaje);
		miVentana.actualizarPuntaje();
	}
	
	public void aumentarTiempo() {
		
	}
	
	public void perderVida() {
		
	}
	private void iniciarMusica() {
        miAudio.iniciarMusica();
    }
	//
	
	// ---------------------------------------- MOVIMIENTO ------------------------------------
	
	/**
     * Mueve un personaje, en un sentido
     * @param personaje El personaje que se movera
     */
    public synchronized void operar() {
    	if (!gameOver && !estaPausado) {
	    	miPersonajePrincipal.mover();
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
		
	}
	
	private void spawnearPrincipal() {
		miPersonajePrincipal = miFabricaEntidades.getPrincipal();
		miVentana.aparecerEntidad(miPersonajePrincipal.getMiRepresentacion());
	}
	
	public void spawnearFruta() {
		Elemento aux;
		aux = miFabricaEntidades.getFruta();
		miVentana.aparecerEntidad(aux.getMiRepresentacion());// aparece el recien agregado // aparece el recien agregado
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
		miReloj = new Reloj(1, this);
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
