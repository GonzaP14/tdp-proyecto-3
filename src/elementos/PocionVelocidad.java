package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PocionVelocidad extends Pocion {

	public PocionVelocidad(Juego miJuego, String imagen) {
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
