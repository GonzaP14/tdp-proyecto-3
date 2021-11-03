package launcher;

import entidadesLogicas.DominioJuego;
import entidadesLogicas.BuilderNivel;
import entidadesLogicas.Juego;
import entidadesLogicas.Nivel1;
import gui.SplashScreen;
import gui.Ventana;
import productos.FabricaEntidades;
import productos.FabricaMarioBros;
import productos.FabricaMemoji;

public class Launcher {
	private static DominioJuego dominioJuego;
	private static Juego miJuego;
	private static Ventana miVentana;
	private static SplashScreen miSplashScreen;
	private static BuilderNivel miNivel;
	
	public static void main(String[] args) {
		dominioJuego = new DominioJuego();
		miSplashScreen = new SplashScreen(dominioJuego);
		miSplashScreen.setBounds(100, 200, 640, 480);
		miSplashScreen.setVisible(true);
		miNivel = new Nivel1();
		if (dominioJuego.getDominioJuego() == DominioJuego.dominioMarioBros) {
			iniciarJuego(miNivel, new FabricaMarioBros(miJuego));
		}
		else if (dominioJuego.getDominioJuego() == DominioJuego.dominioMemoji){
			iniciarJuego(miNivel, new FabricaMemoji(miJuego));
		}
	}
	
	public static void iniciarJuego(BuilderNivel miNivel, FabricaEntidades fabricaEntidades) {
		miJuego = new Juego(miNivel, fabricaEntidades);
		miVentana = new Ventana(miJuego);
		miVentana.setVisible(true);
	}
}
