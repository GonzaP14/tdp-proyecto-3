package personajes;

import entidadesLogicas.Posicion;

public abstract class ChaseIA {
	
	public abstract Posicion calcularSiguientePosicion(Posicion posicionEnemigo, Posicion posicionPrincipal);
	
}
