package elementos;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;
import gui.Ventana;

public abstract class Elemento extends Entidad {
	protected int puntajeOtorgado;
	
	protected abstract void iniciarTimer(HiloElemento timer);
 	
	public abstract void finPocion();
	
	public void despawnear() {
		miRepresentacion.desaparecer();
	}
	
	public void setSpawneo(Posicion spawn) {
		miSpawn = spawn;
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
	}
	
	@Override
	public void reset() {
		miSpawn = getPosicion();
		miPosicion = new Posicion(miSpawn.getX(), miSpawn.getY());
		miRepresentacion.aparecer(miPosicion);
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
	}
	
	
}
