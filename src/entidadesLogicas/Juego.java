package entidadesLogicas;

import java.util.ArrayList;
import java.util.Properties;
import audio.Audio;
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
	private ArrayList<Entidad> misElementos, misEnemigos;
	private Principal miPersonajePrincipal;
	private BuilderNivel nivelActual;
	public static Properties configuration;
	private int cantidadPacDotsRestantes;
	private int dominio;
	
	// Atributos de clase
	public static int DominioMarioBros;
	public static int DominioMemoji;
	
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
		gameOver = false;
		miGrilla = new Grilla();
		misElementos = new ArrayList<Entidad>();
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
		miPersonajePrincipal = miFabricaEntidades.getPrincipal();
		miVentana.aparecerEntidad(miPersonajePrincipal.getMiRepresentacion());
	}
	
	public void spawnearFruta() {
		misElementos.add(miFabricaEntidades.getFruta());
		miVentana.aparecerEntidad(misElementos.get(misElementos.size() - 1).getMiRepresentacion()); // aparece el recien agregado
		// falta modelar todo lo relacionado al hilo de la fruta y aplicarle el nivel de estrategiaNivel
	}
	
	public void spawnearPacDots() {
		for (Posicion spawn : PacDot.getMisSpawns()) {
			misElementos.add(miFabricaEntidades.getPacDot());
			misElementos.get(misElementos.size()-1).getMiRepresentacion().aparecer(spawn);
			miVentana.aparecerEntidad(misElementos.get(misElementos.size()-1).getMiRepresentacion()); // aparece el recien agregado
		}
		// falta modelar todo lo relacionado al hilo de la fruta y aplicarle el nivel de estrategiaNivel
	}
	
	public void spawnearPowerPellets() {
		for (Posicion spawn : PowerPellet.getMisSpawns()) {
			misElementos.add(miFabricaEntidades.getPowerPellet());
			misElementos.get(misElementos.size()-1).getMiRepresentacion().aparecer(spawn);
			miVentana.aparecerEntidad(misElementos.get(misElementos.size()-1).getMiRepresentacion()); // aparece el recien agregado
		}
	}
 	
	// ---------------------------------------- INICIO & RESET ------------------------------------
	public void iniciarJuego() {
		spawnearPrincipal();
		spawnearPacDots();
		spawnearPowerPellets();
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
