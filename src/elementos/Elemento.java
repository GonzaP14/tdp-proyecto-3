package elementos;

import entidadesLogicas.Entidad;

public abstract class Elemento extends Entidad {
	protected int puntaje;
	
	public abstract void iniciarTimer(HiloElemento timer);
 	
}
