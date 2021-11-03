package personajes;

import entidadesGraficas.EnemigoGrafico;
import entidadesLogicas.Posicion;

public class Blinky extends Enemigo {
	private EnemigoGrafico miRepresentacionGrafica;
	
	public Blinky(EnemigoGrafico miRepresentacionGrafica) {
		this.miRepresentacionGrafica = miRepresentacionGrafica;
		miSpawn = new Posicion(300,300);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		this.miRepresentacionGrafica.aparecer(miPosicion);
	}
	
}
