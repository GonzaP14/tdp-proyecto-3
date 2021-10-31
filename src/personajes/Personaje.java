package personajes;

import entidadesLogicas.Entidad;
import entidadesLogicas.Par;

public abstract class Personaje extends Entidad {
	private int velocidadActual;
	
	public Personaje(int velocidadActual) {
		this.velocidadActual = velocidadActual;
	}
	public int getVelocidadActual() {
		return velocidadActual;
	}
	public abstract void recibirEfecto();
	
	public void mover(int movimiento) {
		Par miPosicionActual = miBloque.getMiPosicion(); 
		
		if(movimiento == Entidad.sentidoAbajo || movimiento == Entidad.sentidoArriba ) 
			moverVerticalmente(movimiento , miPosicionActual );
		else if(movimiento == Entidad.sentidoDerecha || movimiento == Entidad.sentidoIzquierda )
			moverLateralmente(movimiento , miPosicionActual );
	}
	
	private void moverLateralmente(int desplazamiento , Par miPosicionActual) {
		Par proximaPosicion;
		
		if(desplazamiento == Entidad.sentidoDerecha ) {
			proximaPosicion = new Par(miPosicionActual.getX() + 1, miPosicionActual.getY() );
			
			if(miJuego.getMiGrilla().buscarColisiones(proximaPosicion) )
				miBloque = miJuego.getMiGrilla().getBloque(proximaPosicion.getX() , proximaPosicion.getY() );
		}
		else if(desplazamiento == Entidad.sentidoIzquierda ) {
			proximaPosicion = new Par(miPosicionActual.getX() - 1, miPosicionActual.getY() );
			
			if(miJuego.getMiGrilla().buscarColisiones(proximaPosicion) )
				miBloque = miJuego.getMiGrilla().getBloque(proximaPosicion.getX() , proximaPosicion.getY() );
		}
	}
	
	private void moverVerticalmente(int desplazamiento , Par miPosicionActual) {
		Par proximaPosicion;
		if(desplazamiento == Entidad.sentidoArriba ) {
			proximaPosicion = new Par(miPosicionActual.getX() , miPosicionActual.getY() + 1 );
			
			if(miJuego.getMiGrilla().buscarColisiones(proximaPosicion) )
				miBloque = miJuego.getMiGrilla().getBloque(proximaPosicion.getX() , proximaPosicion.getY() );
		}
		else if(desplazamiento == Entidad.sentidoAbajo ) {
			proximaPosicion = new Par(miPosicionActual.getX() , miPosicionActual.getY() - 1 );
			
			if(miJuego.getMiGrilla().buscarColisiones(proximaPosicion) )
				miBloque = miJuego.getMiGrilla().getBloque(proximaPosicion.getX() , proximaPosicion.getY() );
		}
	}
	
	public void morir() {
		
	}
	
}
