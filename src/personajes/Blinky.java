package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Blinky extends Enemigo {
	private static final Posicion posicionScatter = new Posicion(675 , -75);
	
	public Blinky(Juego miJuego, String[] imagenes) {
		velocidadPredeterminada = miJuego.getNivel().getVelocidadEnemigos();
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, new Posicion(350, 275), imagenes);
	}
	
	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseBlinky();
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}
}
