package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import entidadesLogicas.Posicion;
import gui.Ventana;

public class PocionVelocidad extends Pocion {
	
	public PocionVelocidad(Juego miJuego, String[] imagenes) {
		this.miJuego = miJuego;
		miSpawn = new Posicion(375, 425);
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miRepresentacion = new ElementoGrafico(imagenes);
		miRepresentacion.aparecer(miPosicion);
		velocidadOtorgada = 12;
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
	}

	@Override
	public void afectar() {
		iniciarTimer(new HiloElemento(miJuego, miJuego.getNivel().getDuracionPociones() , this) );
		miJuego.getMiPersonajePrincipal().recibirEfecto(this);
		miRepresentacion.desaparecer();
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
	}

	@Override
	public void finPocion() {
		miJuego.getMiPersonajePrincipal().setVelocidadActual(10);
		miJuego.getMiReloj().setVelocidadTickeo(10);
	}
}
