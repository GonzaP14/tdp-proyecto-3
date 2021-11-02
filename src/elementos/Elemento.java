package elementos;

import entidadesGraficas.ElementoGrafico;
import entidadesLogicas.Entidad;

public abstract class Elemento extends Entidad {
	
	protected ElementoGrafico miRepresentacionGrafica;
	protected int puntaje;
	
	public abstract void iniciarTimer(HiloElemento timer);
 	
}
