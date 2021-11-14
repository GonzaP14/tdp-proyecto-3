package personajes;

import entidadesLogicas.Posicion;

public interface EstadoEnemigo {
	
	public Posicion siguientePosicion();
	
	public void setPosicionEnemigo(Posicion posicionEnemigo);
	
	public void setPosicionObjetivo(Posicion posicionObjetivo);
	
}
