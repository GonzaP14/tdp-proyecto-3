package entidadesLogicas;

import java.awt.Rectangle;

import personajes.Personaje;

public class Grilla {
	
	protected Bloque grilla[][];
	public static final int Filas = 31;
    public static final int Columnas = 28;
	
	// ------------------------------------ Constructor ------------------------------------------
	
	public Grilla() {
		grilla = new Bloque [Filas][Columnas];
		
		for (int i = 0; i < Filas; i ++) {
			for (int j = 0; j < Columnas; j ++) {
				grilla[i][j] = new Bloque(i*25,j*25,true);
			}
		}
	}
	
	// ------------------------------------   Metodos   ------------------------------------------
	public boolean buscarColisiones(int sentidoEntidad, Posicion proximaPos) {
		Rectangle p = new Rectangle(proximaPos.getY() , proximaPos.getX() , 25 , 25);	
        Bloque carlitos;
        Rectangle bloque ;
        
        if(sentidoEntidad == Personaje.sentidoIzquierda ) {
        	Posicion izquierdaArribaBloque = new Posicion(proximaPos.getY() / 25 , proximaPos.getX() / 25);
        	carlitos = grilla[izquierdaArribaBloque.getX()][izquierdaArribaBloque.getY()];
        	bloque = new Rectangle(carlitos.getMiPosicion().getX(),carlitos.getMiPosicion().getY(),25,25);
        	if(carlitos.isPuedeVisitarse() == false && bloque.intersects(p) ) 
        		return true;
        	Posicion izquierdaAbajoBloque = new Posicion(proximaPos.posicionEsquinaAbajoIzquierda().getY() / 25 , proximaPos.posicionEsquinaAbajoIzquierda().getX() / 25);
        	carlitos = grilla[izquierdaAbajoBloque.getX()][izquierdaAbajoBloque.getY()];
        	bloque = new Rectangle(carlitos.getMiPosicion().getX(),carlitos.getMiPosicion().getY(),25,25);
        	if(carlitos.isPuedeVisitarse() == false && bloque.intersects(p) ) 
        		return true;        	
		}
        else if(sentidoEntidad == Personaje.sentidoDerecha) {
        	Posicion derechaArribaBloque = new Posicion(proximaPos.posicionEsquinaArribaDerecha().getY() / 25 , proximaPos.posicionEsquinaArribaDerecha().getX() / 25);
        	carlitos = grilla[derechaArribaBloque.getX()][derechaArribaBloque.getY()];
        	bloque = new Rectangle(carlitos.getMiPosicion().getX(),carlitos.getMiPosicion().getY(),25,25);
        	if(carlitos.isPuedeVisitarse() == false && bloque.intersects(p) ) 
        		return true;
        	Posicion derechaAbajoBloque = new Posicion(proximaPos.posicionEsquinaAbajoDerecha().getY() / 25 , proximaPos.posicionEsquinaAbajoDerecha().getX() / 25);
        	carlitos = grilla[derechaAbajoBloque.getX()][derechaAbajoBloque.getY()];
        	bloque = new Rectangle(carlitos.getMiPosicion().getX(),carlitos.getMiPosicion().getY(),25,25);
        	if(carlitos.isPuedeVisitarse() == false && bloque.intersects(p) ) 
        		return true;
        }
        else if(sentidoEntidad == Personaje.sentidoArriba) {
        	Posicion derechaArribaBloque = new Posicion(proximaPos.posicionEsquinaArribaDerecha().getY() / 25 , proximaPos.posicionEsquinaArribaDerecha().getX() / 25);
        	carlitos = grilla[derechaArribaBloque.getX()][derechaArribaBloque.getY()];
        	bloque = new Rectangle(carlitos.getMiPosicion().getX(),carlitos.getMiPosicion().getY(),25,25);
        	if(carlitos.isPuedeVisitarse() == false && bloque.intersects(p) ) 
        		return true;
        	Posicion izquierdaArribaBloque = new Posicion(proximaPos.getY() / 25 , proximaPos.getX() / 25);
        	carlitos = grilla[izquierdaArribaBloque.getX()][izquierdaArribaBloque.getY()];
        	bloque = new Rectangle(carlitos.getMiPosicion().getX(),carlitos.getMiPosicion().getY(),25,25);
        	if(carlitos.isPuedeVisitarse() == false && bloque.intersects(p) ) 
        		return true;
        }
        else if(sentidoEntidad == Personaje.sentidoAbajo) {
        	Posicion derechaAbajoBloque = new Posicion(proximaPos.posicionEsquinaAbajoDerecha().getY() / 25 , proximaPos.posicionEsquinaAbajoDerecha().getX() / 25);
        	carlitos = grilla[derechaAbajoBloque.getX()][derechaAbajoBloque.getY()];
        	bloque = new Rectangle(carlitos.getMiPosicion().getX(),carlitos.getMiPosicion().getY(),25,25);
        	if(carlitos.isPuedeVisitarse() == false && bloque.intersects(p) ) 
        		return true;
        	Posicion izquierdaAbajoBloque = new Posicion(proximaPos.posicionEsquinaAbajoIzquierda().getY() / 25 , proximaPos.posicionEsquinaAbajoIzquierda().getX() / 25);
        	carlitos = grilla[izquierdaAbajoBloque.getX()][izquierdaAbajoBloque.getY()];
        	bloque = new Rectangle(carlitos.getMiPosicion().getX(),carlitos.getMiPosicion().getY(),25,25);
        	if(carlitos.isPuedeVisitarse() == false && bloque.intersects(p) ) 
        		return true;
        }
        
		return false;
	}
	
	public void buscarColisionesEntidades(Entidad e) {
		Posicion posicionActual = e.getPosicion();
		Bloque bloqueActual = null;
		bloqueActual = grilla[posicionActual.getY() / 25][posicionActual.getX() / 25];
		Rectangle rectanguloPosicion = new Rectangle(posicionActual.getX() , posicionActual.getY() );
		Rectangle rectanguloEntidadBloque ;
		for(Entidad entidadBloque : bloqueActual.getListaEntidades() ) {
			rectanguloEntidadBloque = new Rectangle(entidadBloque.getPosicion().getX() , entidadBloque.getPosicion().getY());
			if(rectanguloEntidadBloque.intersects(rectanguloPosicion)) {
				entidadBloque.afectar();
			}
		}
		bloqueActual.getListaEntidades().removeAll(bloqueActual.getListaRemovidos());
		bloqueActual.limpiarListaRemovidos();
	}
	
	public void resetear() {
	
	}
	
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	
	public boolean bloqueVisitable (int i, int j) {
		
		
		return ((i >= 0 && i < Filas) && (j >= 0 && j < Columnas) && grilla[i][j].isPuedeVisitarse());
	}
	
}
