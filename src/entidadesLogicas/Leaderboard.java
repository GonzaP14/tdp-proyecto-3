package entidadesLogicas;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Leaderboard implements Serializable{
	
	// Atributos de clase
	private static final long serialVersionUID = 1L;
	// Atributos de instancia
	private List<Player> ranking;
	
	/**
	 * Crea un ranking para almacenar jugadores.
	 */
	public Leaderboard() {
		ranking = new ArrayList<Player>();
	}
	
	/**
	 * Agrega un jugador al ranking.
	 * @param p El jugador a agregar.
	 */
	public void addPlayer( Player p ) {
		recuperarLeaderboard();
		ranking.add(p);
		actualizarLeaderboard();
	}

	/**
	 * Ordena el ranking en el orden inverso al que determina la comparacion por defecto entre jugadores.
	 */
	private void ordenar() {
		Collections.sort(this.ranking, Collections.reverseOrder());
	}

	/**
	 * Actualiza de manera persistente el ranking, para no perder la informacion del mismo al finalizar una determinada ejecucion del juego.
	 */
	public void actualizarLeaderboard() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(Juego.configuration.getProperty("file"));
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(ranking);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	} 
	
	/**
	 * Recupera la ultima version del ranking.
	 */
	@SuppressWarnings("unchecked")
	public void recuperarLeaderboard() {
		try {
			FileInputStream fileInputStream = new FileInputStream(Juego.configuration.getProperty("file"));
		    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		    ranking = (List<Player>) objectInputStream.readObject();
		    objectInputStream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return Devuelve el ranking actual del juego.
	 */
	public String getLeaderboard() {
		recuperarLeaderboard();
		ordenar();
		String toReturn = "<html>";
		int i = 0;
		for(Player p : this.ranking) {
			toReturn += p.getNombre() + " " + p.getScore() + "<br>"; 
			if( i== 5 ) break;
			i++;
		}
		return toReturn+="</html>";
	}
}
