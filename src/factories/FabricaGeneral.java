package factories;

import dominios.DominioJuego;
import elementos.Elemento;
import elementos.Fruta;
import elementos.PacDot;
import elementos.Pocion;
import elementos.PocionBomba;
import elementos.PocionVelocidad;
import elementos.PowerPellet;
import entidadesLogicas.Juego;
import personajes.Blinky;
import personajes.Clyde;
import personajes.Enemigo;
import personajes.Inky;
import personajes.Pinky;
import personajes.Principal;

public class FabricaGeneral implements FabricaEntidades {
	
	// Atributos de instancia
	private Juego miJuego;
	private DominioJuego miDominio;
	
	/**
	 * Crea una fabrica general para el juego, para un determinado dominio.
	 * @param miJuego ligado a la fabrica
	 * @param miDominio dominio determinado.
	 */
	public FabricaGeneral(Juego miJuego, DominioJuego miDominio) {
		this.miJuego = miJuego;
		this.miDominio = miDominio;
	}
	
	@Override
	public Principal getPrincipal() {
		return Principal.getPrincipal(miJuego, miDominio.getSkinsPrincipal());
	}

	@Override
	public Enemigo getBlinky() {
		return new Blinky(miJuego, miDominio.getSkinsBlinky());
	}

	@Override
	public Enemigo getPinky() {
		return new Pinky(miJuego, miDominio.getSkinsPinky());
	}

	@Override
	public Enemigo getInky() {
		return new Inky(miJuego, miDominio.getSkinsInky());
	}

	@Override
	public Enemigo getClyde() {
		return new Clyde(miJuego, miDominio.getSkinsClyde());
	}

	@Override
	public Elemento getFruta() {
		return new Fruta(miJuego, miDominio.getFruta());
	}
	
	@Override
	public Elemento getPacDot() {
		return new PacDot(miJuego, miDominio.getPacDot());
	}
	
	@Override
	public Pocion getPocionBomba() {
		return new PocionBomba(miJuego, miDominio.getPocionBomba());
	}

	@Override
	public Pocion getPocionVelocidad() {
		return new PocionVelocidad(miJuego, miDominio.getPocionVelocidad());
	}
	
	@Override
	public Elemento getPowerPellet() {
		return new PowerPellet(miJuego, miDominio.getPowerPellet());
	}
}
