package entidadesLogicas;

import java.util.ArrayList;
import java.util.Properties;
import audio.Audio;
import entidadesGraficas.EnemigoGrafico;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.PrincipalGrafico;
import gui.Ventana;
import personajes.Blinky;
import personajes.Enemigo;
import elementos.*;
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
	private Principal miPersonajePrincipal;
	private BuilderNivel nivelActual;
	public static Properties configuration;
	private int cantidadPacDotsRestantes;
	
	// Atributos de clase
	public static int DominioMarioBros;
	public static int DominioMemoji;
	
	// ---------------------------------------- CONSTRUCTOR ------------------------------------
	public Juego(BuilderNivel nivelActual, FabricaEntidades miFabricaEntidades) {
		this.miFabricaEntidades = miFabricaEntidades;
		miPersonajePrincipal = miFabricaEntidades.getPrincipal();
		
		this.nivelActual = nivelActual;
		miReloj = new Reloj(1,this);
		gameOver = false;
		miReloj.start();
		miGrilla = new Grilla();
	}
	
	// ----------------------------------------      GETTERS     ------------------------------------
	public Principal getMiPersonajePrincipal() {
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
	
	public void spawnearFruta() {
		miFabricaEntidades.getFruta();
		// falta modelar todo lo relacionado al hilo de la fruta y aplicarle el nivel de estrategiaNivel
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
