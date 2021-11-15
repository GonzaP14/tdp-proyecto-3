package personajes;

import entidadesLogicas.Posicion;

public class Frightened implements EstadoEnemigo {
	
	Enemigo miEnemigo;
	Posicion posicionPrincipal;
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		double distanciaMaxima = toReturn.distanciaEntrePosicionesPitagoras(posicionPrincipal);
		double distanciaActual;
		
		for (Posicion pos: miEnemigo.posicionesDestino()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionPrincipal);
			
			if (distanciaActual > distanciaMaxima) {
				distanciaMaxima = distanciaActual;
				toReturn = pos;
			}
		}
		
		return toReturn;		
	}

	@Override
	public void setEnemigo(Enemigo e) {
		miEnemigo = e;
	}

	@Override
	public void setPosicionObjetivo(Posicion posicionObjetivo) {
		this.posicionPrincipal = posicionObjetivo;
	}

	@Override
	public void setPrincipal(Principal p) {
		// TODO Auto-generated method stub
		
	}

}
