package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Pinky extends Enemigo {
	
	private static final Posicion miSpawn = new Posicion(350, 325);
	
	public Pinky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miPosicion = miSpawn;
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
		crearEstados();
	}

	@Override
	protected EstadoEnemigo crearEstadoChase() {
		EstadoEnemigo chase = new Chase(new ChasePinky());
		chase.setEnemigo(this);
		chase.setPosicionObjetivo(miJuego.getMiPersonajePrincipal().getPosicion());
		
		return chase;
	}
	
}
