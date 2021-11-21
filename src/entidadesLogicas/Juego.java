package entidadesLogicas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import audio.Audio;
import elementos.Elemento;
import elementos.PacDot;
import elementos.PowerPellet;
import gui.Ventana;
import launcher.Launcher;
import personajes.Enemigo;
import personajes.Personaje;
import personajes.Principal;
import productos.FabricaEntidades;
import productos.FabricaGeneral;

public class Juego {
	
	// Atributos de instancia 
	private boolean gameOver, estaPausado;
	private int vidasActuales;
	private static final Object objetoReloj = new Object();
	private FabricaEntidades miFabricaEntidades;
	private Reloj miReloj;
	private Player miPlayer;
	private Leaderboard miLeaderboard;
	private Audio miAudio;
	private Ventana miVentana;
	private Grilla miGrilla;
	private List<Enemigo>  misEnemigos;
	private Principal miPersonajePrincipal;
	private Nivel miNivel;
	private List<Elemento> misPociones, misPacDots, misPowerPellets;
	private Elemento miFruta;
	public static Properties configuration;
	private int cantidadFantasmasComidos;
	private DominioJuego miDominio;
	
	// ---------------------------------------- CONSTRUCTOR ------------------------------------
	public Juego(DominioJuego dominio) {
		this.miDominio = dominio;
		miFabricaEntidades = new FabricaGeneral(this, miDominio);
		miPlayer = new Player();
		gameOver = false;
		miGrilla = new Grilla();
		miAudio = new Audio(miDominio);
		cantidadFantasmasComidos = 0;
		vidasActuales = 3;
		estaPausado = false;
		
		misEnemigos = Collections.synchronizedList(new ArrayList<Enemigo>());
		misPociones = Collections.synchronizedList(new ArrayList<Elemento>());
		misPacDots = Collections.synchronizedList(new ArrayList<Elemento>());
		misPowerPellets = Collections.synchronizedList(new ArrayList<Elemento>());
		
		miLeaderboard = new Leaderboard();
		loadConfiguration();
	}
	
