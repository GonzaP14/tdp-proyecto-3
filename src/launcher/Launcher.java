package launcher;

import dominios.DominioJuego;
import dominios.DominioMarioBros;
import dominios.DominioSonic;
import entidadesLogicas.Juego;
import gui.SplashScreen;
import gui.Ventana;
import niveles.BuilderNivel;

public class Launcher {
	
	private static DominioJuego dominioJuego;
	private static Juego miJuego;
	private static Ventana miVentana;
	private static SplashScreen miSplashScreen;
	private static BuilderNivel miBuilder;
	private static int nivelActual;
	
	public static void main(String[] args) {
		miSplashScreen = new SplashScreen();
		miSplashScreen.setVisible(true);
		nivelActual = 0;
		
		if (dominioJuego != null) {
			iniciarJuego(dominioJuego);
		}
	}
	
	private static void iniciarJuego(DominioJuego dominio) {
		miJuego = new Juego(dominio);
		miBuilder = new BuilderNivel();
		construirNivel();
		miJuego.setNivel(miBuilder.getProduct());
		iniciarVentana();
		miJuego.iniciarJuego();
	}
	
	private static void iniciarVentana() {
		miVentana = new Ventana(miJuego, dominioJuego);
		miVentana.setVisible(true);
		miJuego.setVentana(miVentana);
	}
	
	public static void crearDominioMarioBros() {
		dominioJuego = new DominioMarioBros();
	}
	
	public static void crearDominioSonic() {
		dominioJuego = new DominioSonic();
	}
	
	private static void construirNivel() {
		nivelActual ++;
		miBuilder.setGrilla(miJuego.getGrilla());
		miBuilder.setNivelActual(nivelActual);
		miBuilder.setDominio(dominioJuego);
		
		if (nivelActual == 1) { 
			construirNivel1();
		}
		else if (nivelActual == 2) {
			construirNivel2();
		}
		else if (nivelActual == 3) {
			construirNivel3();
		}
	}	

	private static void construirNivel1() {
		miBuilder.setVelocidadEnemigos(90);
		miBuilder.setDuracionFrutas(100);
		miBuilder.setDuracionPowerPellet(100);
		miBuilder.setDuracionPociones(100);
	}
	
	private static void construirNivel2() {
		miBuilder.setVelocidadEnemigos(95);
		miBuilder.setDuracionFrutas(75);
		miBuilder.setDuracionPowerPellet(75);
		miBuilder.setDuracionPociones(75);
	}
	
	private static void construirNivel3() {
		miBuilder.setVelocidadEnemigos(100);
		miBuilder.setDuracionFrutas(50);
		miBuilder.setDuracionPowerPellet(50);
		miBuilder.setDuracionPociones(50);
	}

	public static void pasarNivel() {
		miJuego.pausar_despausar();
		miJuego.reset();
		miBuilder.reset();
		construirNivel();
		miJuego.setNivel(miBuilder.getProduct());
		iniciarVentana();
		miJuego.aparecerEntidades();
		miJuego.pausar_despausar();
	}
	
}

