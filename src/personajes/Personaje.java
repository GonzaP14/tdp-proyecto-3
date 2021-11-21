package personajes;

import entidadesLogicas.Bloque;
import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;

public abstract class Personaje extends Entidad {
	
	protected int velocidadActual;
	
	public int getVelocidadActual() {
		return velocidadActual;
	}
	
	public void setVelocidadActual(int velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	
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
	
	private void traslacionEfectiva(Posicion nuevaPosicion) {
		Bloque bloqueAnterior = miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25);
		Bloque bloqueNuevo = miJuego.getGrilla().getBloque(nuevaPosicion.getY() / 25, nuevaPosicion.getX() / 25);
		
		if (bloqueAnterior != bloqueNuevo) {
			miJuego.getGrilla().getBloque(miPosicion.getY() / 25 , miPosicion.getX() / 25).borrarDeListaDeEntidades(this);
			miJuego.getGrilla().getBloque(nuevaPosicion.getY() / 25 , nuevaPosicion.getX() / 25).agregarAListaEntidades(this);
		}
		miPosicion = nuevaPosicion;
		miRepresentacion.setLocation( miPosicion.getX() ,  miPosicion.getY());
	}
	
	private Posicion calcularProximaPosicionX(int sentidoLigado) {
		Posicion proximaPosicion = null;
		if(sentidoLigado == Entidad.sentidoDerecha ) {
			proximaPosicion = new Posicion( miPosicion.getX() + 5, miPosicion.getY());
		}
		else if(sentidoLigado == Entidad.sentidoIzquierda ) {
			proximaPosicion = new Posicion( miPosicion.getX() - 5,  miPosicion.getY());	
		}
		return proximaPosicion;
	}
	
	private Posicion calcularProximaPosicionY(int sentidoLigado) {
		Posicion proximaPosicion = null;
		if(sentidoLigado == Entidad.sentidoArriba ) {
			proximaPosicion = new Posicion( miPosicion.getX(), miPosicion.getY() - 5);
		}
		else if(sentidoLigado == Entidad.sentidoAbajo ) {
			proximaPosicion = new Posicion( miPosicion.getX(),  miPosicion.getY() + 5);	
		}
		return proximaPosicion;
	}
	
	
	
	private void moverLateralmente() {
		Posicion proximaPosicion;
		// Calcula la proxima posicion en Y (para doblar / cambiar de direccion)
		proximaPosicion = calcularProximaPosicionY(sentidoSiguiente);
		// Si puede doblar inmediatamente
		if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoSiguiente, proximaPosicion)) {
			setSentidoActual(getSentidoSiguiente());
			traslacionEfectiva(proximaPosicion);
		} 
		else {
			proximaPosicion = calcularProximaPosicionX(sentidoActual);
			// Tunnels
			if(proximaPosicion != null && proximaPosicion.equals(new Posicion(-5 , 350))) {
				traslacionEfectiva(new Posicion(670 , 350));
			}
			else if(proximaPosicion != null && proximaPosicion.equals(new Posicion(675 , 350))) {
				traslacionEfectiva(new Posicion(5 , 350));
			}
			else if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoActual, proximaPosicion)) {
				// se avanza en el sentidoActual
				traslacionEfectiva(proximaPosicion);
				
				// Se calcula la proxima posicion (para doblar / cambiar de direccion) desde una posicion mas cercana a la curva
				proximaPosicion = calcularProximaPosicionY(sentidoSiguiente);
				// Si puede doblar luego de haber avanzado en el sentido actual, intenta doblar nuevamente
				if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoSiguiente, proximaPosicion)) { 
					setSentidoActual(getSentidoSiguiente());
				}
				// Si no puede doblar tampoco mediante redondeo, se descarta la peticion de doblar
				else { 
					setSentidoSiguiente(getSentidoActual());
				}
			}
		}
	}
	

	private void moverVerticalmente() {
		Posicion proximaPosicion;
		
		// Calcula la proxima posicion en X (para doblar / cambiar de direccion)
		proximaPosicion = calcularProximaPosicionX(sentidoSiguiente);
		// Si puede doblar inmediatamente
		if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoSiguiente, proximaPosicion)) {
			setSentidoActual(getSentidoSiguiente());
			traslacionEfectiva(proximaPosicion);
		} 
		else {
			proximaPosicion = calcularProximaPosicionY(sentidoActual);
			if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoActual, proximaPosicion)) {
				// se avanza en el sentidoActual
				traslacionEfectiva(proximaPosicion);
				
				// Se calcula la proxima posicion (para doblar / cambiar de direccion) desde una posicion mas cercana a la curva
				proximaPosicion = calcularProximaPosicionX(sentidoSiguiente);
				// Si puede doblar luego de haber avanzado en el sentido actual, intenta doblar nuevamente
				if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoSiguiente, proximaPosicion)) {
					setSentidoActual(getSentidoSiguiente());
				}
				// Si no puede doblar tampoco mediante redondeo, se descarta la peticion de doblar
				else {
					setSentidoSiguiente(getSentidoActual());
				}
			}
		}
	}
	
	public abstract void checkeoColisionesPersonaje();
}



