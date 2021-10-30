package entidadesLogicas;

import java.util.ArrayList;
import entidadesGraficas.BloqueGrafico;

public class Bloque {
	private Par miPosicion;
	private boolean puedeVisitarse;
	private BloqueGrafico miRepresentacion;
	private ArrayList<Entidad> listaEntidades;
	
	public Bloque(int x , int y , boolean puedeVisitarse, Entidad miEntidad ) {
		miPosicion = new Par(x , y);
		this.puedeVisitarse = puedeVisitarse;
		listaEntidades = new ArrayList<Entidad>();
		listaEntidades.add(miEntidad);
		miRepresentacion = new BloqueGrafico(puedeVisitarse , listaEntidades );
	}
	
	public Bloque(int x , int y , boolean puedeVisitarse ) {
		miPosicion = new Par(x , y);
		this.puedeVisitarse = puedeVisitarse;
		miRepresentacion = new BloqueGrafico(puedeVisitarse);
	}
	
	public void actualizarListaEntidades(Entidad entidadABorrar ) {	
		listaEntidades.remove(entidadABorrar);//Con lo que me dicen
		miRepresentacion.actualizar(listaEntidades);
	}
}
