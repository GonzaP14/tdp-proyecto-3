package entidadesLogicas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import audio.Audio;
import dominios.DominioJuego;
import elementos.Elemento;
import gui.Ventana;
import launcher.Launcher;
import niveles.Grilla;
import niveles.Nivel;
import personajes.Enemigo;
import personajes.Personaje;
import personajes.Principal;

public class Juego {
	
	private static final Object objetoReloj = new Object();
	
	private Reloj miReloj;
	private Player miPlayer;
	private Leaderboard miLeaderboard;
	private Audio miAudio;
	private Ventana miVentana;
	private Grilla miGrilla;
	private Nivel miNivel;
	private EntidadesJuego misEntidades;
	private DominioJuego miDominio;
	public static Properties configuration;
	private int cantidadFantasmasComidos, cantidadPacDots, vidasActuales;
	private boolean gameOver, estaPausado;
	
	public Juego(DominioJuego dominio) {
		miDominio = dominio;
		miGrilla = new Grilla();
		miAudio = new Audio(miDominio);
		miPlayer = new Player();
		miLeaderboard = new Leaderboard();
		loadConfiguration();
		cantidadFantasmasComidos = 0;
		vidasActuales = 3;
		gameOver = false;
		estaPausado = false;
	}

	// Setters.
		
	public void setVentana(Ventana miVentana) {
		this.miVentana = miVentana;
	}
		
	public void setCantidadFantasmasComidos(int cantidadFantasmasComidos) {
		this.cantidadFantasmasComidos = cantidadFantasmasComidos;
	}
	
	// Getters
	
	public Ventana getVentana() {
		return miVentana;
	}
	
	public Principal getPrincipal() {
		return misEntidades.getPrincipal();
	}
	
	public List<Enemigo> getEnemigos() {
		return misEntidades.getEnemigos();
	}
	
	public DominioJuego getDominio() {
		return miDominio;
	}

	public Object getObjetoReloj() {
		return objetoReloj;
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

	public int getCantidadFantasmasComidos() {
		return cantidadFantasmasComidos;
	}

	public int getVidasActuales() {
		return vidasActuales;
	}

	
	public Reloj getMiReloj() {
		return miReloj;
	}

	public Leaderboard getMiLeaderboard() {
		return miLeaderboard;
	}

	// Estados del juego.
	
	public void pausar_despausar() {
		if (estaPausado == false) {
			pausarDespausarRelojes();
			miAudio.mutear();
			miVentana.dispose();
		} else {
			pausarDespausarRelojes();
			miAudio.mutear();
		}
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
	
	public void muted() {
		miAudio.mutear();
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
	
	public void procesarPuntaje(String nombre) {
		miPlayer.setNombre(nombre);
		miLeaderboard.addPlayer(miPlayer);
	}

	public void removerPacDot() {
		cantidadPacDots --;
		
		if (cantidadPacDots == 0 && miNivel.getNivelActual() == 3) {
				congratulations();
		} 
		else if (cantidadPacDots == 0) {
			Launcher.pasarNivel();
			resetRelojes();
		}
	}
	
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
    public void cambiarSentido(int sentidoMovimiento) {
    	misEntidades.cambiarSentidoPrincipal(sentidoMovimiento);
    }
	
	// ---------------------------------------- SPAWNING ------------------------------------
	
    public void aparecerEntidades() {
    	misEntidades.aparecerEntidadesGenerales();
    	cantidadPacDots = misEntidades.getPacDots().size();
	}
    
    public void aparecerFruta() {
		misEntidades.aparecerFruta();
	}

	public void aparecerPocionBomba() {
		misEntidades.aparecerPocionBomba();
	}

	public void aparecerPocionVelocidad() {
		misEntidades.aparecerPocionVelocidad();
	}
    
	public void despawnearFruta() {
		misEntidades.despawnearFruta();
	}
	
	public void despawnearPocionBomba() {
		misEntidades.despawnearPocionBomba();	
	}
	
	public void despawnearPocionVelocidad() {
		misEntidades.despawnearPocionVelocidad();
	}
	
	public void respawnearEnemigos() {
		for (Enemigo enemigo : misEntidades.getEnemigos()) {
			enemigo.reaparecer();
		}
	}
 	
	// ---------------------------------------- INICIO & RESET ------------------------------------
	public void iniciarJuego() {
		misEntidades = new EntidadesJuego(this, miDominio);
		misEntidades.crearEntidades();
		aparecerEntidades();
		iniciarMusica();
		iniciarReloj();
		iniciarEnemigos();
	}
	
	private void iniciarReloj() {
		miReloj = new Reloj(misEntidades.getPrincipal().getVelocidadActual(), this);
		miReloj.start();
	}
	
	private void iniciarEnemigos() {
		for (Enemigo e: misEntidades.getEnemigos()) {
			e.iniciarHilo();
		}
	}
	
	public void setNivel(Nivel nivel) {
		this.miNivel = nivel;
	}
	
	public void pausarDespausarRelojes() {
		if (!estaPausado) {
			estaPausado = true;
		}
		else {
			synchronized (objetoReloj) {
				estaPausado = false;
				objetoReloj.notifyAll();
			}
		}
	}
	
	// ---------------------------------------- CONFIGURATION ------------------------------------
	private static void loadConfiguration() {
		try (InputStream input = new FileInputStream("./configuration.properties")) {
            Juego.configuration = new Properties();
            Juego.configuration.load(input);
	    } 
		catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	public synchronized void reset() {
		miGrilla.reset();
		misEntidades.reset();
	}
	
	public void resetRelojes() {
		miReloj.setCantidadTicks(0);
		for(Enemigo e : misEntidades.getEnemigos()) {
			e.getMiHilo().setCantidadTicks(0);
			e.setVelocidadPredeterminada(miNivel.getVelocidadEnemigos());
			e.setVelocidadActual(e.getVelocidadPredeterminada());
		}
	}

}
