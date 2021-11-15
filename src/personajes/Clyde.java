package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Clyde extends Enemigo {
	
	private static final Posicion miSpawn = new Posicion(400, 325);

	public Clyde(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miPosicion = miSpawn;
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
		crearEstados();
	}

	@Override
	protected EstadoEnemigo crearEstadoChase() {
		EstadoEnemigo chase = new Chase(new ChaseClyde());
		chase.setEnemigo(this);
		chase.setPosicionObjetivo(miJuego.getMiPersonajePrincipal().getPosicion());
		
		return chase;
	}
	
	@Override
	protected void reaparecer() {
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		this.miRepresentacion.aparecer(miPosicion);
		sentidoActual = Entidad.sentidoFijo;
		sentidoSiguiente = Entidad.sentidoFijo;
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}
}
