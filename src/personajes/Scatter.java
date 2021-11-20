package personajes;

import entidadesLogicas.Posicion;

public class Scatter implements EstadoEnemigo {
	private Enemigo miEnemigo;
	private Posicion posicionObjetivo;
	public Scatter (Enemigo miEnemigo , Posicion posicionObjetivo) {
		this.miEnemigo = miEnemigo;
		this.posicionObjetivo = posicionObjetivo;
	}
	
	@Override
	public Posicion siguientePosicion() {
		Posicion toReturn = miEnemigo.getPosicion();
        double distanciaMinima = Double.MAX_VALUE; 
        double distanciaActual;

        for (Posicion pos: miEnemigo.posicionesDestino()) { //Direcciones de cada fantasma
            distanciaActual = pos.distanciaEntrePosicionesPitagoras(posicionObjetivo);

            if (distanciaActual < distanciaMinima) {
                distanciaMinima = distanciaActual;
                toReturn = pos;
            }

        }

        return toReturn;
	}

	@Override
	public void setEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosicionObjetivo(Posicion posicionObjetivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPrincipal(Principal p) {
		// TODO Auto-generated method stub
		
	}
	
}
