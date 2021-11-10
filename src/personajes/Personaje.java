package personajes;

import entidadesLogicas.Entidad;
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
		if(desplazamiento == Entidad.sentidoDerecha ) {
			proximaPosicion = new Posicion( miPosicion.getX() + 5, miPosicion.getY() );
		}
		else if(desplazamiento == Entidad.sentidoIzquierda ) {
			proximaPosicion = new Posicion( miPosicion.getX() - 5,  miPosicion.getY() );	
		}
		System.out.println(proximaPosicion);
		if(proximaPosicion != null && proximaPosicion.equals(new Posicion(-5 , 350))) {
			miPosicion = new Posicion(670 , 350);
			miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
		}
		else if(proximaPosicion != null && proximaPosicion.equals(new Posicion(675 , 350))) {
			miPosicion = new Posicion(5 , 350);
			miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
		}
		else if(proximaPosicion != null && !miJuego.getMiGrilla().buscarColisiones(this, proximaPosicion) ) {
			miPosicion = proximaPosicion;
			miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
		}
	}
	
	private void moverVerticalmente(int desplazamiento) {
		Posicion proximaPosicion = null;
		if(desplazamiento == Entidad.sentidoArriba ) {
			proximaPosicion = new Posicion( miPosicion.getX(), miPosicion.getY() - 5 );
		}
		else if(desplazamiento == Entidad.sentidoAbajo ) {
			proximaPosicion = new Posicion( miPosicion.getX(), miPosicion.getY() + 5 );
		}
		if(proximaPosicion != null && !miJuego.getMiGrilla().buscarColisiones(this, proximaPosicion)) {
			miPosicion = proximaPosicion;
			miRepresentacion.setLocation((int) miPosicion.getX() , (int) miPosicion.getY());
		}
	}
	
	public void morir() {
		
	}
}



