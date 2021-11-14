package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Pinky extends Enemigo {
	
	private static final Posicion miSpawn = new Posicion(350, 575);
	
	public Pinky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY()); // Definir: Proximamente.
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}
	
}
