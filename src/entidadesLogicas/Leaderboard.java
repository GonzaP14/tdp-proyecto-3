package entidadesLogicas;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Leaderboard implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Player> ranking;
	
	public Leaderboard() {
		ranking = new ArrayList<Player>();
	}
	
	public void addPlayer( Player p ) {
		ranking.add(p);
	}
	
	public void printPlayers() {
		Collections.sort(this.ranking, Collections.reverseOrder());
		System.out.println();
		System.out.println("Mejores Jugadores");
		int i = 0;
		for(Player p : ranking) {
			System.out.println(p.getNombre() + " " + p.getScore());
			if( i== 5 ) break;
			i++;
		}
	}
}
