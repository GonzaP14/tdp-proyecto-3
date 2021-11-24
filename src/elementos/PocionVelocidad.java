package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class PocionVelociad - Representa un tipo de poción del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class PocionVelocidad extends Pocion {
	
	private static final Posicion miSpawn = new Posicion(375, 425);
	
	/**
	 * Crea una nueva PocionVelocidad.
	 * @param miJuego Juego asociado.
	 * @param imagenes Skins de la Pocion de velocidad.
	 */
	public PocionVelocidad(Juego miJuego, String[] imagenes) {
		velocidadOtorgada = 120;
		miRepresentacion = new ElementoGrafico(imagenes);
		this.miJuego = miJuego;
	}

	@Override
	public void afectar() {
		iniciarTimer(new HiloElemento(miJuego, miJuego.getNivel().getDuracionPociones() , this) );
		miJuego.getPrincipal().recibirEfecto(this);
		miRepresentacion.desaparecer();
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
	}

	@Override
	public void finPocion() {
		miJuego.getPrincipal().setVelocidadActual(100);
		miJuego.getReloj().setVelocidadTickeo(100);
		System.out.println(sentidoActual);
		miJuego.getPrincipal().getMiRepresentacion().finEfectoPocion(sentidoActual + 1);
	}
	
	@Override
	public void reset() {
		setSpawneo(miSpawn);
		getMiRepresentacion().crearGrafica(getSpawn());
		miJuego.getVentana().aparecerEntidad(getMiRepresentacion());
	}
}
