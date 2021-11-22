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
	
	private static final long serialVersionUID = 1L;
	
	private List<Player> ranking;
	
	public Leaderboard() {
		ranking = new ArrayList<Player>();
	}
	
	public void addPlayer( Player p ) {
		recuperarLeaderboard();
		ranking.add(p);
		actualizarLeaderboard();
	}
	
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

	private void ordenar() {
		Collections.sort(this.ranking, Collections.reverseOrder());
	}

	
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
}
