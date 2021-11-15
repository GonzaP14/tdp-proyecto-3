package launcher;

import entidadesLogicas.DominioJuego;
import entidadesLogicas.BuilderNivel;
import entidadesLogicas.Juego;
import gui.SplashScreen;
import gui.Ventana;

public class Launcher {
	
	private static DominioJuego dominioJuego;
	private static Juego miJuego;
	private static Ventana miVentana;
	private static SplashScreen miSplashScreen;
	private static BuilderNivel miNivel;
	private static int nivelActual;
	
	public static void main(String[] args) {
		dominioJuego = new DominioJuego();
		miSplashScreen = new SplashScreen(dominioJuego);
		miSplashScreen.setBounds(100, 0, 1500, 500);
		miSplashScreen.setVisible(true);
		nivelActual = 1;
		
		if (dominioJuego.getDominioJuego() != 99) {		
			iniciarJuego(dominioJuego);
			construirNivel();
			iniciarVentana();
		}
	}
	
	private static void construirNivel() {
		miNivel = new BuilderNivel();
		miNivel.setGrilla(miJuego.getGrilla());
		miNivel.setDominio(miJuego.getDominio());
		miNivel.setNivelActual(nivelActual);
		if(nivelActual == 1) 
			construirNivel1();
		else if(nivelActual == 2)
			construirNivel2();
		else
			construirNivel3();
		
		miJuego.setBuilder(miNivel);
	}

	public static void iniciarJuego(DominioJuego dominio) {
		miJuego = new Juego(dominio);
	}
	
	public static void iniciarVentana() {
		miVentana = new Ventana(miJuego);
		miVentana.setVisible(true);
	}
	
	private static void construirNivel1() {
		miNivel.setVelocidadEnemigos(8);
		miNivel.setDuracionFrutas(100);
		miNivel.setDuracionPowerPellet(100);
		miNivel.setDuracionPociones(100);
	}
	
	private static void construirNivel2() {
		miNivel.setVelocidadEnemigos(9);
		miNivel.setDuracionFrutas(75);
		miNivel.setDuracionPowerPellet(100);
		miNivel.setDuracionPociones(100);
	}
	
	private static void construirNivel3() {
		miNivel.setVelocidadEnemigos(10);
		miNivel.setDuracionFrutas(50);
		miNivel.setDuracionPowerPellet(100);
		miNivel.setDuracionPociones(100);
	}

}
