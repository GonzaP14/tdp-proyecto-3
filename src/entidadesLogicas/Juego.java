package entidadesLogicas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import audio.Audio;
import gui.Ventana;
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
	private Entidad miPersonajePrincipal;
	public static Properties configuration;
	
	// Atributos de clase
	public static int DominioMarioBros;
	public static int DominioMemoji;
	
	// ---------------------------------------- CONSTRUCTOR ------------------------------------
	public Juego(Integer dominio) {
		
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
	
	// ---------------------------------------- MOVIMIENTO ------------------------------------
	public void operar() {
		
	}
	
	private void moverVerticalmente() {
		
	}
	
	private void moverLateralmente() {
		
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
