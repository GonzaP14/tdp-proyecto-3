package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import personajes.Enemigo;

public class PowerPellet extends Elemento {
	private static final Posicion[] misSpawns = 
		{
			new Posicion(650,575), new Posicion(25,575), new Posicion(650,75), new Posicion(25,75)
		};
	public PowerPellet(Juego miJuego, String imagen , Posicion posicion) {
		this.miJuego = miJuego;
		miRepresentacion = new ElementoGrafico(imagen);
		puntajeOtorgado = 50;
		miPosicion = posicion;
		miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}

	@Override
	protected void iniciarTimer(HiloElemento timer) {
		
	}

	@Override
	public void afectar() {
		for(Enemigo e : miJuego.getMisEnemigos())
			e.recibirEfecto(this);
		miJuego.aumentarPuntaje(puntajeOtorgado);
		miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaRemovidos(this);
		miRepresentacion.desaparecer();	
	}
	
	public static Posicion[] getMisSpawns() {
		return misSpawns;
	}
}
