package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PowerPellet extends Elemento {
	
	public PowerPellet(Juego miJuego, String imagen) {
		this.miJuego = miJuego;
		miPosicion = new Posicion(0,0);
		miRepresentacionGrafica = new ElementoGrafico(imagen);
		miRepresentacionGrafica.aparecer(miPosicion);
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
