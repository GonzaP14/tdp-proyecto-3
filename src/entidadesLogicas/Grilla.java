package entidadesLogicas;

import java.awt.Rectangle;

import gui.Ventana;
import personajes.Principal;

public class Grilla {
	
	protected Bloque grilla[][];
	public static final int Filas = 31;
    public static final int Columnas = 28;
	
	// ------------------------------------ Constructor ------------------------------------------
	
	public Grilla() {
		grilla = new Bloque [Filas][Columnas];
		
		for (int i = 0; i < Filas; i ++) {
			for (int j = 0; j < Columnas; j ++) {
				grilla[i][j] = new Bloque(i*Ventana.pixelesBloque,j*Ventana.pixelesBloque,true);
			}
		}
	}
	
	
	// ------------------------------------   Metodos   ------------------------------------------
	private boolean colisionaConBloque(int sentidoEntidad, Posicion proximaPos, Rectangle rectanguloDePrincipal, int indiceEsquinaActual) {
		boolean hayColision = false;
		Posicion esquina = new Posicion(proximaPos.getPosicionEsquina(sentidoEntidad)[indiceEsquinaActual].getY() / Ventana.pixelesBloque , proximaPos.getPosicionEsquina(sentidoEntidad)[indiceEsquinaActual].getX() / Ventana.pixelesBloque);
		Bloque bloqueLigadoAEsquina = grilla[esquina.getX()][esquina.getY()];
		Rectangle rectanguloParaBloque = new Rectangle(bloqueLigadoAEsquina.getMiPosicion().getX(),bloqueLigadoAEsquina.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
		
		if(bloqueLigadoAEsquina.esVisitable() == false && rectanguloParaBloque.intersects(rectanguloDePrincipal)) 
    		hayColision =  true;
		
		return hayColision;
	}
	
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
	
	public void buscarColisionesEntidades(Principal e) {
		Posicion posicionActual = e.getPosicion();
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
		e.setYaMeMatoOtroFantasma(false);
	}
	
	public void reset() {		
		for (int i = 0; i < Filas; i ++) {
			for (int j = 0; j < Columnas; j ++) {
				grilla[i][j].reset();
			}
		} 
	}
	
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	
	public boolean bloqueVisitable (int i, int j) {
		return ((i >= 0 && i < Filas) && (j >= 0 && j < Columnas) && grilla[i][j].esVisitable());
	}
	
}
