package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

public class Clyde extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(25 , 750);

	public Clyde(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miSpawn = new Posicion(400, 275);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		crearEstados();
		indiceEstado = Scatter;
		estadoActual = estados[indiceEstado];
		velocidadActual=miJuego.getNivel().getVelocidadEnemigos();
		crearHilo(this);
	}

	@Override
	protected EstadoEnemigo crearEstadoChase() {
		EstadoEnemigo chase = new Chase(new ChaseClyde());
		chase.setEnemigo(this);
		chase.setPrincipal(miJuego.getMiPersonajePrincipal());
		return chase;
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}
}
