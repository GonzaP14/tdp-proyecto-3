package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Blinky extends Enemigo {
	
	private static final Posicion miSpawn = new Posicion(350, 575);
	
	public Blinky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego; 
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());  // Definir: Proximamente.
		miRepresentacion = new EnemigoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
	}
	
}
