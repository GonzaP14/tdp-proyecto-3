package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import gui.Ventana;

public class Fruta extends Elemento {
	public Fruta(Juego miJuego, String[] imagenes) {
		puntajeOtorgado = 100;
		miRepresentacion = new ElementoGrafico(imagenes);
		this.miJuego = miJuego;
	}

	@Override
	public void afectar() {
		miJuego.aumentarPuntaje(puntajeOtorgado);
		miRepresentacion.desaparecer();
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
	}
	
	@Override
	protected void iniciarTimer(HiloElemento timer) {
	}

	@Override
	public void finPocion() {

	}
}
