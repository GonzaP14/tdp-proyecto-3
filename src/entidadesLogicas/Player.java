package entidadesLogicas;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Integer score;
	
	public Player(  ) {
		nombre="";
		score=0;
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(int puntos) {
		score=score+puntos;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	@Override
	public int compareTo(Player jugador) {
		return score.compareTo(jugador.getScore());
	}
}
