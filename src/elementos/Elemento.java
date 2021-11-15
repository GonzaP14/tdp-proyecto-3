package elementos;

import entidadesLogicas.Entidad;

public abstract class Elemento extends Entidad {
	protected int puntajeOtorgado;
	
	protected abstract void iniciarTimer(HiloElemento timer);
 	
}
