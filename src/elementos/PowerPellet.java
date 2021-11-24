package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;
import personajes.Enemigo;

/**
 * Class PowerPellet - Representa un PowerPellet del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class PowerPellet extends Elemento {
	
	private static final Posicion[] misSpawns = { new Posicion(650,575), new Posicion(25,575), new Posicion(650,75), new Posicion(25,75)};
	
	/**
	 * Crea un nuevo PowerPellet.
	 * @param miJuego Juego asociado.
	 * @param imagenes Skins del PowerPellet.
	 */
	public PowerPellet(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miRepresentacion = new ElementoGrafico(imagenes);
		puntajeOtorgado = 50;
	}
		
	@Override
	protected void iniciarTimer(HiloElemento timer) {
		timer.start();
	}

	@Override
	public void afectar() {
		iniciarTimer(new HiloElemento(miJuego, miJuego.getNivel().getDuracionPowerPellet() , this) );
		for(Enemigo e : miJuego.getEnemigos())
			e.recibirEfecto(this);
		miJuego.aumentarPuntaje(puntajeOtorgado);
		miRepresentacion.desaparecer();	
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
	}
	
	@Override
	public void finPocion() {
		miJuego.setCantidadFantasmasComidos(0);
		for(Enemigo e : miJuego.getEnemigos()) {
			if(e.getIndiceEstado() == Enemigo.Frightened) {
				e.cambiarEstado(Enemigo.Chase);
				e.setVelocidadActual(e.getVelocidadPredeterminada());
			}
		}
	}
	
	/**
	 * Devuelve los posibles spawns de los powerPellet
	 * @return los posibles spawns
	 */
	public static Posicion[] getMisSpawns() {
		return misSpawns;
	}
	
}
