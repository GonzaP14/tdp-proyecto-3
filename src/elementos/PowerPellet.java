package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PowerPellet extends Elemento {
	private static final Posicion[] misSpawns = 
		{
				new Posicion(650,725), new Posicion(25,725), new Posicion(650,25), new Posicion(25,25)
		};
	public PowerPellet(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miRepresentacion = new ElementoGrafico(imagen);
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
	
	public static Posicion[] getMisSpawns() {
		return misSpawns;
	}
}
