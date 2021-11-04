package productos;

import javax.swing.ImageIcon;
import entidadesGraficas.ElementoGrafico;
import entidadesGraficas.EnemigoGrafico;
import entidadesGraficas.PrincipalGrafico;
import entidadesLogicas.Juego;
import personajes.*;
import elementos.*;

public class FabricaMarioBros extends FabricaEntidades {
	public FabricaMarioBros(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
	@Override
	public Principal getPrincipal() {
		String[] imagenes = new String[5];
		imagenes[0] = "/recursosMarioBros/MarioArriba.gif";
		imagenes[1] = "/recursosMarioBros/MarioAbajo.gif";
		imagenes[2] = "/recursosMarioBros/MarioDerecha.gif";
		imagenes[3] = "/recursosMarioBros/MarioIzquierda.gif";
		imagenes[4] = "/recursosMarioBros/MarioMuerto.gif";
		
		return Principal.getPrincipal(miJuego, imagenes);
	}
	
	@Override
	public Enemigo getBlinky() {
		String[] imagenes = new String[6];
		
		imagenes[0] = ("/recursosMarioBros/GoompaArriba.gif");
		imagenes[1] = ("/recursosMarioBros/GoompaAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/GoompaDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/GoompaIzquierda.gif");
		imagenes[4] = ("/recursosMarioBros/GoompaMuerto.gif");
		imagenes[5] = ("/recursosMarioBros/GoompaEscapando.gif");

		return new Blinky(miJuego, imagenes);
	}
	
	@Override
	public Enemigo getPinky() {
		String[] imagenes = new String[6];
		imagenes[0] = ("/recursosMarioBros/BooArriba.gif");
		imagenes[1] = ("/recursosMarioBros/BooAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/BooDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/BooIzquierda.gif"); 
		imagenes[4] = ("/recursosMarioBros/BooMuerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/BooEscapando.gif"); 
		
		return new Pinky(miJuego, imagenes);
	}	

	@Override
	public Enemigo getInky() {
		String[] imagenes = new String[6];
		imagenes[0] = ("/recursosMarioBros/BowserArriba.gif");
		imagenes[1] = ("/recursosMarioBros/BowserAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/BowserDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/BowserIzquierda.gif"); 
		imagenes[4] = ("/recursosMarioBros/BowserMuerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/BowserEscapando.gif"); 
		
		return new Inky(miJuego, imagenes);
	}

	@Override
	public Enemigo getClyde() {
		String[] imagenes = new String[6];
		imagenes[0] = ("/recursosMarioBros/KoopaTroopaArriba.gif");
		imagenes[1] = ("/recursosMarioBros/KoopaTroopaAbajo.gif");
		imagenes[2] = ("/recursosMarioBros/KoopaTroopaDerecha.gif");
		imagenes[3] = ("/recursosMarioBros/KoopaTroopaIzquierda.gif"); 
		imagenes[4] = ("/recursosMarioBros/KoopaTroopaMuerto.gif"); 
		imagenes[5] = ("/recursosMarioBros/KoopaTroopaEscapando.gif"); 
		
		return new Clyde(miJuego, imagenes);
	}

	@Override
	public Elemento getFruta() {
		String imagen = ("/recursosMarioBros/Flor.png");
		
		return new Fruta(miJuego, imagen, new HiloElemento());
	}
	
	public Pocion getPocionVelocidad() {
		String imagen = ("/recursosMarioBros/HongoVerde.png");
		
		return new PocionVelocidad(miJuego, imagen);
	}
	
	@Override
	public Pocion getPocionCongelacion() {
		String imagen = ("/recursosMarioBros/HongoRojo.png");
		
		return new PocionCongelacion(miJuego, imagen);
	}

	@Override
	public Elemento getPowerPellet() {
		String imagen = ("/recursosMarioBros/Estrella.png");
		
		return new PowerPellet(miJuego, imagen);
	}

	@Override
	public Elemento getPacDot() {
		String imagen = ("/recursosMarioBros/Moneda.png");
		
		return new PacDot(miJuego, imagen);
	}

}
