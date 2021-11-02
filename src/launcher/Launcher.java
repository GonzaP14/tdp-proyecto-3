package launcher;

import entidadesLogicas.Juego;
import gui.Ventana;

public class Launcher {
	private static int dominioJuego;
	private static Juego miJuego;
	private static Ventana miVentana;
	
	public static void main(String[] args) {
		
	}
	
	public void setDominioJuego(int dominio) {
		dominioJuego = dominio;
	}
	
	public void iniciarJuego() {
		miJuego = new Juego(dominioJuego); // tambien lleva nivel al juego
		miVentana = new Ventana(miJuego);
		miVentana.setVisible(true);
	}
}
