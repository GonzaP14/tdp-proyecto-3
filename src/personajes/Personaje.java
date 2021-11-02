package personajes;

import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public abstract class Personaje extends Entidad {
	private int velocidadActual;
	
	public int getVelocidadActual() {
		return velocidadActual;
	}
	
	public Posicion getMiSpawn() {
		return miSpawn;
	}

	public void setMiSpawn(Posicion miSpawn) {
		this.miSpawn = miSpawn;
	}

	public abstract void recibirEfecto();
	
	public void mover(int movimiento) {
		Posicion miPosicionActual = miBloque.getMiPosicion(); 
		
		if(movimiento == Entidad.sentidoAbajo || movimiento == Entidad.sentidoArriba ) 
			moverVerticalmente(movimiento , miPosicionActual );
		else if(movimiento == Entidad.sentidoDerecha || movimiento == Entidad.sentidoIzquierda )
			moverLateralmente(movimiento , miPosicionActual );
	}
	
	private void moverLateralmente(int desplazamiento , Posicion miPosicionActual) {
		Posicion proximaPosicion;
		
		if(desplazamiento == Entidad.sentidoDerecha ) {
			proximaPosicion = new Posicion(miPosicionActual.getX() + 5, miPosicionActual.getY() );
			
			if(miJuego.getMiGrilla().buscarColisiones(proximaPosicion) )
				cambiarMiBloque(proximaPosicion);
		}
		else if(desplazamiento == Entidad.sentidoIzquierda ) {
			proximaPosicion = new Posicion(miPosicionActual.getX() - 5, miPosicionActual.getY() );
			
			if(miJuego.getMiGrilla().buscarColisiones(proximaPosicion) )
				cambiarMiBloque(proximaPosicion);
		}
	}
	
	private void moverVerticalmente(int desplazamiento , Posicion miPosicionActual) {
		Posicion proximaPosicion;
		if(desplazamiento == Entidad.sentidoArriba ) {
			proximaPosicion = new Posicion(miPosicionActual.getX() , miPosicionActual.getY() + 5 );
			
			if(miJuego.getMiGrilla().buscarColisiones(proximaPosicion) )
				cambiarMiBloque(proximaPosicion);
		}
		else if(desplazamiento == Entidad.sentidoAbajo ) {
			proximaPosicion = new Posicion(miPosicionActual.getX() , miPosicionActual.getY() - 5 );
			
			if(miJuego.getMiGrilla().buscarColisiones(proximaPosicion) )
				cambiarMiBloque(proximaPosicion);
		}
	}
	
	private void cambiarMiBloque(Posicion miPosicionAMover) {
		miBloque = miJuego.getMiGrilla().getBloque(miPosicionAMover.getX() / 10 , miPosicionAMover.getY() / 10);
	}
	
	public void morir() {
		
	}
	
}
