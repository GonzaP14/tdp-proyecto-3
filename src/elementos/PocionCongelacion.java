package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PocionCongelacion extends Pocion {

	public PocionCongelacion(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miPosicion = new Posicion(0,0);
		miRepresentacion = new ElementoGrafico(imagen);
		miRepresentacion.aparecer(miPosicion);
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
	
}
