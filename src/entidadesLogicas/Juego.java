package entidadesLogicas;

import java.util.ArrayList;
import java.util.Properties;

import audio.Audio;
import gui.Ventana;
import personajes.Personaje;
import productos.FabricaElementos;
import productos.FabricaPersonajes;

public class Juego {
	
	// Atributos de instancia 
	private boolean gameOver, estaPausado;
	private int minuto, segundos, nivelActual, vidasActuales;
	private Object objetoPausa;
	private FabricaPersonajes miFabricaPersonajes;
	private FabricaElementos miFabricaElementos;
	private Reloj miReloj;
	private Player miPlayer;
	private Leaderboard miLeaderboard;
	private Audio miAudio;
	private Ventana miVentana;
	private Grilla miGrilla;
	private ArrayList<Entidad> misElementos, misEnemigos;
	private Personaje miPersonajePrincipal;
	public static Properties configuration;
	
	// Atributos de clase
	public static int DominioMarioBros;
	public static int DominioMemoji;
	
	// ---------------------------------------- CONSTRUCTOR ------------------------------------
	public Juego(Integer dominio) {
		
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
     * @param sentidoMovimiento El sentido en el que el personaje se movera
     */
    public synchronized void operar(Personaje personaje, int sentidoMovimiento) {
    	if (!gameOver && !estaPausado) {
	    	personaje.mover(sentidoMovimiento);
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
