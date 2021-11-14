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
		if (getSentidoActual() != getSentidoSiguiente()) {
			// si los sentidos son opuestos (una misma direccion / mismo eje)
			if (getSentidoActual() == Entidad.sentidoAbajo && getSentidoSiguiente() == Entidad.sentidoArriba  || getSentidoActual() == Entidad.sentidoArriba && getSentidoSiguiente() == Entidad.sentidoAbajo
					|| getSentidoActual() == Entidad.sentidoIzquierda && getSentidoSiguiente() == Entidad.sentidoDerecha  || getSentidoActual() == Entidad.sentidoDerecha && getSentidoSiguiente() == Entidad.sentidoIzquierda) {
				setSentidoActual(getSentidoSiguiente());
			}
		}
		
		if(sentidoActual == Entidad.sentidoAbajo || sentidoActual == Entidad.sentidoArriba ) { 
			moverVerticalmente();
		}
		else if(sentidoActual == Entidad.sentidoDerecha || sentidoActual == Entidad.sentidoIzquierda ) {
			moverLateralmente();
		}
		checkeoColisionesPersonaje();
	}
	
	
	
	private void moverLateralmente() {
		Posicion proximaPosicion = null;
		Posicion proximaPosicionRounded = null;
		Posicion proximaPosicionActual = null;
		// doblar
		if(sentidoSiguiente == Entidad.sentidoArriba ) {
			proximaPosicion = new Posicion( miPosicion.getX(), miPosicion.getY() - 5);
		}
		else if(sentidoSiguiente == Entidad.sentidoAbajo ) {
			proximaPosicion = new Posicion( miPosicion.getX(),  miPosicion.getY() + 5);	
		}
		
		// Si puede doblar inmediatamente
		if (proximaPosicion != null && !miJuego.getMiGrilla().buscarColisiones(sentidoSiguiente, proximaPosicion)) {
			miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).borrarDeListaDeEntidades(this);
			setSentidoActual(getSentidoSiguiente());
			miPosicion = proximaPosicion;
			miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
			miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
		} 
		// ---- 
		
		
		else {
			if(sentidoActual == Entidad.sentidoDerecha ) {
				proximaPosicionActual = new Posicion( miPosicion.getX() + 5, miPosicion.getY() );
			}
			else if(sentidoActual == Entidad.sentidoIzquierda ) {
				proximaPosicionActual = new Posicion( miPosicion.getX() - 5,  miPosicion.getY() );	
			}
			
			// Tunnels
			if(proximaPosicionActual != null && proximaPosicionActual.equals(new Posicion(-5 , 350))) {
				miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).borrarDeListaDeEntidades(this);
				miPosicion = new Posicion(670 , 350);
				miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
				miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
			}
			else if(proximaPosicionActual != null && proximaPosicionActual.equals(new Posicion(675 , 350))) {
				miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).borrarDeListaDeEntidades(this);
				miPosicion = new Posicion(5 , 350);
				miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
				miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
			}
			
			else if (proximaPosicionActual != null && !miJuego.getMiGrilla().buscarColisiones(sentidoActual, proximaPosicionActual)) {
				miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).borrarDeListaDeEntidades(this);
				// avanzo en el sentido actual
				miPosicion = proximaPosicionActual;
				miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
				miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
				// Se chequea nuevamente si es posible doblar, desde una posicion mas cercana a la curva
				if(sentidoSiguiente == Entidad.sentidoArriba ) {
					proximaPosicionRounded = new Posicion( miPosicion.getX(), miPosicion.getY() - 5);
				}
				else if(sentidoSiguiente == Entidad.sentidoAbajo ) {
					proximaPosicionRounded = new Posicion( miPosicion.getX(),  miPosicion.getY() + 5);	
				}
				
				if (proximaPosicionRounded != null && !miJuego.getMiGrilla().buscarColisiones(sentidoSiguiente, proximaPosicionRounded)) {
					setSentidoActual(getSentidoSiguiente());
				}
				else {
					setSentidoSiguiente(getSentidoActual());
				}
			}
		}
	}
	
	private void moverVerticalmente() {
		Posicion proximaPosicion = null;
		Posicion proximaPosicionRounded = null;
		Posicion proximaPosicionActual = null;
		
		// doblar
		if(sentidoSiguiente == Entidad.sentidoDerecha ) {
			proximaPosicion = new Posicion( miPosicion.getX() + 5, miPosicion.getY());
		}
		else if(sentidoSiguiente == Entidad.sentidoIzquierda ) {
			proximaPosicion = new Posicion( miPosicion.getX() - 5,  miPosicion.getY());	
		}
		
		// Si puede doblar inmediatamente
		if (proximaPosicion != null && !miJuego.getMiGrilla().buscarColisiones(sentidoSiguiente, proximaPosicion)) {
			miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).borrarDeListaDeEntidades(this);
			setSentidoActual(getSentidoSiguiente());
			miPosicion = proximaPosicion;
			miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
			miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
		} 
		// ---- 
		
		
		else {
			if(sentidoActual == Entidad.sentidoArriba ) {
				proximaPosicionActual = new Posicion( miPosicion.getX(), miPosicion.getY() - 5);
			}
			else if(sentidoActual == Entidad.sentidoAbajo ) {
				proximaPosicionActual = new Posicion( miPosicion.getX(),  miPosicion.getY() + 5);	
			}
			
			if (proximaPosicionActual != null && !miJuego.getMiGrilla().buscarColisiones(sentidoActual, proximaPosicionActual)) {
				miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).borrarDeListaDeEntidades(this);
				// avanzo en el sentido actual
				miPosicion = proximaPosicionActual;
				miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
				miJuego.getMiGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).agregarAListaEntidades(this);
				
				// Se chequea nuevamente si es posible doblar, desde una posicion mas cercana a la curva
				if(sentidoSiguiente == Entidad.sentidoDerecha ) {
					proximaPosicionRounded = new Posicion( miPosicion.getX() + 5, miPosicion.getY());
				}
				else if(sentidoSiguiente == Entidad.sentidoIzquierda ) {
					proximaPosicionRounded = new Posicion( miPosicion.getX() - 5,  miPosicion.getY());	
				}
				
				if (proximaPosicionRounded != null && !miJuego.getMiGrilla().buscarColisiones(sentidoSiguiente, proximaPosicionRounded)) {
					setSentidoActual(getSentidoSiguiente());
				}
				else {
					setSentidoSiguiente(getSentidoActual());
				}
			}
		}
	}
	
	public abstract void checkeoColisionesPersonaje();
	
	public void morir() {
		
	}
}



