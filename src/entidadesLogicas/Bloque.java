package entidadesLogicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidadesGraficas.BloqueGrafico;

public class Bloque {
	
	private Posicion miPosicion;
	private boolean puedeVisitarse;
	private BloqueGrafico miRepresentacion;
	private List<Entidad> listaEntidades, listaRemovidos;

	public Bloque(int x , int y , boolean puedeVisitarse ) {
		miPosicion = new Posicion(x , y);
		this.puedeVisitarse = puedeVisitarse;
		miRepresentacion = new BloqueGrafico();
		listaEntidades = Collections.synchronizedList(new ArrayList<Entidad>());
		listaRemovidos = Collections.synchronizedList(new ArrayList<Entidad>());
	}
	

	public void agregarAListaEntidades(Entidad entidadABorrar ) {	
		listaEntidades.add(entidadABorrar);
	}
	
	public void borrarDeListaDeEntidades(Entidad entidadAAgregar) {
		listaEntidades.remove(entidadAAgregar);
	}
	
	public void agregarAListaRemovidos(Entidad entidadABorrar) {	
		listaRemovidos.add(entidadABorrar);
	}
	
	public void limpiarListaRemovidos() {
		listaRemovidos.clear();
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

	public BloqueGrafico getRepresentacionGrafica() {
		return miRepresentacion;
	}

	public void setRepresentacionGrafica(BloqueGrafico miRepresentacion) {
		this.miRepresentacion = miRepresentacion;
	}

	public List<Entidad> getListaEntidades() {
		return listaEntidades;
	}


	public List<Entidad>  getListaRemovidos() {
		return listaRemovidos;
	}
}
