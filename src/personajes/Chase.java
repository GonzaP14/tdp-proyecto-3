package personajes;

import entidadesLogicas.Posicion;

/**
 * Class Chase - Representa el estado 'Chase' de un enemigo.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Chase implements EstadoEnemigo {
	
	protected ChaseIA miInteligencia;
	protected Enemigo miEnemigo;
	protected Principal miPrincipal;
	
	/**
	 * Crea un nuevo estado Chase.
	 * @param miInteligencia IA asociada al estado.
	 * @param miEnemigo Enemigo asociado. 
	 * @param miPrincipal Personaje principal del juego.
	 */
	public Chase(ChaseIA miInteligencia, Enemigo miEnemigo, Principal miPrincipal) {
		this.miInteligencia = miInteligencia;
		this.miEnemigo = miEnemigo;
		this.miPrincipal = miPrincipal;
	}
	
	@Override
	public Posicion siguientePosicion() {
		return miInteligencia.siguientePosicion();
	}
	
}
