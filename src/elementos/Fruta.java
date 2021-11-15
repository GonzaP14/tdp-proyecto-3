package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class Fruta extends Elemento {
	private static final Posicion miSpawn = new Posicion(350, 425);//Debe ser abajo de la casa de los fantasmas
	
	public Fruta(Juego miJuego, String imagen) {
		puntajeOtorgado = 100;
		miRepresentacion = new ElementoGrafico(imagen);
		this.miJuego = miJuego;
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}

	@Override
	public void afectar() {
		miJuego.aumentarPuntaje(puntajeOtorgado);
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
		miRepresentacion.desaparecer();
	}
	
	@Override
	protected void iniciarTimer(HiloElemento timer) {
	}

	@Override
	public void operacionEnHilo() {

	}
	
	public void despawnear() {
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
		miRepresentacion.desaparecer();
	}

	public static Posicion getMispawn() {
		return miSpawn;
	}
	
}
