package entidadesLogicas;

import java.util.ArrayList;
import entidadesGraficas.BloqueGrafico;

public class Bloque {
	
	private Posicion miPosicion;
	private boolean puedeVisitarse;
	private BloqueGrafico miRepresentacion;
	private ArrayList<Entidad> listaEntidades,listaRemovidos;

	public Bloque(int x , int y , boolean puedeVisitarse ) {
		miPosicion = new Posicion(x , y);
		this.puedeVisitarse = puedeVisitarse;
		miRepresentacion = new BloqueGrafico();
		listaEntidades = new ArrayList<Entidad>();
		listaRemovidos = new ArrayList<Entidad>();
	}
	

	public void agregarAListaEntidades(Entidad entidadABorrar ) {	
		listaEntidades.add(entidadABorrar);
	}
	
	public void borrarDeListaDeEntidades(Entidad entidadAAgregar) {
		listaEntidades.remove(entidadAAgregar);
	}

	public Posicion getMiPosicion() {
		return miPosicion;
	}

	public void setMiPosicion(Posicion miPosicion) {
		this.miPosicion = miPosicion;
	}

	public boolean esVisitable() {
		return puedeVisitarse;
	}

	public void setVisitable(boolean puedeVisitarse) {
		this.puedeVisitarse = puedeVisitarse;
	}

	public BloqueGrafico getMiRepresentacion() {
		return miRepresentacion;
	}

	public void setMiRepresentacion(BloqueGrafico miRepresentacion) {
		this.miRepresentacion = miRepresentacion;
	}


	public ArrayList<Entidad> getListaEntidades() {
		return listaEntidades;
	}


	public ArrayList<Entidad> getListaRemovidos() {
		return listaRemovidos;
	}
	
	public void agregarAListaRemovidos(Entidad entidadABorrar ) {	
		listaRemovidos.add(entidadABorrar);
	}
	
	public void limpiarListaRemovidos() {
		listaRemovidos = new ArrayList<Entidad>();
	}
	
}
