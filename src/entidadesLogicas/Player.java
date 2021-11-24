package entidadesLogicas;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable{
	
	// Atributos de clase
	private static final long serialVersionUID = 7428896111732509389L;
	// Atributos de instancia
	private String nombre;
	private Integer score;
	
	/**
	 * Crea un nuevo jugador.
	 */
	public Player() {
		nombre="";
		score=0;
	}
	
	/**
	 * Aumenta el puntaje del jugador en una cantidad de puntos.
	 * @param puntos La cantidad de puntos a aumentar.
	 */
	public void setScore(int puntos) {
		score += puntos;
	}
	
	/**
	 * Establece el nombre para el jugador.
	 * @param nombre El nombre a asignarle.
	 */
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	/**
	 * Se compara con otro jugador, mediante el puntaje asociado.
	 * @param jugador Jugador con el que se compara
	 * @return Devuelve el resultado de la comparacion.
	 */
	@Override
	public int compareTo(Player jugador) {
		return score.compareTo(jugador.getScore());
	}
	
	/**
	 * 
	 * @return Devuelve el nombre del jugador.
	 */
	public String getNombre () {
		return nombre;
	}
	
	/**
	 * 
	 * @return Devuelve el puntaje asociado al jugador.
	 */
	public Integer getScore() {
		return score;
	}
	
}
