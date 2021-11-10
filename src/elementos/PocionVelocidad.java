package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PocionVelocidad extends Pocion {
	private static final Posicion miSpawn = new Posicion(350, 575);
	
	public PocionVelocidad(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		miRepresentacion = new ElementoGrafico(imagen);
		miRepresentacion.aparecer(miPosicion);
		velocidadOtorgada = 2;
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
	
}
