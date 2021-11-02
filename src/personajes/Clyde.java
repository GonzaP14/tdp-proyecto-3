package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Posicion;

public class Clyde extends Enemigo {
	private EnemigoGrafico miRepresentacionGrafica;
	public Clyde(EnemigoGrafico miRepresentacionGrafica) {
		this.miRepresentacionGrafica = miRepresentacionGrafica;
		miSpawn = new Posicion(350,350);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
	}
}
