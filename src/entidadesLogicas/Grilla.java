package entidadesLogicas;

import java.awt.Rectangle;

import gui.Ventana;
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
				grilla[i][j] = new Bloque(i*Ventana.pixelesBloque,j*Ventana.pixelesBloque,true);
			}
		}
	}
	
	// ------------------------------------   Metodos   ------------------------------------------
	public boolean buscarColisiones(int sentidoEntidad, Posicion proximaPos) {
		Rectangle rectanguloPosicionPj = new Rectangle(proximaPos.getY() , proximaPos.getX() , Ventana.pixelesBloque , Ventana.pixelesBloque);	
        Bloque bloqueNecesario;
        Rectangle rectanguloBloque;
        
        if(sentidoEntidad == Personaje.sentidoIzquierda ) {
        	Posicion izquierdaArribaBloque = new Posicion(proximaPos.getY() / Ventana.pixelesBloque , proximaPos.getX() / Ventana.pixelesBloque);
        	bloqueNecesario = grilla[izquierdaArribaBloque.getX()][izquierdaArribaBloque.getY()];
        	rectanguloBloque = new Rectangle(bloqueNecesario.getMiPosicion().getX(),bloqueNecesario.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
        	if(bloqueNecesario.esVisitable() == false && rectanguloBloque.intersects(rectanguloPosicionPj) ) 
        		return true;
        	Posicion izquierdaAbajoBloque = new Posicion(proximaPos.posicionEsquinaAbajoIzquierda().getY() / Ventana.pixelesBloque , proximaPos.posicionEsquinaAbajoIzquierda().getX() / Ventana.pixelesBloque);
        	bloqueNecesario = grilla[izquierdaAbajoBloque.getX()][izquierdaAbajoBloque.getY()];
        	rectanguloBloque = new Rectangle(bloqueNecesario.getMiPosicion().getX(),bloqueNecesario.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
        	if(bloqueNecesario.esVisitable() == false && rectanguloBloque.intersects(rectanguloPosicionPj) ) 
        		return true;        	
		}
        else if(sentidoEntidad == Personaje.sentidoDerecha) {
        	Posicion derechaArribaBloque = new Posicion(proximaPos.posicionEsquinaArribaDerecha().getY() / Ventana.pixelesBloque , proximaPos.posicionEsquinaArribaDerecha().getX() / Ventana.pixelesBloque);
        	bloqueNecesario = grilla[derechaArribaBloque.getX()][derechaArribaBloque.getY()];
        	rectanguloBloque = new Rectangle(bloqueNecesario.getMiPosicion().getX(),bloqueNecesario.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
        	if(bloqueNecesario.esVisitable() == false && rectanguloBloque.intersects(rectanguloPosicionPj) ) 
        		return true;
        	Posicion derechaAbajoBloque = new Posicion(proximaPos.posicionEsquinaAbajoDerecha().getY() / Ventana.pixelesBloque , proximaPos.posicionEsquinaAbajoDerecha().getX() / Ventana.pixelesBloque);
        	bloqueNecesario = grilla[derechaAbajoBloque.getX()][derechaAbajoBloque.getY()];
        	rectanguloBloque = new Rectangle(bloqueNecesario.getMiPosicion().getX(),bloqueNecesario.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
        	if(bloqueNecesario.esVisitable() == false && rectanguloBloque.intersects(rectanguloPosicionPj) ) 
        		return true;
        }
        else if(sentidoEntidad == Personaje.sentidoArriba) {
        	Posicion derechaArribaBloque = new Posicion(proximaPos.posicionEsquinaArribaDerecha().getY() / Ventana.pixelesBloque , proximaPos.posicionEsquinaArribaDerecha().getX() / Ventana.pixelesBloque);
        	bloqueNecesario = grilla[derechaArribaBloque.getX()][derechaArribaBloque.getY()];
        	rectanguloBloque = new Rectangle(bloqueNecesario.getMiPosicion().getX(),bloqueNecesario.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
        	if(bloqueNecesario.esVisitable() == false && rectanguloBloque.intersects(rectanguloPosicionPj) ) 
        		return true;
        	Posicion izquierdaArribaBloque = new Posicion(proximaPos.getY() / Ventana.pixelesBloque , proximaPos.getX() / Ventana.pixelesBloque);
        	bloqueNecesario = grilla[izquierdaArribaBloque.getX()][izquierdaArribaBloque.getY()];
        	rectanguloBloque = new Rectangle(bloqueNecesario.getMiPosicion().getX(),bloqueNecesario.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
        	if(bloqueNecesario.esVisitable() == false && rectanguloBloque.intersects(rectanguloPosicionPj) ) 
        		return true;
        }
        else if(sentidoEntidad == Personaje.sentidoAbajo) {
        	Posicion derechaAbajoBloque = new Posicion(proximaPos.posicionEsquinaAbajoDerecha().getY() / Ventana.pixelesBloque , proximaPos.posicionEsquinaAbajoDerecha().getX() / Ventana.pixelesBloque);
        	bloqueNecesario = grilla[derechaAbajoBloque.getX()][derechaAbajoBloque.getY()];
        	rectanguloBloque = new Rectangle(bloqueNecesario.getMiPosicion().getX(),bloqueNecesario.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
        	if(bloqueNecesario.esVisitable() == false && rectanguloBloque.intersects(rectanguloPosicionPj) ) 
        		return true;
        	Posicion izquierdaAbajoBloque = new Posicion(proximaPos.posicionEsquinaAbajoIzquierda().getY() / Ventana.pixelesBloque , proximaPos.posicionEsquinaAbajoIzquierda().getX() / Ventana.pixelesBloque);
        	bloqueNecesario = grilla[izquierdaAbajoBloque.getX()][izquierdaAbajoBloque.getY()];
        	rectanguloBloque = new Rectangle(bloqueNecesario.getMiPosicion().getX(),bloqueNecesario.getMiPosicion().getY(),Ventana.pixelesBloque,Ventana.pixelesBloque);
        	if(bloqueNecesario.esVisitable() == false && rectanguloBloque.intersects(rectanguloPosicionPj) ) 
        		return true;
        }
        
		return false;
	}
	
	public void buscarColisionesEntidades(Entidad e) {
		Posicion posicionActual = e.getPosicion();
		Bloque bloqueActual = null;
		bloqueActual = grilla[posicionActual.getY() / Ventana.pixelesBloque][posicionActual.getX() / Ventana.pixelesBloque];
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
		return ((i >= 0 && i < Filas) && (j >= 0 && j < Columnas) && grilla[i][j].esVisitable());
	}
	
}