	// ----------------------------------------      GETTERS     ------------------------------------
	public Principal getMiPersonajePrincipal() {
		return miPersonajePrincipal;
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
	
	public List<Elemento> getMisPacDots() {
		return misPacDots;
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

	
	public List<Enemigo> getMisEnemigos() {
		return misEnemigos;
	}
	
	public Reloj getMiReloj() {
		return miReloj;
	}

	public Leaderboard getMiLeaderboard() {
		return miLeaderboard;
	}

	// ----------------------------------------       SETTERS      -----------------------------------
	public void setMiVentana(Ventana miVentana) {
		this.miVentana = miVentana;
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
	
	public void procesarPuntaje(String nombre) {
		miPlayer.setNombre(nombre);
		miLeaderboard.addPlayer(miPlayer);
	}

	public void removerPacDot(Elemento pacDotARemover) {
		misPacDots.remove(pacDotARemover);
		if (misPacDots.size() == 0) {
			if (miNivel.getNivelActual() == 2) {
				congratulations();
			}
			else {
				Launcher.pasarNivel();
			}
		}
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
		for(Enemigo fantasma: misEnemigos) {
			miVentana.aparecerEntidad(fantasma.getMiRepresentacion());
			fantasma.iniciarHilo();
		}
	}
	
	public void spawnearPocionBomba() {
		misPociones.add(0, miFabricaEntidades.getPocionBomba());
		miVentana.aparecerEntidad(misPociones.get(0).getMiRepresentacion());
	}
	
	public void spawnearPocionVelocidad() {
		misPociones.add(1, miFabricaEntidades.getPocionVelocidad());
		miVentana.aparecerEntidad(misPociones.get(1).getMiRepresentacion());
	}
	
	private void spawnearPrincipal() {
		miPersonajePrincipal = miFabricaEntidades.getPrincipal();
		miVentana.aparecerEntidad(miPersonajePrincipal.getMiRepresentacion());
	}
	
	public void spawnearFruta() {
		miFruta = miFabricaEntidades.getFruta();
		miVentana.aparecerEntidad(miFruta.getMiRepresentacion());
	}
	
	private void spawnearPacDots() {
		Elemento nuevoPacDot;
		for (Posicion spawn : PacDot.getMisSpawns()) {
			nuevoPacDot = miFabricaEntidades.getPacDot(spawn);
			misPacDots.add(nuevoPacDot);
			nuevoPacDot.getMiRepresentacion().aparecer(spawn);
			miVentana.aparecerEntidad(nuevoPacDot.getMiRepresentacion()); // aparece el recien agregado
		}
	}
	
	private void spawnearPowerPellets() {
		Elemento aux;
		for (Posicion spawn : PowerPellet.getMisSpawns()) {
			aux = miFabricaEntidades.getPowerPellet(spawn);
			misPowerPellets.add(aux);
			aux.getMiRepresentacion().aparecer(spawn);
			miVentana.aparecerEntidad(aux.getMiRepresentacion()); // aparece el recien agregado
		}
	}
	
	
	
	public void despawnearFruta() {
		miFruta.despawnear();
		miGrilla.getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(miFruta);
		miGrilla.getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miGrilla.getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
		miGrilla.getBloque(miFruta.getPosicion().getY() / Ventana.pixelesBloque, miFruta.getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
	}
	
	
	public void despawnearPocionBomba() {
		misPociones.get(0).despawnear();
		miGrilla.getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(misPociones.get(0));
		miGrilla.getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miGrilla.getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
		miGrilla.getBloque(misPociones.get(0).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(0).getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
	}
	
	public void despawnearPocionVelocidad() {
		misPociones.get(1).despawnear();
		miGrilla.getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).agregarAListaRemovidos(misPociones.get(1));
		miGrilla.getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).getListaEntidades().removeAll(miGrilla.getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).getListaRemovidos());
		miGrilla.getBloque(misPociones.get(1).getPosicion().getY() / Ventana.pixelesBloque, misPociones.get(1).getPosicion().getX() / Ventana.pixelesBloque).limpiarListaRemovidos();
	}
	
	public void respawnearEnemigos() {
		for (Enemigo enemigo : misEnemigos) {
			enemigo.reaparecer();
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
		miReloj = new Reloj(miPersonajePrincipal.getVelocidadActual(), this);
		miReloj.start();
	}
	
	public void resetear() {
	
	}
	

	public void reiniciarNivel() {
		pausarDespausarRelojes();
		
//		desaparecerEntidadesRestantes();
		
//		miVentana.pasarNivel();
		misEnemigos = Collections.synchronizedList(new ArrayList<Enemigo>());
		misPociones = Collections.synchronizedList(new ArrayList<Elemento>());
		misPacDots = Collections.synchronizedList(new ArrayList<Elemento>());
		misPowerPellets = Collections.synchronizedList(new ArrayList<Elemento>());
		
		spawnearPrincipal();
		spawnearPacDots();
		spawnearPowerPellets();
		spawnearFantasmas();
		
		pausarDespausarRelojes();
	}
	
	public void setNivel(Nivel nivel) {
		this.miNivel = nivel;
	}

	private void desaparecerEntidadesRestantes() {
		miPersonajePrincipal.getMiRepresentacion().desaparecer();
		for (Enemigo enemigo : misEnemigos) {
			enemigo.getMiRepresentacion().desaparecer();
		}
		for (Elemento pacDot : misPacDots) {
			pacDot.getMiRepresentacion().desaparecer();
		}
		for (Elemento powerPellet : misPowerPellets) {
			powerPellet.getMiRepresentacion().desaparecer();
		}
		for (Elemento pocion : misPociones) {
			pocion.getMiRepresentacion().desaparecer();
		}
		if (miFruta != null) {
			miFruta.getMiRepresentacion().desaparecer();
		}
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
}
