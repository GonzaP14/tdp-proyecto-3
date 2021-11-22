package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Juego;
import gui.Ventana;

public class PocionVelocidad extends Pocion {
	
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
		miJuego.getMiReloj().setVelocidadTickeo(100);
	}
}
