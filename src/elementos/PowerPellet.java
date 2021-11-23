package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;
import personajes.Enemigo;

public class PowerPellet extends Elemento {
	private static final Posicion[] misSpawns = 
		{
			new Posicion(650,575), new Posicion(25,575), new Posicion(650,75), new Posicion(25,75)
		};
	
	public static final int cantidadPowerPellets = misSpawns.length;
	
	public PowerPellet(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miRepresentacion = new ElementoGrafico(imagenes);
		puntajeOtorgado = 50;
	}

	public PowerPellet(Juego miJuego, String[] imagenes, Posicion spawn) {
        this.miJuego = miJuego;
        miRepresentacion = new ElementoGrafico(imagenes);
        puntajeOtorgado = 50;
        setSpawneo(spawn);
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
	/**
	 * Devuelve los posibles spawns de los powerPellet
	 * @return los posibles spawns
	 */
	public static Posicion[] getMisSpawns() {
		return misSpawns;
	}
	
	public void finPocion() {
		miJuego.setCantidadFantasmasComidos(0);
		for(Enemigo e : miJuego.getEnemigos()) {
			if(e.getIndiceEstado() == Enemigo.Frightened) {
				e.cambiarEstado(Enemigo.Chase);
				e.setVelocidadActual(e.getVelocidadPredeterminada());
			}
		}
	}
	
}
