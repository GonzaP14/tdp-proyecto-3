package productos;

import elementos.Elemento;
import elementos.Fruta;
import elementos.PacDot;
import elementos.Pocion;
import elementos.PocionBomba;
import elementos.PocionVelocidad;
import elementos.PowerPellet;
import entidadesLogicas.DominioJuego;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import personajes.Blinky;
import personajes.Clyde;
import personajes.Enemigo;
import personajes.Inky;
import personajes.Pinky;
import personajes.Principal;

public class FabricaGeneral implements FabricaEntidades {
	
	Juego miJuego;
	DominioJuego miDominio;
	
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
    public Elemento getPacDot(Posicion posicion) {
        return new PacDot(miJuego, miDominio.getPacDot(), posicion);
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

	@Override
    public Elemento getPowerPellet(Posicion posicion) {
        return new PowerPellet(miJuego, miDominio.getPowerPellet(), posicion);
    }
	
}
