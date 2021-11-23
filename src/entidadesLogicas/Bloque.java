package entidadesLogicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import niveles.BloqueGrafico;

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
	
	/**
	 * Agrego una entidad a la lista de entidades del bloque
	 * @param entidadAAgregar a la lista de entidades
	 */
	public void agregarAListaEntidades(Entidad entidadAAgregar ) {	
		listaEntidades.add(entidadAAgregar);
	}
	
	/**
	 * Borro una entidad de la lista de entidades del bloque
	 * @param entidadABorrar de la lista de entidades del bloque
	 */
	public void borrarDeListaDeEntidades(Entidad entidadABorrar) {
		listaEntidades.remove(entidadABorrar);
	}
	
	/**
	 * Agrego una entidad a la lista de removidos para despues ser borrada
	 * @param entidadABorrar de la lista de entidades
	 */
	public void agregarAListaRemovidos(Entidad entidadABorrar) {	
		listaRemovidos.add(entidadABorrar);
	}
	
	/**
	 * Limpio la lista de removidos para proximos usos
	 */
	public void limpiarListaRemovidos() {
		listaRemovidos.clear();
	}
	
	/**
	 * Retorno la posicion del bloque
	 * @return la posicion del bloque
	 */
	public Posicion getMiPosicion() {
		return miPosicion;
	}
	
	/**
	 * Seteo la posicion del bloque
	 * @param miPosicion posicion que se le va a poner al bloque
	 */
	public void setMiPosicion(Posicion miPosicion) {
		this.miPosicion = miPosicion;
	}
	
	/**
	 * Seteo si es visitable o no el bloque
	 * @param puedeVisitarse booleano que va a decir si el bloque es visitable o no
	 */
	public void setVisitable(boolean puedeVisitarse) {
		this.puedeVisitarse = puedeVisitarse;
	}
	
	/**
	 * Seteo la representacion grafica del bloque
	 * @param miRepresentacion Representacion grafica del bloque
	 */
	public void setRepresentacionGrafica(BloqueGrafico miRepresentacion) {
		this.miRepresentacion = miRepresentacion;
	}
	
	/**
	 * Reseteo el bloque para un cambio proximo de nivel
	 */
	public void reset() {
		miRepresentacion = new BloqueGrafico();
		listaEntidades = Collections.synchronizedList(new ArrayList<Entidad>());
		listaRemovidos = Collections.synchronizedList(new ArrayList<Entidad>());
	}
	
	/**
	 * Devuelvo si el bloque es visitable o no
	 * @return si puedo visitarlo
	 */
	public boolean esVisitable() {
		return puedeVisitarse;
	}
	
	/**
	 * Devuelvo la representacion grafica del bloque
	 * @return la representacion grafica
	 */
	public BloqueGrafico getRepresentacionGrafica() {
		return miRepresentacion;
	}
	
	/**
	 * Devuelvo la lista de entidades del bloque
	 * @return lista de entidades del bloque
	 */
	public List<Entidad> getListaEntidades() {
		return listaEntidades;
	}

	/**
	 * Devuelvo la lista de removidos del bloque
	 * @return lista de removidos del bloque
	 */
	public List<Entidad>  getListaRemovidos() {
		return listaRemovidos;
	}
	
}
