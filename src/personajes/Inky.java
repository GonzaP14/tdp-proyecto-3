package personajes;

import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Inky extends Enemigo {
	private static final Posicion posicionScatter = new Posicion(700  , 800);

	public Inky(Juego miJuego, String[] imagenes) {
		setVelocidadPredeterminada(miJuego.getNivel().getVelocidadEnemigos());
		velocidadActual = velocidadPredeterminada;
		super.crearEnemigo(miJuego, new Posicion(350, 275), imagenes);
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}

	@Override
	public ChaseIA crearChaseIA() {
		return new ChaseInky(this, miJuego.getPrincipal(), miJuego.getEnemigos().get(0));
	}
	
	public void setVelocidadPredeterminada(int velocidad) {
		velocidadPredeterminada = velocidad - 8;
	}
}
