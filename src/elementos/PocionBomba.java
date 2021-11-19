package elementos;

import java.util.ArrayList;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Bloque;
import entidadesLogicas.Entidad;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;

public class PocionBomba extends Pocion {
	private static final Posicion miSpawn = new Posicion(325, 425);//Debe ser abajo de la casa de los fantasmas
	
	public PocionBomba(Juego miJuego, String imagenes[]) {
		this.miJuego = miJuego;
		miPosicion = new Posicion((int) miSpawn.getX(), (int) miSpawn.getY());
		miRepresentacion = new ElementoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		puntajeOtorgado = 400;
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
	}

	@Override
	public void afectar() {
		// Inicia la cuenta regresiva de la bomba
		iniciarTimer(new HiloElemento(miJuego, 25, this)); // en 5 ticks explota
		// Cambia su representacion grafica adecuadamente
		miRepresentacion.setIcon(miJuego.getMiPersonajePrincipal().getMiRepresentacion().getIcon()); // foto bomba aca
		
		miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).borrarDeListaDeEntidades(this);
	}

	@Override
	public void finPocion() {
		ArrayList<Bloque> bloquesEnRadio = new ArrayList<Bloque>();
		
		// Se arma un radio de 4x4 a partir de la posicion de la bomba (no incluye la posicion de la bomba misma)
		for (int i = 1; i < 5; i++) {
			bloquesEnRadio.add(miJuego.getGrilla().getBloque(miPosicion.getY() / 25 + i, miPosicion.getX() / 25));
			bloquesEnRadio.add(miJuego.getGrilla().getBloque(miPosicion.getY() / 25 - i, miPosicion.getX() / 25));
			bloquesEnRadio.add(miJuego.getGrilla().getBloque(miPosicion.getY() / 25, miPosicion.getX() / 25 + i));
			bloquesEnRadio.add(miJuego.getGrilla().getBloque(miPosicion.getY() / 25, miPosicion.getX() / 25 - i));
		}
		
		// Para cada bloque alcanzado por la bomba, se afecta a las entidades en este
		for (Bloque bloqueAlcanzado : bloquesEnRadio) {
			for (Entidad entidad : bloqueAlcanzado.getListaEntidades()) {
				entidad.recibirEfecto(this);
				bloqueAlcanzado.agregarAListaRemovidos(entidad);
			}
			bloqueAlcanzado.getListaEntidades().removeAll(bloqueAlcanzado.getListaRemovidos());
			bloqueAlcanzado.limpiarListaRemovidos();
		}
		
		miRepresentacion.desaparecer();
	}

	public static Posicion getMispawn() {
		return miSpawn;
	}
	
	
}
