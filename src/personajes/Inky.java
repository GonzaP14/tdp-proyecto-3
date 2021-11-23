package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

/**
 * Class Inky - Representa el Enemigo Inky del Juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Inky extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(700, 800);
	private static final Posicion spawnInky = new Posicion(350, 275);
	
	/**
	 * Crea un nuevo Inky.
	 * @param miJuego Juego asociado a Inky.
	 * @param imagenes Skins de Inky.
	 */
	public Inky(Juego miJuego, String[] imagenes) {
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, spawnInky, imagenes);
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}

	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseInky(this, miJuego.getPrincipal(), miJuego.getEnemigos().get(0));
	}
	
	/**
	 * Setea la velocidad predeterminada del movimiento de Inky.
	 */
	public void setVelocidadPredeterminada(int velocidad) {
		velocidadPredeterminada = velocidad - 8;
	}
	
}
