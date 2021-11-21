package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Clyde extends Enemigo {
	private static final Posicion posicionScatter = new Posicion(25 , 750);

	public Clyde(Juego miJuego, String[] imagenes) {
		super.crearEnemigo(miJuego, new Posicion(400, 275), imagenes);
	}

	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseClyde();
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}
}
