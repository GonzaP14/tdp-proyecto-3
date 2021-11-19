package personajes;

import entidadesLogicas.Posicion;

public abstract class ChaseIA {
	
	public abstract Posicion calcularSiguientePosicion(Enemigo miEnemigo, Principal principal);
	
}
