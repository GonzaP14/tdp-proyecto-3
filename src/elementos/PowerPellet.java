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
	
	/*
	public PowerPellet(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miRepresentacion = new ElementoGrafico(imagenes);
		puntajeOtorgado = 50;
	}
	*/

	public PowerPellet(Juego miJuego, String[] imagenes, Posicion spawn) {
        this.miJuego = miJuego;
        miRepresentacion = new ElementoGrafico(imagenes);
        puntajeOtorgado = 50;
        miSpawn = spawn;
        miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
        miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
    }
		
	@Override
	protected void iniciarTimer(HiloElemento timer) {
		timer.start();
	}

	@Override
	public void afectar() {
		iniciarTimer(new HiloElemento(miJuego, miJuego.getNivel().getDuracionPowerPellet() , this) );
		for(Enemigo e : miJuego.getMisEnemigos())
			e.recibirEfecto(this);
		miJuego.aumentarPuntaje(puntajeOtorgado);
		miRepresentacion.desaparecer();	
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
	}
	
	public static Posicion[] getMisSpawns() {
		return misSpawns;
	}
	
	public void finPocion() {
		miJuego.setCantidadFantasmasComidos(0);
		for(Enemigo e : miJuego.getMisEnemigos()) {
			e.cambiarEstado(Enemigo.Chase);
		}
	}
}
