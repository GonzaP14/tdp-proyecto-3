package productos;

import elementos.Elemento;
import elementos.Pocion;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import personajes.Enemigo;
import personajes.Principal;

public abstract class FabricaEntidades {
	
	protected Juego miJuego;
	
	public abstract Principal getPrincipal();
	
	public abstract Enemigo getBlinky();
	
	public abstract Enemigo getPinky();
	
	public abstract Enemigo getInky();
	
	public abstract Enemigo getClyde();
	
	public abstract Elemento getFruta();
	
	public abstract Elemento getPacDot(Posicion posicion);
	
	public abstract Pocion getPocionCongelacion();
	
	public abstract Pocion getPocionVelocidad();
	
	public abstract Elemento getPowerPellet(Posicion posicion);

	public void setMiJuego(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
}
