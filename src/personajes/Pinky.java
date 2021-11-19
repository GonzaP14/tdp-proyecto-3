package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

public class Pinky extends Enemigo {
	
	private static final Posicion miSpawn = new Posicion(25, 25);
	
	public Pinky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miPosicion = miSpawn;
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		crearEstados();
		indiceEstado = Chase;
		estadoActual = estados[indiceEstado];
		velocidadActual=miJuego.getNivel().getVelocidadEnemigos();
		crearHilo(this);
	}

	@Override
	protected EstadoEnemigo crearEstadoChase() {
		EstadoEnemigo chase = new Chase(new ChasePinky());
		chase.setEnemigo(this);
		chase.setPrincipal(miJuego.getMiPersonajePrincipal());
		
		return chase;
	}
	
	@Override
	protected void reaparecer() {
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		this.miRepresentacion.aparecer(miPosicion);
		cambiarEstado(Chase);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
	}
	
	@Override
	protected EstadoEnemigo crearEstadoEaten() {
		EstadoEnemigo eaten = new Eaten();
		eaten.setEnemigo(this);
		eaten.setPosicionObjetivo(miSpawn);
		
		return eaten;
	}


	public Posicion getSpawn() {
		return miSpawn;
	}
	
}
