package launcher;

import entidadesLogicas.DominioJuego;
import entidadesLogicas.BuilderNivel;
import entidadesLogicas.Juego;
import entidadesLogicas.Nivel;
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
		miSplashScreen = new SplashScreen();
		nivelActual = 0;
		dominioJuego = miSplashScreen.getDominio();
		if (dominioJuego != null) { // si el dominio es nulo, se cerro la splashscreen desde el exit button sin seleccionar un dominio
			iniciarJuego(dominioJuego);
			construirNivel();
			iniciarVentana();
		}
	}
	
	private static void construirNivel() {
		nivelActual++;
		miNivel = new BuilderNivel();
		miNivel.setNivelActual(nivelActual);
		miNivel.setGrilla(miJuego.getGrilla());
		miNivel.setDominio(miJuego.getDominio());
		
		if (nivelActual == 1) { 
			construirNivel1();
		}
		else if (nivelActual == 2) {
			construirNivel2();
		}
		else if (nivelActual == 3) {
			construirNivel3();
		}
		
		miJuego.setNivel(miNivel.getProduct());
	}
	
	public static void pasarNivel() {
		construirNivel();
		miJuego.reiniciarNivel();
	}

	public static void iniciarJuego(DominioJuego dominio) {
		miJuego = new Juego(dominio);
	}
	
	public static void iniciarVentana() {
		miVentana = new Ventana(miJuego, dominioJuego);
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
