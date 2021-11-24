package factories;

import elementos.Elemento;
import elementos.Pocion;
import personajes.Enemigo;
import personajes.Principal;

/**
 * Interfaz para un factory design-pattern, encapsula
 * el comportamiento de la creacion de entidades para el juego.
 * @author Grupo 2 TDP. 2021
 */
public interface FabricaEntidades {
	
	/**
	 * @return Devuelve un nuevo personaje principal
	 */
	public abstract Principal getPrincipal();
	
	/**
	 * @return Devuelve un nuevo enemigo de tipo Blinky.
	 */
	public abstract Enemigo getBlinky();
	
	/**
	 * @return Devuelve un nuevo enemigo de tipo Pinky.
	 */
	public abstract Enemigo getPinky();
	
	/**
	 * @return Devuelve un nuevo enemigo de tipo Inky.
	 */
	public abstract Enemigo getInky();
	
	/**
	 * @return Devuelve un nuevo enemigo de tipo Clyde.
	 */
	public abstract Enemigo getClyde();
	
	/**
	 * @return Devuelve una nueva fruta.
	 */
	public abstract Elemento getFruta();
	
	/**
	 * @return Devuelve un nuevo PacDot.
	 */
	public abstract Elemento getPacDot();
	
	/**
	 * @return Devuelve una nueva pocion de tipo Bomba.
	 */
	public abstract Pocion getPocionBomba();
	
	/**
	 * @return Devuelve una nueva pocion de tipo Velocidad.
	 */
	public abstract Pocion getPocionVelocidad();
	
	/**
	 * @return Devuelve un nuevo power pellet.
	 */
	public abstract Elemento getPowerPellet();
}
