package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Posicion;

public class Inky extends Enemigo {
	private EnemigoGrafico miRepresentacionGrafica;
	public Inky(EnemigoGrafico miRepresentacionGrafica) {
		this.miRepresentacionGrafica = miRepresentacionGrafica;
		miSpawn = new Posicion(250,250);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
	}
}
