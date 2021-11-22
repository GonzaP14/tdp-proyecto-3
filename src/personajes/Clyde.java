package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Clyde extends Enemigo {
	private static final Posicion posicionScatter = new Posicion(25 , 750);
	private static final Posicion spawnClyde = new Posicion(400, 275);
	public Clyde(Juego miJuego, String[] imagenes) {
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, spawnClyde, imagenes);
	}

	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseClyde(this, miJuego.getPrincipal());
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}
}
