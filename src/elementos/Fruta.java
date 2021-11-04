package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Fruta extends Elemento {
	private static final Posicion miSpawn = new Posicion(350, 425);//Debe ser abajo de la casa de los fantasmas
	
	public Fruta(Juego miJuego, String imagen, HiloElemento timer) {
		miRepresentacion = new ElementoGrafico(imagen);
		this.miJuego = miJuego;
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miRepresentacion.aparecer(miPosicion);
		iniciarTimer(timer);
	}

	@Override
	public void afectar() {
		
	}
	
	@Override
	public void iniciarTimer(HiloElemento timer) {
		timer.start();
	}
}
