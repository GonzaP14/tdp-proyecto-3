package personajes;

import entidadesLogicas.Entidad;
import entidadesLogicas.Par;
import entidadesLogicas.Posicion;

public abstract class Personaje extends Entidad {
	
	private int velocidadActual;
	
	public int getVelocidadActual() {
		return velocidadActual;
	}

	public abstract void recibirEfecto();
	
	public void mover() {	
		if(sentidoActual == Entidad.sentidoAbajo || sentidoActual == Entidad.sentidoArriba ) 
			moverVerticalmente(sentidoActual);
		else if(sentidoActual == Entidad.sentidoDerecha || sentidoActual == Entidad.sentidoIzquierda )
			moverLateralmente(sentidoActual);
	}
	
	private void moverLateralmente(int desplazamiento) {
		Posicion proximaPosicion = null;
		Par offsetBloqueSiguiente = new Par(0, 0);
		if(desplazamiento == Entidad.sentidoDerecha ) {
			proximaPosicion = new Posicion((int) miPosicion.getX() + 5, (int) miPosicion.getY() );
			offsetBloqueSiguiente = new Par(12.5, 0);
		}
		else if(desplazamiento == Entidad.sentidoIzquierda ) {
			proximaPosicion = new Posicion((int) miPosicion.getX() - 5, (int) miPosicion.getY() );	
			offsetBloqueSiguiente = new Par(-12.5, 0);
		}
		if(proximaPosicion != null && !miJuego.getMiGrilla().buscarColisiones(this, proximaPosicion, offsetBloqueSiguiente) ) {
			miPosicion = proximaPosicion;
			miRepresentacion.setLocation((int) miPosicion.getX() , (int) miPosicion.getY());
		}
	}
	
	private void moverVerticalmente(int desplazamiento) {
		Posicion proximaPosicion = null;
		Par offsetBloqueSiguiente = new Par(0, 0);
		if(desplazamiento == Entidad.sentidoArriba ) {
			proximaPosicion = new Posicion((int) miPosicion.getX(), (int) miPosicion.getY() - 5 );
			offsetBloqueSiguiente = new Par(0, -12.5);
		}
		else if(desplazamiento == Entidad.sentidoAbajo ) {
			proximaPosicion = new Posicion((int) miPosicion.getX(), (int) miPosicion.getY() + 5 );
			offsetBloqueSiguiente = new Par(0, 12.5);
		}
		if(proximaPosicion != null && !miJuego.getMiGrilla().buscarColisiones(this, proximaPosicion, offsetBloqueSiguiente)) {
			miPosicion = proximaPosicion;
			miRepresentacion.setLocation((int) miPosicion.getX() , (int) miPosicion.getY());
		}
	}
	
	public void morir() {
		
	}
}



