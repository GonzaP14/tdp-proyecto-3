package elementos;

import gui.Ventana;

/**
 * Class Pocion - Representa una pocion del juego.
 * @author Grupo N°2: Bruno Mandolesi, Albano Mazzino, Nicolas Messina, Gonzalo Martin Perez.
 */
public abstract class Pocion extends Elemento {
	
	protected int velocidadOtorgada, puntajeOtorgado;
	
	@Override
	protected void iniciarTimer(HiloElemento timer) {
		timer.start();
	}

	@Override
	public abstract void afectar();
	/**
	 * Despawnea la pocion tanto logica como graficamente
	 */
	public void despawnear() {
		miJuego.getGrilla().getBloque(miPosicion.getY() / Ventana.pixelesBloque , miPosicion.getX() / Ventana.pixelesBloque).borrarDeListaDeEntidades(this);
		miRepresentacion.desaparecer();
	}
	/**
	 * Retorno la velocidad que otorga la pocion en caso de tener
	 * @return velocidad otorgada
	 */
	public int getVelocidadOtorgada() {
		return velocidadOtorgada;
	}
	
	/**
	 * Retorno el puntaje otorgado por la pocion en caso de tener
	 * @return el puntaje otorgado
	 */
	public int getPuntajeOtorgado() {
		return puntajeOtorgado;
	}
}

