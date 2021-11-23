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
import niveles.Nivel;
import personajes.Enemigo;
import personajes.Personaje;
import personajes.Principal;

/**
 * Clase Juego - Representa la clase lógica central del PacMan.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
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
	
	/**
	 * Crea un nuevo Juego.
	 * @param dominio Dominio de juego asociado.
	 */
	public Juego(DominioJuego dominio) {
		miDominio = dominio;
		miGrilla = new Grilla();
		createPlayer();
		miLeaderboard = new Leaderboard();
		loadConfiguration();
		gameOver = false;
		estaPausado = false;
	}
	
	/**
	 * Crea un nuevo jugador.
	 */
	public void createPlayer() {
		miPlayer = new Player();
		setCantidadFantasmasComidos(0);
		setCantidadVidas(3);	
	}
	
	/**
	 * Carga la configuración de las propiedades del Leaderboard.
	 */
	private static void loadConfiguration() {
		try (InputStream input = new FileInputStream("./configuration.properties")) {
            Juego.configuration = new Properties();
            Juego.configuration.load(input);
	    } 
		catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	/**
	 * Inicia la ejecución del juego.
	 */
	public void iniciarJuego() {
		misEntidades = new EntidadesJuego(this, miDominio);
		misEntidades.crearEntidades();
		cantidadPacDots = misEntidades.getPacDots().size();
		aparecerEntidades();
		crearReloj();
		iniciarRelojes();
		iniciarMusica();
	}
	
	/**
	 * Inicia la ejecución de los relojes del juego.
	 */
	public void iniciarRelojes() {
		iniciarHiloPrincipal();
		iniciarHilosEnemigos();
	}

	/**
	 * Crea el reloj principal del juego.
	 */
	private void crearReloj() {
		miReloj = new Reloj(misEntidades.getPrincipal().getVelocidadActual(), this);
	}

	/**
	 * Inicia la ejecución del reloj principal.
	 */
	private void iniciarHiloPrincipal() {		
		miReloj.start();
	}
	
	/**
	 * Inicia la ejecución de los hilos de los enemigos.
	 */
	private void iniciarHilosEnemigos() {
		for (Enemigo e: misEntidades.getEnemigos()) {
			e.iniciarHilo();
		}
	}    
	
	/**
	 * Inicia la musica del juego.
	 */
	public void iniciarMusica() {
		miAudio = new Audio(miDominio);
        miAudio.iniciarMusica();
    }
	
	/**
	 * Establece la ventana asociada al juego.
	 * @param miVentana Ventana asociada.
	 */
	public void setVentana(Ventana miVentana) {
		this.miVentana = miVentana;
	}
	
	/**
	 * Establece el nivel asociado al juego.
	 * @param nivel Nivel asociado.
	 */
	public void setNivel(Nivel nivel) {
		this.miNivel = nivel;
	}
		
	/**
	 * Establece la cantidad de fantasmas comidos de la partida actual.
	 * @param cantidadFantasmasComidos Cantidad de fantasmas comidos actualmente.
	 */
	public void setCantidadFantasmasComidos(int cantidadFantasmasComidos) {
		this.cantidadFantasmasComidos = cantidadFantasmasComidos;
	}

	/**
	 * Establece la cantidad de vidas de la partida actual.
	 * @param cantidadVidas Cantidad de vidas actuales.
	 */
	public void setCantidadVidas(int cantidadVidas) {
		this.vidasActuales = cantidadVidas;
	}
	
	/**
	 * Establece la finalización de la partida actual.
	 * @param gameOver true si la partida actual finalizo y false en caso contrario.
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	/**
	 * Establece la pausa de la partida actual.
	 * @param pausado true si el juego esta pausado y false en caso contrario.
	 */
	public void setPausado(boolean pausado) {
		this.estaPausado = pausado;
	}
	
	/**
	 * Se encarga de pausar y despausar el juego.
	 * Si el juego se encuentra despausado, se pausa. De lo contrario, lo despausa.
	 */
	public void pausarDespausarJuego() {
		pausarDespausarRelojes();
		miAudio.mutear();
	}
	
	/**
	 * Pausa y despausa los relojes del juego.
	 * Si los relojes se encuentran en ejecución, los pausa. De los contrario, los reanuda.
	 */
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
	
	/**
	 * Establece la finalización de una partida exitosa.
	 */
	public void congratulations() {
		miAudio.sonidoWin();
		miVentana.win();
		gameOver = true;
	}
	
	/**
	 * Establece la finalización de una partida no exitosa.
	 */
	public void gameOver() {
		miAudio.sonidoGameOver();
		miVentana.gameOver();
		gameOver = true;
	}
	
	/**
	 * Silencia la musica del juego.
	 */
	public void muted() {
		miAudio.mutear();
	}
	
	/**
	 * Establece que se perdió una vida en la partida actual.
	 */
	public void perderVida() {
		vidasActuales --;
		miVentana.actualizarVidasActuales(vidasActuales);
		
		if(vidasActuales == 0) {
			gameOver();
		}
	}
	
	/**
	 * Aumenta el puntaje de la partida actual.
	 * @param puntaje Aumento deseado.
	 */
	public void aumentarPuntaje(int puntaje) {
		miPlayer.setScore(puntaje);
		miVentana.actualizarPuntaje();
	}
	
	/**
	 * Procesa el puntaje del jugador actual.
	 * @param nombre Nombre del jugador.
	 */
	public void procesarPuntaje(String nombre) {
		miPlayer.setNombre(nombre);
		miLeaderboard.addPlayer(miPlayer);
	}	

	/**
     * Realiza el movimiento de un personaje.
     * @param personaje Personaje que se desea mover.
     */
    public synchronized void operar(Personaje p) {
    	if (!gameOver && !estaPausado) {
	    	p.mover();
    	}
    }
	
    /**
     * Realiza el cambio de sentido del personaje principal del juego.
     * @param sentidoMovimiento sentido del personaje principal.
     */
    public void cambiarSentidoPrincipal(int sentidoMovimiento) {
        if (!gameOver && !estaPausado()) {
            if (misEntidades.getPrincipal().getSentidoActual() == Entidad.sentidoFijo) {
            	misEntidades.getPrincipal().setSentidoActual(sentidoMovimiento);
            }
            else {
            	misEntidades.getPrincipal().setSentidoSiguiente(sentidoMovimiento);
            }
        }
    }
    
    /**
     * Decrementa la cantidad de PacDots actuales en una unidad.
     */
	public void removerPacDot() {
		cantidadPacDots --;
		
		if (cantidadPacDots == 0 && miNivel.getNivelActual() == 3) {
			congratulations();
		} 
		else if (cantidadPacDots == 0) {
			Launcher.pasarNivel();
		}
	}
	
	/**
	 * Resetea el juego para un cambio de nivel.
	 */
	public synchronized void reset() {
		miGrilla.reset();
		misEntidades.reset();
		miAudio.reset();
		cantidadPacDots = misEntidades.getPacDots().size();
		resetRelojes();
	}
	
	/**
	 * Resetea los relojes del juego.
	 */
	public void resetRelojes() {
		miReloj.setCantidadTicks(0);
		
		for (Enemigo e: misEntidades.getEnemigos()) {
			e.getMiHilo().setCantidadTicks(0);
			e.setVelocidadPredeterminada(miNivel.getVelocidadEnemigos());
			e.setVelocidadActual(e.getVelocidadPredeterminada());
		}
	}

	/**
	 * Reinicia el juego para una nueva partida.
	 */
	public void restart() {
		reset();
		restartRelojes();
		setGameOver(false);
		setPausado(false);
		createPlayer();
	}
	
	/**
	 * Reinicia los relojes del juego.
	 */
	public void restartRelojes() {
		miReloj = new Reloj(misEntidades.getPrincipal().getVelocidadActual(), this);
		
		for (Enemigo e: misEntidades.getEnemigos()) {
			e.crearHilo(e);
		}
	}
    
	/**
	 * Aparece la entidades generales del juego en la ventana.
	 */
    public void aparecerEntidades() {
    	misEntidades.aparecerEntidadesGenerales();
	}
    
    /**
     * Aparece la Fruta en la ventana.
     */
    public void aparecerFruta() {
		misEntidades.aparecerFruta();
	}

    /**
     * Aparece la PocionBomba en la ventana.
     */
	public void aparecerPocionBomba() {
		misEntidades.aparecerPocionBomba();
	}

	/**
	 * Aparece la PocionVelocidad en la ventana.
	 */
	public void aparecerPocionVelocidad() {
		misEntidades.aparecerPocionVelocidad();
	}
    
	/**
	 * Despawnea la Fruta.
	 */
	public void despawnearFruta() {
		misEntidades.despawnearFruta();
	}
	
	/**
	 * Despawnea la PocionBomba.
	 */
	public void despawnearPocionBomba() {
		misEntidades.despawnearPocionBomba();	
	}
	
	/**
	 * Despawnea la PocionVelocidad.
	 */
	public void despawnearPocionVelocidad() {
		misEntidades.despawnearPocionVelocidad();
	}
	
	/**
	 * Respawnea los enemigos.
	 */
	public void respawnearEnemigos() {
		for (Enemigo enemigo : misEntidades.getEnemigos()) {
			enemigo.reaparecer();
		}
	}
	
	/**
	 * Consulta el dominio de juego.
	 * @return Dominio de juego de la partida.
	 */
	public DominioJuego getDominio() {
		return miDominio;
	}
	
	/**
	 * Consulta la ventana asociada al juego.
	 * @return Ventana actual del juego.
	 */
	public Ventana getVentana() {
		return miVentana;
	}
	
	/**
	 * Consulta el personaje principal del juego.
	 * @return Personaje principal de la partida.
	 */
	public Principal getPrincipal() {
		return misEntidades.getPrincipal();
	}
	
	/**
	 * Consulta los enemigos del juego.
	 * @return Enemigos de la partida.
	 */
	public List<Enemigo> getEnemigos() {
		return misEntidades.getEnemigos();
	}
	
	/**
	 * Consulta la fruta del juego.
	 * @return Fruta de la partida.
	 */
	public Elemento getFruta() {
		return misEntidades.getFruta();
	}
	
	/**
	 * Consulta el objeto pausa del juego.
	 * @return Object utilizado para la pausa.
	 */
	public Object getObjetoReloj() {
		return objetoReloj;
	}
	
	/**
	 * Consulta la grilla del juego.
	 * @return Grilla lógica del juego.
	 */
	public Grilla getGrilla() {
		return miGrilla;
	}

	/**
	 * Consulta el nivel del juego.
	 * @return Nivel actual de la partida.
	 */
	public Nivel getNivel() {
		return miNivel;
	}
	
	/**
	 * Consulta el jugador de la partida actual.
	 * @return Player actual.
	 */
	public Player getPlayer() {
		return miPlayer;
	}
	
	/**
	 * Consulta el reloj principal del juego.
	 * @return Reloj principal.
	 */
	public Reloj getReloj() {
		return miReloj;
	}

	/**
	 * Consulta el LeaderBoard del juego.
	 * @return LeaderBoard asociado.
	 */
	public Leaderboard getLeaderBoard() {
		return miLeaderboard;
	}
	
	/**
	 * Consulta si el juego esta pausado actualmente.
	 * @return true en caso afirmativo y false en caso contrario.
	 */
	public boolean estaPausado() {
		return estaPausado;
	}
	
	/**
	 * Consulta si la partida actual finalizo.
	 * @return true en caso afirmativo y false en caso contrario.
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Consulta si la musica del juego esta sileciada.
	 * @return true en caso afirmativo y false en caso contrario.
	 */
	public boolean isMuted() {
		return (miAudio.isMuted());
	}
	
	/**
	 * Consulta la cantidad de fantasmas comidos actualmente.
	 * @return cantidad de fanstamas comidos de la partida actual.
	 */
	public int getCantidadFantasmasComidos() {
		return cantidadFantasmasComidos;
	}

	/**
	 * Consulta las vidas actuales disponibles en la partida.
	 * @return cantidad de vidas restantes.
	 */
	public int getVidasActuales() {
		return vidasActuales;
	}
	
}
