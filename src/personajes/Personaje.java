package personajes;

import entidadesLogicas.Bloque;
import entidadesLogicas.Entidad;
import entidadesLogicas.Posicion;
import gui.Ventana;

/**
 * Class Personaje - Representa un Personaje del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public abstract class Personaje extends Entidad {
	
	private static final int desplazamientoPixeles = 5;
	protected int velocidadActual;
	
	/**
	 * Establece la velocidad de movimiento del personaje.
	 * @param velocidadActual velocidad de movimiento actual.
	 */
	public void setVelocidadActual(int velocidadActual) {
		this.velocidadActual = velocidadActual;
	}
	
	/**
	 * Realiza un movimiento del personaje dentro del mapa del juego.
	 */
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
		chequearColisionesEntidades();
	}
	
	/**
	 * Realiza la traslación de la entidad dentro del mapar del juego.
	 * @param nuevaPosicion Posicion destino de la entidad.
	 */
	private void traslacionEfectiva(Posicion nuevaPosicion) {
		Bloque bloqueAnterior = miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque);
		Bloque bloqueNuevo = miJuego.getGrilla().getBloque(nuevaPosicion.getY() / Ventana.pixelesBloque, nuevaPosicion.getX() / Ventana.pixelesBloque);
		
		if (bloqueAnterior != bloqueNuevo) {
			miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque, miPosicion.getX() / Ventana.pixelesBloque).borrarDeListaDeEntidades(this);
			miJuego.getGrilla().getBloque(nuevaPosicion.getY() / Ventana.pixelesBloque, nuevaPosicion.getX() / Ventana.pixelesBloque).agregarAListaEntidades(this);
		}
		
		miPosicion = nuevaPosicion;
		miRepresentacion.setLocation(miPosicion.getX(), miPosicion.getY());
	}
	
	/**
	 * Calcula la proxima posicion de desplazamiento lateral.
	 * @param sentidoLigado sentido del personaje.
	 * @return Proxima posicion lateral del personaje.
	 */
	private Posicion calcularProximaPosicionLateral(int sentidoLigado) {
		Posicion proximaPosicion = null;
		
		if (sentidoLigado == Entidad.sentidoDerecha ) {
			proximaPosicion = new Posicion(miPosicion.getX() + desplazamientoPixeles, miPosicion.getY());
		}
		else if (sentidoLigado == Entidad.sentidoIzquierda ) {
			proximaPosicion = new Posicion(miPosicion.getX() - desplazamientoPixeles,  miPosicion.getY());	
		}
		
		return proximaPosicion;
	}
	
	/**
	 * Calcula la proxima posicion de desplazamiento vertical.
	 * @param sentidoLigado sentido del personaje.
	 * @return Proxima posicion lateral del vertical.
	 */
	private Posicion calcularProximaPosicionVertical(int sentidoLigado) {
		Posicion proximaPosicion = null;
		
		if (sentidoLigado == Entidad.sentidoArriba) {
			proximaPosicion = new Posicion(miPosicion.getX(), miPosicion.getY() - desplazamientoPixeles);
		}
		else if (sentidoLigado == Entidad.sentidoAbajo) {
			proximaPosicion = new Posicion(miPosicion.getX(), miPosicion.getY() + desplazamientoPixeles);	
		}
		
		return proximaPosicion;
	}
	
	/**
	 * Realiza un movimiento lateral del personaje.
	 */
	private void moverLateralmente() {
		Posicion proximaPosicion;
		// Calcula la proxima posicion en Y (para doblar / cambiar de direccion)
		proximaPosicion = calcularProximaPosicionVertical(sentidoSiguiente);
		// Si puede doblar inmediatamente
		if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoSiguiente, proximaPosicion)) {
			setSentidoActual(getSentidoSiguiente());
			traslacionEfectiva(proximaPosicion);
		} 
		else {
			proximaPosicion = calcularProximaPosicionLateral(sentidoActual);
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
				proximaPosicion = calcularProximaPosicionVertical(sentidoSiguiente);
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
	
	/**
	 * Realiza un movimiento vertical del personaje.
	 */
	private void moverVerticalmente() {
		Posicion proximaPosicion;
		
		// Calcula la proxima posicion en X (para doblar / cambiar de direccion)
		proximaPosicion = calcularProximaPosicionLateral(sentidoSiguiente);
		// Si puede doblar inmediatamente
		if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoSiguiente, proximaPosicion)) {
			setSentidoActual(getSentidoSiguiente());
			traslacionEfectiva(proximaPosicion);
		} 
		else {
			proximaPosicion = calcularProximaPosicionVertical(sentidoActual);
			if (proximaPosicion != null && !miJuego.getGrilla().buscarColisiones(sentidoActual, proximaPosicion)) {
				// se avanza en el sentidoActual
				traslacionEfectiva(proximaPosicion);
				
				// Se calcula la proxima posicion (para doblar / cambiar de direccion) desde una posicion mas cercana a la curva
				proximaPosicion = calcularProximaPosicionLateral(sentidoSiguiente);
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
	
	/**
	 * Chequea las colisiones del personaje con otras entidades del juego.
	 */
	public abstract void chequearColisionesEntidades();
	
	/**
	 * Consulta la velocidad actual del personaje.
	 * @return velocidad actual.
	 */
	public int getVelocidadActual() {
		return velocidadActual;
	}
	
}
