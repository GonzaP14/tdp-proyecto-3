package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PowerPellet extends Elemento {
	
	public static final Posicion spawnIzquierdaAbajo = new Posicion(350,570);
	public static final Posicion spawnIzquierdaArriba = new Posicion(350,570);
	public static final Posicion spawnDerechaAbajo = new Posicion(350,570);
	public static final Posicion spawnDerechaArriba = new Posicion(350,570);
	
	public PowerPellet(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miRepresentacion = new ElementoGrafico(imagen);
		miRepresentacion.aparecer(miPosicion);
		puntajeOtorgado = 50;
	}

	@Override
	public void iniciarTimer(HiloElemento timer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectar() {
		// TODO Auto-generated method stub
		
	}
	
}
