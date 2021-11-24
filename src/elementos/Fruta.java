package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class Fruta - Representa una fruta del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class Fruta extends Elemento {

	private static final Posicion miSpawn = new Posicion(350, 425);
	
	public Fruta(Juego miJuego, String[] imagenes) {
		puntajeOtorgado = 100;
		miRepresentacion = new ElementoGrafico(imagenes);
		this.miJuego = miJuego;
	}

	@Override
	public void afectar() {
		miJuego.aumentarPuntaje(puntajeOtorgado * miJuego.getNivel().getNivelActual());
		miRepresentacion.desaparecer();
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
	}
	
	@Override
	protected void iniciarTimer(HiloElemento timer) {}

	@Override
	public void finPocion() {}
	
	@Override
	public void reset() {
		setSpawneo(miSpawn);
		getMiRepresentacion().crearGrafica(getSpawn());
		miRepresentacion.actualizar(miJuego.getNivel().getNivelActual() - 1);
		miJuego.getVentana().aparecerEntidad(getMiRepresentacion());
	}
	
}
