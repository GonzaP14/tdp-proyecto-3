package niveles;

import dominios.DominioJuego;
import entidadesLogicas.Grilla;

/**
 * Interfaz referida a Builder (design pattern), que abstrae el comportamiento
 * ligado a la preparacion de un nuevo nivel y dominio para el juego.
 * @author Grupo 2 TDP. 2021
 */
public interface Builder {
	/**
	 * Inicializa un nuevo nivel (o reinicializa, dependiendo el contexto)
	 */
	public void reset();
	
	/**
	 * Establece la grilla para el nivel ligado.
	 * @param g grilla para el nivel ligado
	 */
	public void setGrilla(Grilla g);
	
	/**
	 * Establece el valor numerico del nivel actual.
	 * @param n valor del nivel actual
	 */
	public void setNivelActual(int n);
	
	/**
	 * Establece el dominio para el juego actual.
	 * @param d dominio a establecer
	 */
	public void setDominio(DominioJuego d);
	
	/**
	 * Establece la duracion de los Power Pellets para el nivel actual.
	 * @param d duracion, medido en ticks del reloj ligado al juego.
	 */
	public void setDuracionPowerPellet(int d);
	
	/**
	 * Establece la duracion de las pociones para el nivel actual.
	 * @param d duracion, medido en ticks del reloj ligado al juego.
	 */
	public void setDuracionPociones(int d);
	
	/**
	 * Establece la duracion de las frutas para el nivel actual.
	 * @param d duracion, medido en ticks del reloj ligado al juego.
	 */
	public void setDuracionFrutas(int d);
	
	/**
	 * Establece la velocidad de los enemigos para el nivel actual.
	 * @param v duracion, medido en ticks del reloj ligado al juego.
	 */
	public void setVelocidadEnemigos(int v);
	
}
