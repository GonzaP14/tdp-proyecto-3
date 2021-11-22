package personajes;

import entidadesLogicas.Posicion;

public class ChaseInky extends ChaseIA {
		
	private Enemigo miEnemigo, miBlinky;
	private Principal miPrincipal;
	
	public ChaseInky(Enemigo inky, Principal principal, Enemigo blinky) {
		miEnemigo = inky;
		miPrincipal = principal;
		miBlinky = blinky;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		Posicion posicionPrincipal = miPrincipal.getPosicion();
		Posicion posBlinky = miBlinky.getPosicion();
		Posicion destino =new Posicion(2*(posicionPrincipal.getX())-posBlinky.getX(),2*(posicionPrincipal.getY())-posBlinky.getY());
		double distanciaMinima = Double.MAX_VALUE; 
		double distanciaActual;
		
		for (Posicion pos: miEnemigo.posicionesDestino()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(destino);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
				toReturn = pos;
			}
			
		}
		
		return toReturn;
	}

}
