package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Clyde extends Enemigo {
	
	private EnemigoGrafico miRepresentacionGrafica;

	public Clyde(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miPosicion = new Posicion(0,0); // Definir: Proximamente.
		miRepresentacionGrafica = new EnemigoGrafico(imagenes);
		miRepresentacionGrafica.aparecer(miPosicion);
	}
}
