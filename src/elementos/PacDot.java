package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PacDot extends Elemento {
	private static final Posicion[] misSpawns = 
	{
			new Posicion(400, 575), new Posicion(425, 575)
	};
	public PacDot(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miRepresentacion = new ElementoGrafico(imagen);
		puntajeOtorgado = 10;
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
