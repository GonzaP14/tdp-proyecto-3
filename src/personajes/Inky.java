package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

public class Inky extends Enemigo {
	
	private static final Posicion posicionScatter = new Posicion(700  , 800);

	public Inky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miSpawn = new Posicion(275, 275);
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
		EstadoEnemigo chase = new Chase(new ChaseInky(miJuego.getMisEnemigos().get(0)));
		chase.setEnemigo(this);
		chase.setPrincipal(miJuego.getMiPersonajePrincipal());
		
		return chase;
	}

	@Override
	public Posicion getPosicionScatter() {
		return posicionScatter;
	}
}
