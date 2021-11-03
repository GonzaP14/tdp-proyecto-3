package launcher;

import entidadesLogicas.DominioJuego;
import entidadesLogicas.EstrategiaNivel;
import entidadesLogicas.Juego;
import entidadesLogicas.Nivel1;
import gui.SplashScreen;
import gui.Ventana;
import productos.FabricaEntidades;
import productos.MarioBros;
import productos.Memoji;

public class Launcher {
	private static DominioJuego dominioJuego;
	private static Juego miJuego;
	private static Ventana miVentana;
	private static SplashScreen miSplashScreen;
	private static EstrategiaNivel miNivel;
	
	public static void main(String[] args) {
		dominioJuego = new DominioJuego();
		miSplashScreen = new SplashScreen(dominioJuego);
		miSplashScreen.setBounds(100, 200, 640, 480);
		miSplashScreen.setVisible(true);
		miNivel = new Nivel1();
		if (dominioJuego.getDominioJuego() == 0) {
			iniciarJuego(miNivel, new MarioBros(miJuego));
		}
		else if (dominioJuego.getDominioJuego() == 1){
			iniciarJuego(miNivel, new Memoji(miJuego));
		}
	}
	
	public static void iniciarJuego(EstrategiaNivel miNivel, FabricaEntidades fabricaEntidades) {
		miJuego = new Juego(miNivel, fabricaEntidades);
		miVentana = new Ventana(miJuego);
		miVentana.setVisible(true);
	}
}
