package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Inky extends Enemigo {
	private static final Posicion posicionScatter = new Posicion(700  , 800);

	public Inky(Juego miJuego, String[] imagenes) {
		super.crearEnemigo(miJuego, new Posicion(350, 275), imagenes);
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}

	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseInky(miJuego.getMisEnemigos().get(0));
	}
}
