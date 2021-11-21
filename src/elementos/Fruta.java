package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

public class Fruta extends Elemento {
	public Fruta(Juego miJuego, String[] imagenes) {
		puntajeOtorgado = 100;
		miRepresentacion = new ElementoGrafico(imagenes);
		this.miJuego = miJuego;
		miSpawn = new Posicion(350, 425);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
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
