package personajes;

import entidadesLogicas.Posicion;

public class Eaten implements EstadoEnemigo {
	
	private Enemigo miEnemigo;
	private Posicion posicionRecuperacion;
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
		double distanciaMinima = toReturn.distanciaEntrePosicionesPitagoras(posicionRecuperacion);
		double distanciaActual;
		
		for (Posicion pos: miEnemigo.posicionesDestino()) {
			distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionRecuperacion);
			
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
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
		this.posicionRecuperacion = posicionObjetivo;
	}

	@Override
	public void setPrincipal(Principal p) {
		// TODO Auto-generated method stub
		
	}


}
