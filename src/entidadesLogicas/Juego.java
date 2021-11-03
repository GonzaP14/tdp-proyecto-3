package entidadesLogicas;

import java.util.ArrayList;
import java.util.Properties;
import audio.Audio;
import entidadesGraficas.PrincipalGrafico;
import gui.Ventana;
import personajes.Personaje;
import personajes.Principal;
import productos.FabricaEntidades;


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
	private ArrayList<Entidad> misElementos, misEnemigos;
	private Personaje miPersonajePrincipal;
	private EstrategiaNivel nivelActual;
	public static Properties configuration;
	
	// Atributos de clase
	public static int DominioMarioBros;
	public static int DominioMemoji;
	
	// ---------------------------------------- CONSTRUCTOR ------------------------------------
	public Juego(EstrategiaNivel nivelActual, FabricaEntidades miFabricaEntidades) {
		this.miFabricaEntidades = miFabricaEntidades;
		miPersonajePrincipal = miFabricaEntidades.getPrincipal();
		this.nivelActual = nivelActual;
		miReloj = new Reloj(1,this);
		gameOver = false;
		miReloj.start();
	}
	
	// ----------------------------------------      GETTERS     ------------------------------------
	public Personaje getMiPersonajePrincipal() {
		return miPersonajePrincipal;
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

	public boolean isGameOver() {
		return gameOver;
	}

	// ---------------------------------------- ESTADOS DEL JUEGO ------------------------------------
	public void pausar_despausar() {
		
	}
	
	public void congratulations() {
		
	}
	
	public void gameOver() {
		
	}
	
	// -------------------------------------- SIMPLES DE ATRIBUTOS ------------------------------------
	public void aumentarPuntaje() {
		
	}
	
	public void aumentarTiempo() {
		
	}
	
	public void perderVida() {
		
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
	    	miPersonajePrincipal.setSentidoActual(sentidoMovimiento);
    	}
    }
	
	// ---------------------------------------- SPAWNING ------------------------------------
	private void spawnearFantasmas() {
		
	}
	
	private void spawnearPrincipal() {
		
	}
	
	private void spawnearElementos(EstrategiaNivel nivelActual) {
		
	}
	// ---------------------------------------- INICIO & RESET ------------------------------------
	private void iniciarJuego() {
		
	}
	
	private void iniciarReloj() {
		
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
