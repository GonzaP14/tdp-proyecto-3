package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Pinky extends Enemigo {
	private static final Posicion posicionScatter = new Posicion(25 , -75);

	public Pinky(Juego miJuego, String[] imagenes) {
		super.crearEnemigo(miJuego, new Posicion(25, 25), imagenes);
	}


	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}


	@Override
	public ChaseIA crearChaseIA() {
		return new ChasePinky();
	}
	
}
