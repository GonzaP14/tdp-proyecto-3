package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Pinky extends Enemigo {
	
	private EnemigoGrafico miRepresentacionGrafica;
	
	public Pinky(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miPosicion = new Posicion(400,400); // Definir: Proximamente.
		miRepresentacionGrafica = new EnemigoGrafico(imagenes);
		this.miRepresentacionGrafica.aparecer(miPosicion);
	}
	
}
