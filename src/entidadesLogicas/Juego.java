package entidadesLogicas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import audio.Audio;
import elementos.Elemento;
import elementos.Fruta;
import elementos.PacDot;
import elementos.PocionBomba;
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
	private int vidasActuales;
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

	public Leaderboard getMiLeaderboard() {
		return miLeaderboard;
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
		// FOR CORRECTO, USAR SOLO CUANDO SE TENGA LA IA DE LOS 4 FANTASMAS 
//		for(Enemigo fantasma: misEnemigos) {
//			miVentana.aparecerEntidad(fantasma.getMiRepresentacion());
//			fantasma.iniciarHilo();
//		}
		
//		// ESTO BORRARLO DESPUES
		miVentana.aparecerEntidad(misEnemigos.get(0).getMiRepresentacion());
		misEnemigos.get(0).iniciarHilo();
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
	
	
	public void despawnearPocionBomba() {
		Bloque bloquePocion = miGrilla.getBloque(PocionBomba.getMispawn().getY() / 25, PocionBomba.getMispawn().getX() / 25);
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
	
	public void procesarPuntaje(String nombre) {
		miPlayer.setNombre(nombre);
		miLeaderboard.addPlayer(miPlayer);
	}
}
