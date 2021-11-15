package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Blinky extends Enemigo {
	
	private static final Posicion miSpawn = new Posicion(350, 275);
	
	public Blinky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego; 
		miPosicion = miSpawn;
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
		crearEstados();
		indiceEstado = Chase;
		estadoActual = estados[indiceEstado];
		crearHilo(this);
	}

	@Override
	protected EstadoEnemigo crearEstadoChase() {
		EstadoEnemigo chase = new Chase(new ChaseBlinky());
		chase.setEnemigo(this);
		chase.setPrincipal(miJuego.getMiPersonajePrincipal());
		
		return chase;
	}
	
}
