package personajes;

import entidadesLogicas.Posicion;

public interface EstadoEnemigo {
	
	public Posicion siguientePosicion();
	
	public void setEnemigo (Enemigo e);
	
	public void setPosicionObjetivo(Posicion posicionObjetivo);
	
	public void setPrincipal(Principal p);
	
}
