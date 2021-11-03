package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Posicion;

public class Pinky extends Enemigo {
	private EnemigoGrafico miRepresentacionGrafica;
	
	public Pinky(EnemigoGrafico miRepresentacionGrafica) {
		this.miRepresentacionGrafica = miRepresentacionGrafica;
		miSpawn = new Posicion(400,400);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		this.miRepresentacionGrafica.aparecer(miPosicion);
	}
}
