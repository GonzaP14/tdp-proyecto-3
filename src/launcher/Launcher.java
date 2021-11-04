package launcher;

import entidadesLogicas.DominioJuego;
import entidadesLogicas.BuilderNivel;
import entidadesLogicas.Juego;
import entidadesLogicas.Nivel1;
import gui.SplashScreen;
import gui.Ventana;

public class Launcher {
	private static DominioJuego dominioJuego;
	private static Juego miJuego;
	private static Ventana miVentana;
	private static SplashScreen miSplashScreen;
	private static BuilderNivel miNivel;
	
	public static void main(String[] args) {
		dominioJuego = new DominioJuego();
		miSplashScreen = new SplashScreen(dominioJuego);
		miSplashScreen.setBounds(100, 0, 1500, 500);
		miSplashScreen.setVisible(true);
		miNivel = new Nivel1();
		iniciarJuego(miNivel, dominioJuego.getDominioJuego() );
	}
	
	public static void iniciarJuego(BuilderNivel miNivel, int dominio) {
		miJuego = new Juego(miNivel, dominio);
		miVentana = new Ventana(miJuego);
		miVentana.setVisible(true);
	}
}
