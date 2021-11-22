package personajes;

import entidadesLogicas.Posicion;

public class Frightened implements EstadoEnemigo {
	
	private Enemigo miEnemigo;
	private Principal miPrincipal;
	
	public Frightened (Enemigo miEnemigo , Principal miPrincipal) {
		this.miEnemigo = miEnemigo;
		this.miPrincipal = miPrincipal;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		double distanciaMaxima = Double.MIN_VALUE;
		double distanciaActual;
		
		/* Asumo que la distancia actual con el principal es la maxima posible.
		   Esto se realiza para no quedar que el enemigo e no quede en la misma posición, ya que cualquier
		   otra distancia sera menor con respecto a esta.
		*/ 
		
		for (Posicion pos: miEnemigo.posiblesPosiciones()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(miPrincipal.getPosicion());
			
			if (distanciaActual > distanciaMaxima) {
				distanciaMaxima = distanciaActual;
				toReturn = pos;
			}
		}
		return toReturn;		
	}

}
