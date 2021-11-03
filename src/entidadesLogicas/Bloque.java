package entidadesLogicas;

import java.util.ArrayList;
import entidadesGraficas.BloqueGrafico;

public class Bloque {
	private Posicion miPosicion;
	private boolean puedeVisitarse;
	private BloqueGrafico miRepresentacion;
	private ArrayList<Entidad> listaEntidades;
	
	public Bloque(int x , int y , boolean puedeVisitarse, Entidad miEntidad ) {
		miPosicion = new Posicion(x , y);
		this.puedeVisitarse = puedeVisitarse;
		listaEntidades = new ArrayList<Entidad>();
		listaEntidades.add(miEntidad);
		miRepresentacion = new BloqueGrafico( listaEntidades );
	}
	
	public Bloque(int x , int y , boolean puedeVisitarse ) {
		miPosicion = new Posicion(x , y);
		this.puedeVisitarse = puedeVisitarse;
		miRepresentacion = new BloqueGrafico();
		listaEntidades = new ArrayList<Entidad>();
	}
	

	public void agregarAListaEntidades(Entidad entidadABorrar ) {	
		listaEntidades.remove(entidadABorrar);
	}
	
	public void borrarDeListaDeEntidades(Entidad entidadAAgregar) {
		listaEntidades.add(entidadAAgregar);
	}

	public Posicion getMiPosicion() {
		return miPosicion;
	}

	public void setMiPosicion(Posicion miPosicion) {
		this.miPosicion = miPosicion;
	}

	public boolean isPuedeVisitarse() {
		return puedeVisitarse;
	}

	public void setPuedeVisitarse(boolean puedeVisitarse) {
		this.puedeVisitarse = puedeVisitarse;
	}

	public BloqueGrafico getMiRepresentacion() {
		return miRepresentacion;
	}

	public void setMiRepresentacion(BloqueGrafico miRepresentacion) {
		this.miRepresentacion = miRepresentacion;
	}
	
	
}
