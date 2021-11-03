package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Pinky extends Enemigo {
	
	private EnemigoGrafico miRepresentacionGrafica;
	private static final Posicion miSpawn = new Posicion(350, 575);
	
	public Pinky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY()); // Definir: Proximamente.
		miRepresentacionGrafica = new EnemigoGrafico(imagenes);
		this.miRepresentacionGrafica.aparecer(miPosicion);
	}
	
}
