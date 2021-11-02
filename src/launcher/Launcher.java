package launcher;

import entidadesLogicas.Juego;
import gui.Ventana;

public class Launcher {
	private static int dominioJuego;
	private static Juego miJuego;
	private static Ventana miVentana;
	
	public static void main(String[] args) {
		
		miJuego = new Juego(dominioJuego);
		miVentana = new Ventana(miJuego);
		miVentana.setVisible(true);
	}
	
	public void setDominioJuego(int dominio) {
		dominioJuego = dominio;
	}
	
	public void iniciarJuego() {
		
	}

}
