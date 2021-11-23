package entidadesLogicas;

import java.awt.Rectangle;

import gui.Ventana;
import personajes.Principal;

public class Grilla {
	
	// Atributos de clase
	public static final int Filas = 31;
    public static final int Columnas = 28;
    
 // Atributos de instancia
 	protected Bloque grilla[][];
	
	// ------------------------------------ Constructor ------------------------------------------
	/**
	 * Inicializa el mapa logico del juego, con sus bloques en un estado inicial por defecto.
	 */
	public Grilla() {
		grilla = new Bloque [Filas][Columnas];
		
		for (int i = 0; i < Filas; i ++) {
			for (int j = 0; j < Columnas; j ++) {
				grilla[i][j] = new Bloque(i*Ventana.pixelesBloque,j*Ventana.pixelesBloque,true);
			}
		}
	}
	
	
	// ------------------------------------   Metodos   ------------------------------------------
	
	/**
	 * Comprueba si, para el bloque en el que el p se encuentra, p colisiona con alguna entidad.
	 * En caso de hacerlo, desencadena los efectos correspondientes en el juego.
	 * @param p El personaje principal del juego
	 */
	public void buscarColisionesEntidades(Principal p) {
		Posicion posicionActual = p.getPosicion();
		Bloque bloqueActual = null;
		bloqueActual = grilla[posicionActual.getY() / Ventana.pixelesBloque][posicionActual.getX() / Ventana.pixelesBloque];
		Rectangle rectanguloPosicion = new Rectangle(posicionActual.getX() , posicionActual.getY() );
		Rectangle rectanguloEntidadBloque ;

		for (int i = 0; i < bloqueActual.getListaEntidades().size(); i++) {
			Entidad entidadBloque = bloqueActual.getListaEntidades().get(i);
			rectanguloEntidadBloque = new Rectangle(entidadBloque.getPosicion().getX() , entidadBloque.getPosicion().getY());
			if(rectanguloEntidadBloque.intersects(rectanguloPosicion)) {
				entidadBloque.afectar();
			}
		}
		
		bloqueActual.getListaEntidades().removeAll(bloqueActual.getListaRemovidos());
		bloqueActual.limpiarListaRemovidos();
		p.setYaMeMatoOtroFantasma(false);
	}
	
	/**
	 * Restablece todos los bloques del mapa o grilla, al estado por defecto.
	 */
	public void reset() {		
		for (int i = 0; i < Filas; i ++) {
			for (int j = 0; j < Columnas; j ++) {
				grilla[i][j].reset();
			}
		} 
	}
	
	// ------------------------------------   Consultas   ------------------------------------------
	/**
	 * 
	 * @param x Coordenada x (o fila) del bloque, en el mapa.
	 * @param y Coordenada y (o columna)  del bloque, en el mapa.
	 * @return Devuelve un bloque particular, de la grilla o mapa del juego, a partir de sus coordenadas matriciales.
	 */
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	
	/**
	 * Determina si un bloque (determinado por una fila y una columna) es visitable o no
	 * @param i Fila del bloque.
	 * @param j Columna del bloque.
	 * @return Devuelve si el bloque en cuestion es visitable o no.
	 */
	public boolean bloqueVisitable (int i, int j) {
		return ((i >= 0 && i < Filas) && (j >= 0 && j < Columnas) && grilla[i][j].esVisitable());
	}
	
	/**
	 * Determina si el personaje principal colisiona con un bloque, el cual resulta a partir de una posicion determinada.
	 * @param sentidoEntidad El sentido que el personaje matiene actualmente, para su movimiento.
	 * @param proximaPos La posicion a partir de la cual se obtiene el bloque con el cual se evalua la colision.
	 * @param rectanguloDePrincipal El rectangulo que determina la hitbox del personaje, la cual interviene en la evaluacion de colision.
	 * @param indiceEsquinaActual El indice para la esquina a considerar (segun el sentido del personaje principal), del bloque con el cual se evalua la colision.
	 * @return Devuelve si existe colision entre la hitbox del personaje y el bloque determinado.
	 */
	private boolean colisionaConBloque(int sentidoEntidad, Posicion proximaPos, Rectangle rectanguloDePrincipal, int indiceEsquinaActual) {
		boolean hayColision = false;
		Posicion esquina = new Posicion(proximaPos.getPosicionEsquina(sentidoEntidad)[indiceEsquinaActual].getY() / Ventana.pixelesBloque , proximaPos.getPosicionEsquina(sentidoEntidad)[indiceEsquinaActual].getX() / Ventana.pixelesBloque);
		Bloque bloqueLigadoAEsquina = grilla[esquina.getX()][esquina.getY()];
		Rectangle rectanguloParaBloque = new Rectangle(bloqueLigadoAEsquina.getMiPosicion().getX(),bloqueLigadoAEsquina.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
		
		if(bloqueLigadoAEsquina.esVisitable() == false && rectanguloParaBloque.intersects(rectanguloDePrincipal)) 
    		hayColision =  true;
		
		return hayColision;
	}
	
	/**
	 * Comprueba si existe al menos una colision entre la posicion hacia donde el personaje principal desea moverse,
	 * y los bloques determinados por la misma.
	 * @param sentidoEntidad El sentido que lleva el personaje principal (hacia donde se mueve).
	 * @param proximaPos La posicion hacia donde desea moverse el personaje principal.
	 * @return Devuelve si existe al menos una colision
	 */
	public boolean buscarColisiones(int sentidoEntidad, Posicion proximaPos) {
		Rectangle rectanguloDePrincipal = new Rectangle(proximaPos.getY() , proximaPos.getX() , Ventana.pixelesBloque , Ventana.pixelesBloque);	
        boolean colisiona = false;
        
    	for (int i = 0; i < 2; i++) {
    		colisiona = colisionaConBloque(sentidoEntidad, proximaPos, rectanguloDePrincipal, i);
    		if (colisiona) {
    			return true;
    		}
    	}
        
    	return colisiona;
	}
}
