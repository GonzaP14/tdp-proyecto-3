package personajes;

import entidadesLogicas.Posicion;

public class ChaseBlinky extends ChaseIA {
	
	private Enemigo miEnemigo;
	private Principal miPrincipal;
	
	public ChaseBlinky(Enemigo blinky, Principal principal) {
		miEnemigo = blinky;
		miPrincipal = principal;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		Posicion posicionPrincipal = miPrincipal.getPosicion();
		double distanciaMinima = Double.MAX_VALUE; 
		double distanciaActual;
		
		for (Posicion pos: miEnemigo.posicionesDestino()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionPrincipal);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
			
		}
		
		return toReturn;
	}

}
