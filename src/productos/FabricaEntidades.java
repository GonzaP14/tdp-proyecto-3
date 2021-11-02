package productos;

import elementos.Elemento;
import personajes.Enemigo;
import personajes.Principal;

public abstract class FabricaEntidades {
	public abstract Elemento getFruta();
	
	public abstract Elemento getPocion();
	
	public abstract Elemento getPowerPellet();
	
	public abstract Elemento getPacDot();
	
	public abstract Principal getPrincipal();
	
	public abstract Enemigo getBlinky();
	
	public abstract Enemigo getPinky();
	
	public abstract Enemigo getInky();
	
	public abstract Enemigo getClyde();
}
