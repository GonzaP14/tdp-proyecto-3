package dominios;

public interface DominioJuego {
	
	/**
	 * Se devuelve los paths de las skins que va a tener el principal
	 * @return los paths de las skins que va a tener el principal
	 */
	public String [] getSkinsPrincipal();

	/**
	 * Se devuelve los paths de las skins que va a tener Blinky
	 * @return los paths de las skins que va a tener Blinky
	 */
	public String [] getSkinsBlinky();
	
	/**
	 * Se devuelve los paths de las skins que va a tener Pinky
	 * @return los paths de las skins que va a tener Pinky
	 */
	public String [] getSkinsPinky();
	
	/**
	 * Se devuelve los paths de las skins que va a tener Inky
	 * @return los paths de las skins que va a tener Inky
	 */
	public String [] getSkinsInky();
	
	/**
	 * Se devuelve los paths de las skins que va a tener Clyde
	 * @return los paths de las skins que va a tener Clyde
	 */
	public String [] getSkinsClyde();
	
	/**
	 * Se devuelve los paths de las skins que va a tener la fruta
	 * @return los paths de las skins que va a tener fruta
	 */
	public String[] getFruta();
	
	/**
	 * Se devuelve los paths de las skins que va a tener la pocion de velocidad
	 * @return los paths de las skins que va a tener pocion de velocidad
	 */
	public String[] getPocionVelocidad();
	
	/**
	 * Se devuelve los paths de las skins que va a tener la pocion bomba
	 * @return los paths de las skins que va a tener pocion bomba
	 */
	public String[] getPocionBomba();
	
	/**
	 * Se devuelve los paths de las skins que va a tener el powerpellet
	 * @return los paths de las skins que va a tener powerpellet
	 */
	public String[] getPowerPellet();
	
	/**
	 * Se devuelve los paths de las skins que va a tener el pacdot
	 * @return los paths de las skins que va a tener pacdot
	 */
	public String[] getPacDot();
	
	/**
	 * Devuelve el path de la musica
	 * @return path de la musica
	 */
	public String getMusica();
	
	/**
	 * Devuelve el path del sonido cuando el jugador pierde
	 * @return path del sonido cuando el jugador pierde
	 */
	public String getSonidoGameOver();
	
	/**
	 * Devuelve el path del sonido cuando el jugador gane
	 * @return path del sonido cuando el jugador gane
	 */
	public String getSonidoWin();
	
	/**
	 * Devuelve el path de la skin de la pared nivel 1
	 * @return path de la skin de la pared nivel 1
	 */
	public String getParedNivel1();
	
	/**
	 * Devuelve el path de la skin de la pared nivel 2
	 * @return path de la skin de la pared nivel 2
	 */
	public String getParedNivel2();
	
	/**
	 * Devuelve el path de la skin de la pared nivel 3
	 * @return path de la skin de la pared nivel 3
	 */
	public String getParedNivel3();
	
	/**
	 * Devuelve el path de la skin de la puerta
	 * @return path de la skin de la puerta
	 */
	public String getPuerta();
	
	/**
	 * Devuelve el path de la skin de la imagen de las vidas
	 * @return path de la skin de la imagen de las vidas
	 */
	public String getImagenVidas();
	
}
