package entidadesLogicas;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable{
	private String nombre;
	private Integer score;
	
	public Player( String name, Integer puntos ) {
		this.nombre = name;
		this.score = puntos;
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public Integer getScore() {
		return score;
	}
	
	@Override
	public int compareTo(Player jugador) {
		return score.compareTo(jugador.getScore());
	}
}
