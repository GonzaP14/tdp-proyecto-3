package personajes;

import entidadesLogicas.Posicion;

public class Eaten implements EstadoEnemigo {
	
	private Enemigo miEnemigo;
	private Posicion posicionRecuperacion;
	
	public Eaten (Enemigo miEnemigo , Posicion posicionRecuperacion) {
		this.miEnemigo = miEnemigo;
		this.posicionRecuperacion = posicionRecuperacion;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		if(toReturn.equals(miEnemigo.getSpawn())) {
			miEnemigo.cambiarEstado(Enemigo.Chase);
		}
		double distanciaMinima = Double.MAX_VALUE;
		double distanciaActual;
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionRecuperacion);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
		}
		
		return toReturn;
	}
}
