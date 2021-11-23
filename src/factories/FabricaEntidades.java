package factories;

import elementos.Elemento;
import elementos.Pocion;
import personajes.Enemigo;
import personajes.Principal;

public interface FabricaEntidades {
	
	public abstract Principal getPrincipal();
	
	public abstract Enemigo getBlinky();
	
	public abstract Enemigo getPinky();
	
	public abstract Enemigo getInky();
	
	public abstract Enemigo getClyde();
	
	public abstract Elemento getFruta();
	
	public abstract Elemento getPacDot();
	
	public abstract Pocion getPocionBomba();
	
	public abstract Pocion getPocionVelocidad();
	
	public abstract Elemento getPowerPellet();
	
}
