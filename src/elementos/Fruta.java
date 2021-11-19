package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

public class Fruta extends Elemento {
	private static final Posicion miSpawn = new Posicion(350, 425);//Debe ser abajo de la casa de los fantasmas
	
	public Fruta(Juego miJuego, String[] imagenes) {
		puntajeOtorgado = 100;
		miRepresentacion = new ElementoGrafico(imagenes);
		this.miJuego = miJuego;
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
	}

	@Override
	public void afectar() {
		miJuego.aumentarPuntaje(puntajeOtorgado);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
		miRepresentacion.desaparecer();
	}
	
	@Override
	protected void iniciarTimer(HiloElemento timer) {
	}

	@Override
	public void finPocion() {

	}

	public static Posicion getMispawn() {
		return miSpawn;
	}
	
}
