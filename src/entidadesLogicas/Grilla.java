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
	public boolean buscarColisiones(Entidad entidad, Posicion proximaPos ) {
		int sentido = entidad.getSentidoActual();
		Rectangle p = new Rectangle(proximaPos.getY() , proximaPos.getX() , 25 , 25);	
        Bloque carlitos;
        Rectangle bloque ;
        if(sentido == Personaje.sentidoIzquierda ) {
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
        else if(sentido == Personaje.sentidoDerecha) {
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
        else if(sentido == Personaje.sentidoArriba) {
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
        else if(sentido == Personaje.sentidoAbajo) {
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
	
	public void resetear() {
	
	}
	
	public Bloque getBloque(int x, int y) {
		return grilla[x][y];
	}
	
}
