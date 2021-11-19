package elementos;

import entidadesLogicas.Entidad;
import gui.Ventana;

public abstract class Elemento extends Entidad {
	protected int puntajeOtorgado;
	
	protected abstract void iniciarTimer(HiloElemento timer);
 	
	public abstract void finPocion();
	
	public void despawnear() {
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaRemovidos(this);
		miRepresentacion.desaparecer();
	}
}
