package elementos;

import java.util.ArrayList;
import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Bloque;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class PocionBomba - Representa un tipo de poci�n del juego.
 * @author Grupo N�2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public class PocionBomba extends Pocion {
	
	private static final Posicion miSpawn = new Posicion(325, 425);
	
	/**
	 * Crea una nueva PocionBomba.
	 * @param miJuego Juego asociado.
	 * @param imagenes Skins de la Bomba.
	 */
	public PocionBomba(Juego miJuego, String imagenes[]) {
		puntajeOtorgado = 400;
		miRepresentacion = new ElementoGrafico(imagenes);
		this.miJuego = miJuego;
	}

	@Override
	public void afectar() {
		// Inicia la cuenta regresiva de la bomba
		iniciarTimer(new HiloElemento(miJuego, 25, this)); // en 5 ticks explota
		// Cambia su representacion grafica adecuadamente
		miRepresentacion.actualizar(1);
		miJuego.getPrincipal().recibirEfecto(this);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
	}

	@Override
	public void finPocion() {
		ArrayList<Bloque> bloquesEnRadio = new ArrayList<Bloque>();
		
		// Se arma un radio de 4x4 a partir de la posicion de la bomba (no incluye la posicion de la bomba misma)
		for (int i = 0; i < 5; i++) {
			bloquesEnRadio.add(miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque + i, miPosicion.getX() / Ventana.pixelesBloque));
			bloquesEnRadio.add(miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque - i, miPosicion.getX() / Ventana.pixelesBloque));
			bloquesEnRadio.add(miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque + i));
			bloquesEnRadio.add(miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque - i));
		}
		
		// Para cada bloque alcanzado por la bomba, se afecta a las entidades en este
		for (Bloque bloqueAlcanzado : bloquesEnRadio) {
			for (Entidad entidad : bloqueAlcanzado.getListaEntidades()) {
				entidad.recibirEfecto(this);
			}
		}
		miRepresentacion.desaparecer();
		miJuego.getPrincipal().getMiRepresentacion().finEfectoPocion(sentidoActual + 1);
	}
	
	@Override
	public void reset() {
		setSpawneo(miSpawn);
		getMiRepresentacion().crearGrafica(getSpawn());
		miJuego.getVentana().aparecerEntidad(getMiRepresentacion());
	}
}
