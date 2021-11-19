package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Blinky extends Enemigo {
	
	private static final Posicion miSpawn = new Posicion(350, 275);
	
	public Blinky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego; 
		miPosicion = miSpawn;
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
		crearEstados();
		indiceEstado = Chase;
		estadoActual = estados[indiceEstado];
		velocidadActual=miJuego.getNivel().getVelocidadEnemigos();
		crearHilo(this);
	}

	@Override
	protected EstadoEnemigo crearEstadoChase() {
		EstadoEnemigo chase = new Chase(new ChaseBlinky());
		chase.setEnemigo(this);
		chase.setPrincipal(miJuego.getMiPersonajePrincipal());
		
		return chase;
	}

	@Override
	protected void reaparecer() {
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		this.miRepresentacion.aparecer(miPosicion);
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
		cambiarEstado(Chase);
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}

	@Override
	protected EstadoEnemigo crearEstadoEaten() {
		EstadoEnemigo eaten = new Eaten();
		eaten.setEnemigo(this);
		eaten.setPosicionObjetivo(miSpawn);
		
		return eaten;
	}

	@Override
	public Posicion getSpawn() {
		return miSpawn;
	}
	
}
